# NovagramX

A Telegram client for Android, forked from [NagramX](https://github.com/risin42/NagramX).

Built on Nekogram and AyuGram. The main additions are native LLM support, voice transcription, a lockable Ghost Mode, and a broad set of UI and chat tweaks.

---

## Download

- [GitHub Actions](https://github.com/ferelking242/novagramx/actions/workflows/staging.yml) — CI builds (arm64-v8a, auto-built on every push to `dev`)
- [GitHub Releases](https://github.com/ferelking242/novagramx/releases) — Stable releases

---

## What's different from stock Telegram

**Privacy & Ghost Mode**
- Read receipts (messages + stories), online status, upload progress — each independently toggleable and lockable behind the passcode
- Deleted and edited message history saved locally (AyuGram backend, SQLite)
- Local last seen tracking per contact
- Regex message filters with per-chat exclusions, channel blocking, user filtering

**AI & Transcription**
- LLM integration: OpenAI, Gemini, xAI, Groq, DeepSeek, Cerebras, Ollama, OpenRouter, Vercel AI Gateway — or any OpenAI-compatible endpoint
- Voice transcription via Cloudflare Whisper, Gemini, or OpenAI Whisper
- LLM-powered translation alongside Google, DeepL, Microsoft, Yandex — with context-aware mode

**Forwarding & Messages**
- Forward without author tag, forward without caption, Repeat as Copy
- Combine messages when forwarding
- Double-tap action configurable separately for incoming and outgoing
- Bookmark system per chat
- Silent messages by default (optional)

**UI**
- Custom app title, folder name as active title
- Icon packs (Solar Icons), MD3 and Modern switch/slider styles
- Monet (Material You) support
- Pinned reactions configured separately per chat and per channel
- Configurable context menus — hide the items you never use
- Back animation style: Classic, Spring, or Predictive Back

**Network**
- UnifiedPush support — no Firebase / Google services required
- DNS-over-HTTPS (custom or preset), IPv6
- Custom Telegram API ID & Hash
- Upload boost, enhanced file loader

---

## Build locally

1. Get API credentials from [my.telegram.org](https://my.telegram.org/auth).

2. Create `local.properties` in the project root:
   ```
   TELEGRAM_APP_ID=your_app_id
   TELEGRAM_APP_HASH=your_app_hash
   KEYSTORE_PASS=your_keystore_password
   ALIAS_NAME=your_alias_name
   ALIAS_PASS=your_alias_password
   ```

3. Replace `TMessagesProj/release.keystore` with your own keystore.

4. Add FCM support (optional): replace `TMessagesProj/google-services.json` with your own.

5. Build:
   ```
   ./gradlew TMessagesProj:assembleStaging
   ```
   Or open in Android Studio directly.

---

## GitHub Actions

Set these repository secrets:

| Secret | Description |
|---|---|
| `LOCAL_PROPERTIES` | Base64-encoded content of `local.properties` (see above) |
| `HELPER_BOT_TOKEN` | Telegram bot token — for posting builds to a channel (optional) |
| `HELPER_BOT_TARGET` | Telegram chat ID to post builds to (optional) |
| `HELPER_BOT_CANARY_TARGET` | Telegram chat ID for canary builds (optional) |

The `dev` branch triggers a staging build on every push. The workflow produces a signed arm64-v8a APK as a GitHub artifact.

---

## Credits

- [NagramX](https://github.com/risin42/NagramX) — direct upstream
- [AyuGram](https://github.com/AyuGram/AyuGram4A) — Ghost Mode and message history
- [Nekogram](https://github.com/Nekogram/Nekogram) — base fork
- [OctoGram](https://github.com/OctoGramApp/OctoGram)
- [exteraGram](https://github.com/exteraSquad/exteraGram)
- [Cherrygram](https://github.com/arsLan4k1390/Cherrygram)
- [Dr4iv3rNope](https://github.com/Dr4iv3rNope/NotSoAndroidAyuGram)
