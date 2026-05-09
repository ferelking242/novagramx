package tw.nekomimi.nekogram.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.DownloadController;
import org.telegram.messenger.FileLoader;
import org.telegram.messenger.LocaleController;
import org.telegram.messenger.MessageObject;
import org.telegram.messenger.NotificationCenter;
import org.telegram.messenger.R;
import org.telegram.messenger.UserConfig;
import org.telegram.ui.ActionBar.ActionBar;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Cells.GraySectionCell;
import org.telegram.ui.Components.LayoutHelper;
import org.telegram.ui.Components.RecyclerListView;

import java.util.ArrayList;
import java.util.HashMap;

public class NovagramXDownloadManagerActivity extends BaseFragment
        implements NotificationCenter.NotificationCenterDelegate {

    private static final int FILTER_ALL    = 0;
    private static final int FILTER_PHOTOS = 1;
    private static final int FILTER_VIDEOS = 2;
    private static final int FILTER_AUDIO  = 3;
    private static final int FILTER_FILES  = 4;

    private int currentFilter = FILTER_ALL;
    private int currentAccount;

    private final HashMap<String, long[]> speedTracking  = new HashMap<>();
    private final HashMap<String, Long>   currentSpeeds  = new HashMap<>();

    private RecyclerListView listView;
    private ListAdapter      adapter;
    private TextView         statsView;
    private LinearLayout     filterBar;

    @Override
    public View createView(Context context) {
        currentAccount = UserConfig.selectedAccount;

        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setTitle(LocaleController.getString(R.string.NovagramXDownloadManager));
        actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() {
            @Override
            public void onItemClick(int id) {
                if (id == -1) finishFragment();
            }
        });

        FrameLayout contentView = new FrameLayout(context);
        contentView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        fragmentView = contentView;

        LinearLayout root = new LinearLayout(context);
        root.setOrientation(LinearLayout.VERTICAL);
        contentView.addView(root, LayoutHelper.createFrame(
                LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT));

        statsView = new TextView(context);
        statsView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
        statsView.setGravity(Gravity.CENTER_HORIZONTAL);
        statsView.setPadding(AndroidUtilities.dp(16), AndroidUtilities.dp(10),
                AndroidUtilities.dp(16), AndroidUtilities.dp(10));
        statsView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText6));
        statsView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        root.addView(statsView, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));

        View divider1 = new View(context);
        divider1.setBackgroundColor(Theme.getColor(Theme.key_divider));
        root.addView(divider1, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, 1));

        filterBar = new LinearLayout(context);
        filterBar.setOrientation(LinearLayout.HORIZONTAL);
        filterBar.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        filterBar.setPadding(AndroidUtilities.dp(8), AndroidUtilities.dp(6),
                AndroidUtilities.dp(8), AndroidUtilities.dp(6));
        root.addView(filterBar, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, 44));

        String[] labels = {
            LocaleController.getString(R.string.DLFilterAll),
            LocaleController.getString(R.string.DLFilterPhotos),
            LocaleController.getString(R.string.DLFilterVideos),
            LocaleController.getString(R.string.DLFilterAudio),
            LocaleController.getString(R.string.DLFilterFiles)
        };
        for (int i = 0; i < labels.length; i++) {
            final int idx = i;
            FilterChip chip = new FilterChip(context, labels[i]);
            chip.setOnClickListener(v -> {
                currentFilter = idx;
                refreshFilterBar();
                if (adapter != null) adapter.updateData();
            });
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
            lp.setMargins(AndroidUtilities.dp(2), 0, AndroidUtilities.dp(2), 0);
            filterBar.addView(chip, lp);
        }
        refreshFilterBar();

        View divider2 = new View(context);
        divider2.setBackgroundColor(Theme.getColor(Theme.key_divider));
        root.addView(divider2, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, 1));

        LinearLayout actionRow = new LinearLayout(context);
        actionRow.setOrientation(LinearLayout.HORIZONTAL);
        actionRow.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        actionRow.setPadding(AndroidUtilities.dp(8), AndroidUtilities.dp(6),
                AndroidUtilities.dp(8), AndroidUtilities.dp(6));
        root.addView(actionRow, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, 44));

        TextView cancelAllBtn = makeActionButton(context,
                LocaleController.getString(R.string.DLCancelAll), true);
        cancelAllBtn.setOnClickListener(v -> cancelAllActive());
        actionRow.addView(cancelAllBtn, new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));

        View sep = new View(context);
        sep.setBackgroundColor(Theme.getColor(Theme.key_divider));
        actionRow.addView(sep, new LinearLayout.LayoutParams(1, LinearLayout.LayoutParams.MATCH_PARENT));

        TextView clearBtn = makeActionButton(context,
                LocaleController.getString(R.string.DLClearCompleted), false);
        clearBtn.setOnClickListener(v -> clearCompleted());
        actionRow.addView(clearBtn, new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));

        View divider3 = new View(context);
        divider3.setBackgroundColor(Theme.getColor(Theme.key_divider));
        root.addView(divider3, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, 1));

        listView = new RecyclerListView(context);
        listView.setLayoutManager(new LinearLayoutManager(context));
        listView.setAdapter(adapter = new ListAdapter(context));
        listView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        root.addView(listView, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, 0, 1f));

        updateStats();
        return contentView;
    }

    private TextView makeActionButton(Context ctx, String text, boolean danger) {
        TextView tv = new TextView(ctx);
        tv.setText(text);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
        tv.setGravity(Gravity.CENTER);
        tv.setTypeface(AndroidUtilities.bold());
        tv.setTextColor(danger
                ? Theme.getColor(Theme.key_text_RedBold)
                : Theme.getColor(Theme.key_windowBackgroundWhiteBlueText));
        tv.setBackground(Theme.createSimpleSelectorRoundRectDrawable(
                AndroidUtilities.dp(6),
                Theme.getColor(Theme.key_windowBackgroundWhite),
                Theme.getColor(Theme.key_listSelector)));
        return tv;
    }

    private void refreshFilterBar() {
        if (filterBar == null) return;
        for (int i = 0; i < filterBar.getChildCount(); i++) {
            FilterChip chip = (FilterChip) filterBar.getChildAt(i);
            chip.setSelected(i == currentFilter);
        }
    }

    private void updateStats() {
        if (statsView == null) return;
        DownloadController dc = DownloadController.getInstance(currentAccount);
        int active    = dc.downloadingFiles.size();
        int completed = dc.recentDownloadingFiles.size();
        long totalSpeed = 0;
        for (Long s : currentSpeeds.values()) totalSpeed += s;
        String speedPart = totalSpeed > 0
                ? "  ·  " + formatSpeed(totalSpeed)
                : "";
        statsView.setText(LocaleController.formatPluralString("DLActiveCount", active)
                + "  ·  "
                + LocaleController.formatPluralString("DLCompletedCount", completed)
                + speedPart);
    }

    private String formatSpeed(long bps) {
        if (bps >= 1024L * 1024) return String.format("%.1f MB/s", bps / 1048576.0);
        if (bps >= 1024)         return String.format("%.0f KB/s", bps / 1024.0);
        return bps + " B/s";
    }

    private boolean matchFilter(MessageObject msg) {
        switch (currentFilter) {
            case FILTER_PHOTOS: return msg.isPhoto();
            case FILTER_VIDEOS: return msg.isVideo() || msg.isRoundVideo();
            case FILTER_AUDIO:  return msg.isMusic() || msg.isVoice();
            case FILTER_FILES:  return !msg.isPhoto() && !msg.isVideo()
                    && !msg.isRoundVideo() && !msg.isMusic() && !msg.isVoice();
            default: return true;
        }
    }

    private void cancelAllActive() {
        DownloadController dc = DownloadController.getInstance(currentAccount);
        ArrayList<MessageObject> copy = new ArrayList<>(dc.downloadingFiles);
        for (MessageObject msg : copy) {
            if (msg.getDocument() != null) {
                FileLoader.getInstance(currentAccount).cancelLoadFile(msg.getDocument());
            }
        }
        currentSpeeds.clear();
        speedTracking.clear();
        AndroidUtilities.runOnUIThread(() -> {
            adapter.updateData();
            updateStats();
        });
    }

    private void clearCompleted() {
        DownloadController.getInstance(currentAccount).recentDownloadingFiles.clear();
        AndroidUtilities.runOnUIThread(() -> {
            adapter.updateData();
            updateStats();
        });
    }

    @Override
    public void onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.fileLoadProgressChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.fileLoaded);
        getNotificationCenter().addObserver(this, NotificationCenter.fileLoadFailed);
    }

    @Override
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.fileLoadProgressChanged);
        getNotificationCenter().removeObserver(this, NotificationCenter.fileLoaded);
        getNotificationCenter().removeObserver(this, NotificationCenter.fileLoadFailed);
        super.onFragmentDestroy();
    }

    @Override
    public void didReceivedNotification(int id, int account, Object... args) {
        if (account != currentAccount) return;
        if (id == NotificationCenter.fileLoadProgressChanged) {
            String fileName = (String) args[0];
            long loaded = (args[1] instanceof Long) ? (Long) args[1] : 0L;
            long now = System.currentTimeMillis();
            long[] track = speedTracking.get(fileName);
            if (track != null) {
                long dt = now - track[0];
                if (dt > 300) {
                    long delta = loaded - track[1];
                    long speed = delta * 1000 / dt;
                    if (speed >= 0) currentSpeeds.put(fileName, speed);
                    speedTracking.put(fileName, new long[]{now, loaded});
                }
            } else {
                speedTracking.put(fileName, new long[]{now, loaded});
            }
            AndroidUtilities.runOnUIThread(() -> {
                if (adapter != null) adapter.updateData();
                updateStats();
            });
        } else if (id == NotificationCenter.fileLoaded || id == NotificationCenter.fileLoadFailed) {
            String fileName = (String) args[0];
            currentSpeeds.remove(fileName);
            speedTracking.remove(fileName);
            AndroidUtilities.runOnUIThread(() -> {
                if (adapter != null) adapter.updateData();
                updateStats();
            });
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM   = 1;
        private static final int TYPE_EMPTY  = 2;

        private final Context ctx;
        private final ArrayList<Object> rows = new ArrayList<>();

        ListAdapter(Context context) {
            this.ctx = context;
            updateData();
        }

        void updateData() {
            rows.clear();
            DownloadController dc = DownloadController.getInstance(currentAccount);

            ArrayList<MessageObject> active = new ArrayList<>();
            for (MessageObject msg : dc.downloadingFiles) {
                if (matchFilter(msg)) active.add(msg);
            }
            if (!active.isEmpty()) {
                rows.add(LocaleController.getString(R.string.DLSectionActive));
                rows.addAll(active);
            }

            ArrayList<MessageObject> done = new ArrayList<>();
            for (MessageObject msg : dc.recentDownloadingFiles) {
                if (matchFilter(msg)) done.add(msg);
            }
            if (!done.isEmpty()) {
                rows.add(LocaleController.getString(R.string.DLSectionCompleted));
                rows.addAll(done);
            }

            if (rows.isEmpty()) rows.add(null);
            notifyDataSetChanged();
        }

        @Override
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            if (viewType == TYPE_HEADER) {
                view = new GraySectionCell(ctx);
                view.setLayoutParams(new RecyclerView.LayoutParams(
                        RecyclerView.LayoutParams.MATCH_PARENT,
                        RecyclerView.LayoutParams.WRAP_CONTENT));
            } else if (viewType == TYPE_ITEM) {
                view = new DownloadItemCell(ctx);
                view.setLayoutParams(new RecyclerView.LayoutParams(
                        RecyclerView.LayoutParams.MATCH_PARENT,
                        RecyclerView.LayoutParams.WRAP_CONTENT));
            } else {
                TextView tv = new TextView(ctx);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                tv.setGravity(Gravity.CENTER);
                tv.setPadding(AndroidUtilities.dp(16), AndroidUtilities.dp(60),
                        AndroidUtilities.dp(16), AndroidUtilities.dp(60));
                tv.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText6));
                tv.setText(LocaleController.getString(R.string.DLEmpty));
                tv.setLayoutParams(new RecyclerView.LayoutParams(
                        RecyclerView.LayoutParams.MATCH_PARENT,
                        RecyclerView.LayoutParams.WRAP_CONTENT));
                view = tv;
            }
            return new RecyclerView.ViewHolder(view) {};
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Object item = rows.get(position);
            if (holder.getItemViewType() == TYPE_HEADER) {
                ((GraySectionCell) holder.itemView).setText((String) item);
            } else if (holder.getItemViewType() == TYPE_ITEM && item instanceof MessageObject) {
                MessageObject msg = (MessageObject) item;
                boolean isActive = DownloadController.getInstance(currentAccount)
                        .downloadingFiles.contains(msg);
                ((DownloadItemCell) holder.itemView).bind(msg, isActive, currentSpeeds);
            }
        }

        @Override
        public int getItemViewType(int position) {
            Object item = rows.get(position);
            if (item == null)          return TYPE_EMPTY;
            if (item instanceof String) return TYPE_HEADER;
            return TYPE_ITEM;
        }

        @Override
        public int getItemCount() {
            return rows.size();
        }
    }

    private class DownloadItemCell extends FrameLayout {

        private final TextView      nameView;
        private final TextView      sizeView;
        private final TextView      speedLabel;
        private final ProgressArc   progressArc;
        private final LinearLayout  progressBarHost;
        private final android.widget.ProgressBar progressBar;
        private final TextView      cancelBtn;
        private final TextView      typeTag;

        DownloadItemCell(Context context) {
            super(context);
            setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            int p = AndroidUtilities.dp(14);
            setPadding(p, AndroidUtilities.dp(10), p, AndroidUtilities.dp(10));

            LinearLayout row = new LinearLayout(context);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER_VERTICAL);

            progressArc = new ProgressArc(context);
            row.addView(progressArc, LayoutHelper.createLinear(36, 36, 0, 0, 10, 0));

            LinearLayout col = new LinearLayout(context);
            col.setOrientation(LinearLayout.VERTICAL);

            nameView = new TextView(context);
            nameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            nameView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            nameView.setMaxLines(1);
            nameView.setEllipsize(TextUtils.TruncateAt.END);
            nameView.setTypeface(AndroidUtilities.bold());
            col.addView(nameView, LayoutHelper.createLinear(
                    LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));

            LinearLayout detailRow = new LinearLayout(context);
            detailRow.setOrientation(LinearLayout.HORIZONTAL);
            detailRow.setGravity(Gravity.CENTER_VERTICAL);

            typeTag = new TextView(context);
            typeTag.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
            typeTag.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
            typeTag.setBackground(Theme.createRoundRectDrawable(
                    AndroidUtilities.dp(3),
                    Theme.getColor(Theme.key_windowBackgroundGray)));
            typeTag.setPadding(AndroidUtilities.dp(4), AndroidUtilities.dp(1),
                    AndroidUtilities.dp(4), AndroidUtilities.dp(1));
            detailRow.addView(typeTag, LayoutHelper.createLinear(
                    LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, 0, 0, 6, 0));

            sizeView = new TextView(context);
            sizeView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            sizeView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
            detailRow.addView(sizeView);

            speedLabel = new TextView(context);
            speedLabel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            speedLabel.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText));
            speedLabel.setPadding(AndroidUtilities.dp(6), 0, 0, 0);
            detailRow.addView(speedLabel);

            col.addView(detailRow, LayoutHelper.createLinear(
                    LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, 0, 3, 0, 0));

            progressBarHost = new LinearLayout(context);
            progressBarHost.setOrientation(LinearLayout.VERTICAL);
            progressBar = new android.widget.ProgressBar(context, null,
                    android.R.attr.progressBarStyleHorizontal);
            progressBar.setMax(10000);
            progressBarHost.addView(progressBar, LayoutHelper.createLinear(
                    LayoutHelper.MATCH_PARENT, 3, 0, 4, 0, 0));
            col.addView(progressBarHost, LayoutHelper.createLinear(
                    LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));

            row.addView(col, LayoutHelper.createLinear(0, LayoutHelper.WRAP_CONTENT, 1f));

            cancelBtn = new TextView(context);
            cancelBtn.setText("✕");
            cancelBtn.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            cancelBtn.setTextColor(Theme.getColor(Theme.key_text_RedBold));
            cancelBtn.setGravity(Gravity.CENTER);
            cancelBtn.setBackground(Theme.createSimpleSelectorRoundRectDrawable(
                    AndroidUtilities.dp(4),
                    Theme.getColor(Theme.key_windowBackgroundWhite),
                    Theme.getColor(Theme.key_listSelector)));
            cancelBtn.setPadding(AndroidUtilities.dp(8), AndroidUtilities.dp(4),
                    AndroidUtilities.dp(8), AndroidUtilities.dp(4));
            row.addView(cancelBtn, LayoutHelper.createLinear(40, 40, 0, 0, 0, 0));

            addView(row, LayoutHelper.createFrame(
                    LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT,
                    Gravity.CENTER_VERTICAL));
        }

        void bind(MessageObject msg, boolean isActive, HashMap<String, Long> speeds) {
            String name = msg.getDocumentName();
            if (TextUtils.isEmpty(name)) name = msg.getFileName();
            if (TextUtils.isEmpty(name)) name = "File";
            nameView.setText(name);

            String tag;
            if (msg.isPhoto())               tag = "Photo";
            else if (msg.isVideo())          tag = "Video";
            else if (msg.isRoundVideo())     tag = "GIF";
            else if (msg.isMusic())          tag = "Audio";
            else if (msg.isVoice())          tag = "Voice";
            else                             tag = "File";
            typeTag.setText(tag);

            long loaded = msg.loadedFileSize;
            long total  = msg.getDocument() != null ? msg.getDocument().size : 0;

            if (isActive) {
                progressBarHost.setVisibility(View.VISIBLE);
                cancelBtn.setVisibility(View.VISIBLE);
                if (total > 0) {
                    int progress = (int) (loaded * 10000L / total);
                    progressBar.setProgress(progress);
                    sizeView.setText(AndroidUtilities.formatFileSize(loaded)
                            + " / " + AndroidUtilities.formatFileSize(total));
                } else {
                    progressBar.setProgress(0);
                    sizeView.setText(AndroidUtilities.formatFileSize(loaded));
                }
                String fname = msg.getFileName();
                Long speed = speeds.get(fname);
                if (speed != null && speed > 0) {
                    speedLabel.setText(formatSpeed(speed));
                    speedLabel.setVisibility(View.VISIBLE);
                    long eta = (speed > 0 && total > loaded)
                            ? (total - loaded) / speed : 0;
                    if (eta > 0 && eta < 3600) {
                        speedLabel.setText(formatSpeed(speed)
                                + "  ·  " + formatEta(eta));
                    }
                } else {
                    speedLabel.setVisibility(View.GONE);
                }
                progressArc.setProgress(total > 0 ? (float) loaded / total : -1f);
                progressArc.setActive(true);
                cancelBtn.setOnClickListener(v -> {
                    if (msg.getDocument() != null) {
                        FileLoader.getInstance(currentAccount)
                                .cancelLoadFile(msg.getDocument());
                    }
                });
            } else {
                progressBarHost.setVisibility(View.GONE);
                cancelBtn.setVisibility(View.GONE);
                speedLabel.setVisibility(View.GONE);
                sizeView.setText(total > 0
                        ? AndroidUtilities.formatFileSize(total)
                        : LocaleController.getString(R.string.DLDone));
                progressArc.setProgress(1f);
                progressArc.setActive(false);
            }
        }

        private String formatSpeed(long bps) {
            if (bps >= 1024L * 1024) return String.format("%.1f MB/s", bps / 1048576.0);
            if (bps >= 1024)         return String.format("%.0f KB/s", bps / 1024.0);
            return bps + " B/s";
        }

        private String formatEta(long secs) {
            if (secs >= 60) return (secs / 60) + "m " + (secs % 60) + "s";
            return secs + "s";
        }
    }

    private static class FilterChip extends TextView {
        private boolean selected = false;

        FilterChip(Context context, String label) {
            super(context);
            setText(label);
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 11);
            setGravity(Gravity.CENTER);
            setSingleLine(true);
            setEllipsize(TextUtils.TruncateAt.END);
            refreshStyle();
        }

        @Override
        public void setSelected(boolean selected) {
            this.selected = selected;
            refreshStyle();
        }

        private void refreshStyle() {
            if (selected) {
                setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText));
                setBackground(Theme.createRoundRectDrawable(
                        AndroidUtilities.dp(12),
                        0x1A5B9CF6));
                setTypeface(AndroidUtilities.bold());
            } else {
                setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
                setBackground(null);
                setTypeface(null);
            }
        }
    }

    private static class ProgressArc extends View {
        private final Paint bgPaint  = new Paint(Paint.ANTI_ALIAS_FLAG);
        private final Paint fgPaint  = new Paint(Paint.ANTI_ALIAS_FLAG);
        private final Paint dotPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private final RectF rect     = new RectF();
        private float progress = -1f;
        private boolean active = true;

        ProgressArc(Context context) {
            super(context);
            bgPaint.setStyle(Paint.Style.STROKE);
            bgPaint.setStrokeWidth(AndroidUtilities.dp(2.5f));
            bgPaint.setColor(Theme.getColor(Theme.key_windowBackgroundGray));
            fgPaint.setStyle(Paint.Style.STROKE);
            fgPaint.setStrokeWidth(AndroidUtilities.dp(2.5f));
            fgPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText));
            dotPaint.setStyle(Paint.Style.FILL);
            dotPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
        }

        void setProgress(float p) {
            progress = p;
            invalidate();
        }

        void setActive(boolean a) {
            active = a;
            fgPaint.setColor(active
                    ? Theme.getColor(Theme.key_windowBackgroundWhiteBlueText)
                    : Theme.getColor(Theme.key_windowBackgroundWhiteGreenText));
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            int cx = getWidth() / 2;
            int cy = getHeight() / 2;
            int r  = Math.min(cx, cy) - AndroidUtilities.dp(3);
            rect.set(cx - r, cy - r, cx + r, cy + r);
            canvas.drawArc(rect, -90, 360, false, bgPaint);
            if (progress >= 0) {
                canvas.drawArc(rect, -90, 360 * progress, false, fgPaint);
            } else {
                canvas.drawArc(rect, -90, 90, false, fgPaint);
            }
            if (!active) {
                int dSize = AndroidUtilities.dp(5);
                canvas.drawCircle(cx, cy, dSize, dotPaint);
            }
        }
    }
}
