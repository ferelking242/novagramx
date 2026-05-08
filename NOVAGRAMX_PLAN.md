# NovagramX — Analyse exhaustive & Plan de développement

> Basé sur l'analyse réelle du code source NagramX (branche `dev`) + recherche approfondie de 22 clients Telegram.

---

## PARTIE 1 — Panorama complet des clients Telegram

### 1.1 — Telegram Officiel
**Base de référence pour tous les autres clients.**

| Catégorie | Features |
|---|---|
| **Messagerie** | Messages texte, médias, fichiers, stickers, GIF, sondages, quiz |
| **Vie privée** | Messages qui s'auto-détruisent, chats secrets (E2E), minuterie |
| **Organisation** | Dossiers (folders), Topics, archives |
| **Appels** | Appels vocaux et vidéo 1:1, groupes vocaux |
| **Canaux** | Broadcast channels, stats basiques |
| **Bots** | Bots, mini-apps, inline bots |
| **Business** | Mode Business, horaires, réponses rapides, intro |
| **Premium** | Emoji personnalisés, avatars animés, 4GB upload, traduction, stories premium, téléchargement rapide, no ads |
| **Stories** | Stories avec réactions, vues, confidentialité par contact |
| **Boosts** | Boost de canaux/groupes, niveaux |
| **Réactions** | Réactions rapides sur messages |
| **Traduction** | Traduction intégrée (Premium) |
| **Navigation** | Swipe entre chats, recherche globale, topic threads |
| **Notifications** | Son/vibration par chat, notifs groupées |
| **Partage** | Forward avec ou sans légende, forward vers multiples chats |

---

### 1.2 — Nekogram / NekogramX
**Fork chinois, base directe de NagramX.**

| Catégorie | Features |
|---|---|
| **Vie privée** | Ghost Mode basique (no read receipts, no online, no upload) |
| **Navigation** | Tabs custom (Tous/Users/Groupes/Channels/Bots) — texte/icône/mixte |
| **Traduction** | Multi-moteurs : Google, DeepL, Microsoft, Yandex, Lingva |
| **Réseau** | IPv6, DNS-over-HTTPS custom, API ID/Hash custom |
| **UI** | Fond du drawer (avatar/grand avatar/wallpaper) |
| **Stickers** | Stickers favoris illimités, pins illimités |
| **Médias** | Chemin de sauvegarde custom, bitrate audio custom |
| **Filtres** | Trier dialogues par non-lu, non-muet, contacts, utilisateurs |
| **Notifications** | Désactiver les bulles de notifs |
| **Maps** | OSMDroid (map sans Google Maps) |
| **Markdown** | Parser Markdown Neko vs Telegram |
| **Forward** | Forward sans citation (`No-Quote Forward`) |
| **Proxy** | Désactiver proxy si VPN actif |
| **Calendrier** | Calendrier persan |
| **Premium local** | Unlock certaines UI Premium sans abonnement |
| **Contenu** | Ignorer les restrictions de contenu |

---

### 1.3 — AyuGram *(standalone)*
**Fork russe axé vie privée & historique des messages.**

| Catégorie | Features |
|---|---|
| **Ghost Mode avancé** | Read receipts (messages + stories), online status, upload progress — chacun verrouillable séparément |
| **Offline packet** | Envoyer un packet offline après avoir été forcé online |
| **Anti-revoke complet** | Sauvegarde tous les messages supprimés dans une DB locale (Room) |
| **Historique éditions** | Sauvegarde toutes les versions d'un message modifié |
| **Last seen local** | Enregistre et affiche le last seen de chaque contact localement |
| **Médias sauvegardés** | Sauvegarde des médias des messages supprimés par type de chat |
| **Icônes custom** | Icône "supprimé"/"modifié" visuelle sur les messages affectés |
| **Messages transparents** | Messages supprimés affichés en translucide |
| **Regex filters** | Filtres regex sur contenu de messages, avec exclusions par dialogue |
| **Block channels** | Blocage de channels entiers |
| **Custom filtered users** | Filtrage d'utilisateurs spécifiques |
| **Interface dédiée** | Activity séparée pour voir l'historique des suppressions/éditions |
| **Ghost dans le drawer** | Accès rapide Ghost Mode depuis le menu latéral |

---

### 1.4 — NagramX *(notre base — analyse complète au §2)*
Fork combinant Nekogram + AyuGram + fonctionnalités propres. **Voir Partie 2 pour la liste exhaustive.**

---

### 1.5 — OwlGram
**Fork italien très populaire, fort sur caméra et médias.**

| Catégorie | Features |
|---|---|
| **Caméra** | Zoom précis, timer, grille de composition, mode caméra arrière |
| **Audio** | Transcription voix en texte (intégrée), boutons 1x/1.5x/2x **inline** dans la bulle de message vocal |
| **Vie privée** | Anti-revoke (messages supprimés), Ghost Mode, forward sans auteur |
| **Notifications** | **Alerte quand un contact passe en ligne** (notification locale) |
| **Notifications** | Son de notification différent par chat |
| **UI** | Police de caractères custom (TTF), wallpaper différent par chat |
| **Thèmes** | Auto night mode par horaire ou capteur luminosité |
| **Drawer** | Fond du drawer custom |
| **Messages** | Forward batch (vers plusieurs chats simultanément) |
| **Messages** | Anti-screenshot |
| **Filtres** | Filtres de messages avancés |
| **Réseau** | DoH, IPv6, enhanced file loader |
| **Médias** | Bitrate vidéo amélioré |
| **Bots** | Bloquer le bouton "Ouvrir" des bots |

---

### 1.6 — Plus Messenger (Telegram Plus)
**Client le plus personnalisable historiquement, créateur de nombreux standards.**

| Catégorie | Features |
|---|---|
| **Forward** | **Forward sans tag auteur** (pionnier de cette feature) |
| **Forward** | Forward sans légende, forward silencieux |
| **Thèmes par chat** | Wallpaper/fond différent pour chaque conversation |
| **Notifs par chat** | Son de notification unique par chat ou groupe |
| **Tabs** | Tabs ultra-custom : All/Users/Groups/Channels/Bots/Favorites/Unread/Admin — masquables, renommables, réorganisables |
| **Tabs** | Position de la barre de tabs (haut/bas), icônes seules ou texte seul |
| **Groupes** | **Statistiques de groupe** (activité, messages, membres) |
| **Contacts** | **Tracking des changements** : nom, photo, username des contacts |
| **Contacts** | Afficher tous les messages d'un user dans un groupe spécifique |
| **UI** | **Police de caractères custom** (TTF externe ou collection intégrée) |
| **UI** | Granularité extrême : couleur/taille/padding de chaque élément UI |
| **Partage** | Direct Share (sans ouvrir le chat) |
| **Confidentialité** | Cacher le numéro de téléphone dans le drawer |
| **Nuit** | Auto night mode (par heure ou capteur luminosité) |
| **Messagerie** | Programmation de messages avancée |
| **Médias** | Envoi en haute résolution sans compression |
| **Thèmes** | Écosystème de thèmes partagés (app dédiée "Themes for Plus") |
| **Profil** | Couleur de nom de contact aléatoire ou fixe |

---

### 1.7 — Exteragram
**Fork russe axé multi-comptes et productivité.**

| Catégorie | Features |
|---|---|
| **Multi-comptes** | Affichage simultané de plusieurs comptes (barre de sélection rapide) |
| **Markdown** | Éditeur Markdown intégré dans le champ de saisie |
| **Réactions** | Panel de quick reactions personnalisable (ordre custom) |
| **Stats** | Statistiques de lecture par chat (messages lus/envoyés) |
| **UI** | Thèmes avancés, Material You |
| **Messages** | Forward avancé |
| **Notifications** | Gestion fine des notifications par compte |

---

### 1.8 — Nicegram
**Client iOS populaire, contenu restreint + organisation.**

| Catégorie | Features |
|---|---|
| **Contenu** | Déverrouillement de contenu restreint (canaux 18+, NSFW) |
| **Organisation** | Dossiers sync cloud, Saved Messages amélioré |
| **Traduction** | Traduction en un tap |
| **Réponses rapides** | Quick replies configurables |
| **UI** | Thèmes iOS-style |
| **Messagerie** | Import/export de chats |
| **Multi-comptes** | Gestion multi-comptes simplifiée |

---

### 1.9 — Catogram / Catogram X
**Fork russe, interface simplifiée + touches personnelles.**

| Catégorie | Features |
|---|---|
| **UI** | Interface minimaliste, icônes custom |
| **Thèmes** | Thèmes simples + import de thèmes Telegram |
| **Forward** | Forward sans tag |
| **Confidentialité** | Ghost mode basique |
| **Messages** | Quelques tweaks menus contextuels |
| **Stickers** | Pack de stickers intégré thématique |

---

### 1.10 — Molly
**Fork sécurisé inspiré de Signal, axé protection locale.**

| Catégorie | Features |
|---|---|
| **Chiffrement DB** | **Base de données locale chiffrée via SQLCipher** (passphrase) |
| **Anti-screenshot** | Blocage des screenshots par chat (FLAG_SECURE granulaire) |
| **RAM** | Effacement fréquent des données sensibles en mémoire |
| **App Lock** | Verrouillage par code + biométrique |
| **FOSS** | 100% open source, sans blobs propriétaires |
| **Push sans Google** | UnifiedPush (ntfy, etc.) ou WebSocket |
| **Sans Google** | 0 dépendance Google Play Services |
| **Métadonnées** | Minimisation du stockage local de métadonnées sensibles |
| **Reproductible** | Builds reproductibles (vérification source = binaire) |
| **Profil** | Pas de synchro de contacts avec le serveur (mode local) |

---

### 1.11 — Mercurygram
**Fork privacy-first, sans Google.**

| Catégorie | Features |
|---|---|
| **Sans Google** | Fonctionne sur ROMs dé-googlisées (LineageOS, GrapheneOS) |
| **UnifiedPush** | Gateway P2P intégré (`p2p.belloworld.it`) pour les notifs |
| **Privacy** | Paramètres de confidentialité agressifs par défaut |
| **Surface** | Réduction de la surface d'attaque (features non-essentielles retirées) |
| **FCM-free** | Zéro Firebase Cloud Messaging |

---

### 1.12 — Telegram FOSS / GrapheneOS Build
**Build officiel open source sans Google Maps ni FCM.**

| Catégorie | Features |
|---|---|
| **Sans Google** | Remplace FCM par WebSocket persistant, Maps par OSMDroid |
| **Trackers** | Zéro SDK de tracking/analytics |
| **Sandboxing** | Optimisé pour sandboxing GrapheneOS |
| **Mémoire** | Compatible `hardened_malloc` |
| **Mises à jour** | Sans Google Play |

---

### 1.13 — Forkgram
**Fork minimaliste axé souveraineté des données.**

| Catégorie | Features |
|---|---|
| **Anti-revoke** | Désactiver la suppression de messages pour l'utilisateur local |
| **Analytics** | Suppression de tout le reporting Telegram natif |
| **Reproductible** | Builds reproductibles |
| **Léger** | Moins de features = moins d'entretien, plus stable |
| **Sans Google** | Fonctionne sans Google Play |

---

### 1.14 — YukiGram
**Fork japonais, personnalisation UI avancée.**

| Catégorie | Features |
|---|---|
| **UI** | Thèmes avec accent colors Material You |
| **Icônes** | Packs d'icônes multiples (dont style anime) |
| **Forward** | Forward sans auteur, forward en lot |
| **Ghost** | Ghost mode intégré |
| **Tabs** | Personnalisation des onglets |
| **Traduction** | Multi-moteurs |
| **Emoji** | Support emoji Twemoji/JoyPixels |

---

### 1.15 — Foxgram
**Fork italien, Material You + vie privée.**

| Catégorie | Features |
|---|---|
| **UI** | Material You (Monet) complet, thèmes dynamiques |
| **Vie privée** | Ghost mode, no read receipts |
| **Forward** | Forward sans auteur |
| **Anti-revoke** | Messages supprimés conservés |
| **Médias** | Téléchargement multi-thread accéléré |
| **FOSS** | Code entièrement ouvert |

---

### 1.16 — MaterialGram
**Fork focalisé sur le design Material You.**

| Catégorie | Features |
|---|---|
| **UI** | Implémentation la plus poussée de Material You |
| **Thèmes** | Couleurs dynamiques Android 12+ complètes |
| **Navigation** | Navigation bottom bar Material Design |
| **Animations** | Animations Material Design 3 |
| **Icônes** | Icônes Material 3 |
| **Fond** | Monet sur tous les éléments UI |

---

### 1.17 — ZeroGram
**Fork ultra-minimaliste, anti-trackers.**

| Catégorie | Features |
|---|---|
| **Analytics** | Zéro analytics, zéro crashlytics |
| **UI** | Interface stock épurée |
| **Sans Google** | Builds F-Droid, pas de dépendance Play |
| **Anti-spam** | Outils anti-spam améliorés |
| **Léger** | APK très léger (features non-essentielles retirées) |

---

### 1.18 — MoeGram
**Fork chinois très personnalisable, communauté active.**

| Catégorie | Features |
|---|---|
| **UI** | Thèmes ultra-custom, animations |
| **Stickers** | Gestion stickers avancée |
| **Traduction** | Support CN/JA/KO en priorité |
| **Ghost** | Ghost mode complet |
| **Forward** | Forward sans tag |
| **Anti-revoke** | Conservation messages supprimés |
| **Emoji** | Support emoji custom |

---

### 1.19 — Vivid (iOS-style Telegram)
**Fork visant l'esthétique iOS.**

| Catégorie | Features |
|---|---|
| **UI** | Style iOS (bulles, polices, animations) |
| **Navigation** | Navigation iOS-style (swipe, tab bar) |
| **Thèmes** | Thèmes clairs adaptés |
| **Animations** | Transition iOS fluid |

---

### 1.20 — BifrostX / NekoX
**Fork international de NekogramX, plus de providers de traduction.**

| Catégorie | Features |
|---|---|
| **Traduction** | Encore plus de moteurs : Baidu, Tencent, etc. |
| **Proxy** | Intégration proxy publics auto |
| **Tabs** | Custom tabs avancés |
| **Ghost** | Ghost mode |
| **Forward** | No-quote forward |

---

### 1.21 — LiteGram
**Fork ultra-léger.**

| Catégorie | Features |
|---|---|
| **Performance** | APK très petit, consommation RAM réduite |
| **Batterie** | Optimisé pour appareils bas de gamme |
| **UI** | Interface simplifiée |
| **Réseau** | Gestion connexion optimisée |

---

### 1.22 — Telegram X
**Client expérimental officiel Telegram.**

| Catégorie | Features |
|---|---|
| **Performance** | Architecture TDLib, beaucoup plus rapide |
| **UI** | Animations plus fluides |
| **Appels** | Qualité appel améliorée |
| **Interface** | Navigation expérimentale |

---

## PARTIE 2 — Features complètes de NagramX (depuis le code source réel)

### 2.1 — Vie privée & Ghost Mode
| Feature | Clé config | Défaut |
|---|---|---|
| Ghost — no read receipts (messages) | `sendReadMessagePackets` | ON |
| Ghost — no read receipts (stories) | `sendReadStoriesPackets` | ON |
| Ghost — cacher statut en ligne | `sendOnlinePackets` | ON |
| Ghost — cacher "envoi en cours..." | `sendUploadProgress` | ON |
| Aller offline après une action forcée | `sendOfflinePacketAfterOnline` | OFF |
| Marquer lu après envoi | `markReadAfterSend` | ON |
| Afficher Ghost Mode dans le drawer | `showGhostInDrawer` | OFF |
| Afficher statut Ghost Mode | `showGhostModeStatus` | OFF |
| **Verrouiller chaque param Ghost Mode** | `*Locked` (5 configs) | OFF |

### 2.2 — Sauvegarde messages (AyuGram Database)
| Feature | Clé config | Défaut |
|---|---|---|
| Sauvegarder messages supprimés | `EnableSaveDeletedMessages` | OFF |
| Sauvegarder historique modifications | `EnableSaveEditsHistory` | OFF |
| Sauvegarder last seen localement | `SaveLocalLastSeen` | OFF |
| Sauvegarder médias des messages supprimés | `MessageSavingSaveMedia` | ON |
| Médias — chats privés | `SaveMediaInPrivateChats` | ON |
| Médias — channels publics | `SaveMediaInPublicChannels` | ON |
| Médias — channels privés | `SaveMediaInPrivateChannels` | ON |
| Médias — groupes publics | `SaveMediaInPublicGroups` | ON |
| Médias — groupes privés | `SaveMediaInPrivateGroups` | ON |
| Sauvegarder messages de bots | `SaveDeletedMessageForBot` | OFF |
| Marque custom sur messages supprimés | `CustomDeletedMark` | "" |
| Messages supprimés translucides | `TranslucentDeletedMessages` | ON |
| Icône "supprimé" custom | `UseDeletedIcon` | ON |
| Icône "modifié" custom | `UseEditedIcon` | ON |

### 2.3 — Bookmarks (système intégré)
> `BookmarksHelper.kt` + `BookmarksActivity.java` + `BookmarksChatCell.java`

| Feature | Clé config |
|---|---|
| Ajouter un message en bookmark | `ShowAddToBookmark` |
| Gestionnaire de bookmarks par chat | `nkbtn_bookmarks_manager` |
| Vider tous les bookmarks | (CacheControlActivity) |

### 2.4 — Intelligence Artificielle (LLM)
| Fournisseur | Clés config |
|---|---|
| **OpenAI** | `LlmProviderOpenAIKey` / `LlmProviderOpenAIModel` |
| **Gemini** | `LlmProviderGeminiKey` / `LlmProviderGeminiModel` |
| **xAI (Grok)** | `LlmProviderXAIKey` / `LlmProviderXAIModel` |
| **Groq** | `LlmProviderGroqKey` / `LlmProviderGroqModel` |
| **DeepSeek** | `LlmProviderDeepSeekKey` / `LlmProviderDeepSeekModel` |
| **Cerebras** | `LlmProviderCerebrasKey` / `LlmProviderCerebrasModel` |
| **Ollama** (local/cloud) | `LlmProviderOllamaCloudKey` / `LlmProviderOllamaCloudModel` |
| **OpenRouter** | `LlmProviderOpenRouterKey` / `LlmProviderOpenRouterModel` |
| **Vercel AI Gateway** | `LlmProviderVercelAIGatewayKey` / `LlmProviderVercelAIGatewayModel` |
| **Custom OpenAI-compatible** | `LlmApiUrl` / `LlmApiKey` |
| Prompt système custom | `LlmSystemPrompt` |
| Prompt utilisateur custom | `LlmUserPrompt` |
| Température | `LlmTemperature` (0.7) |
| Contexte de conversation | `LlmUseContext` / `LlmContextSize` |
| Contexte dans l'auto-traduction | `LlmUseContextInAutoTranslate` |
| Traduction LLM dans le menu message | `ShowTranslateMessageLLM` |

### 2.5 — Transcription vocale
| Fournisseur | Clés config |
|---|---|
| **Cloudflare Whisper** | `TranscribeProviderCfAccountID` / `TranscribeProviderCfApiToken` |
| **Gemini** | `TranscribeProviderGeminiApiKey` / `TranscribeProviderGeminiPrompt` |
| **OpenAI Whisper** | `TranscribeProviderOpenAiApiBase/Model/ApiKey/Prompt` |

### 2.6 — Traduction
| Feature | Clé config |
|---|---|
| Moteurs : Google, DeepL, Microsoft, Yandex, LLM | `translationProvider` |
| Mode traduction (off/manuel avec original/auto) | `translatorMode` |
| Traducteur d'articles séparé | `EnableSeparateArticleTranslator` |
| Moteur traduction articles | `ArticleTranslationProvider` |
| Garder Markdown après traduction | `translatorKeepMarkdown` |
| Langues cibles préférées (liste) | `PreferredTranslateTargetLang` |
| Google Translate expérimental | `GoogleTranslateExp` |
| Garder préférences du traducteur | `keepTranslatorPreferences` |
| UI auto-translate (bouton dans bulles) | `TelegramUIAutoTranslate` |

### 2.7 — UI & Personnalisation visuelle
| Feature | Clé config | Défaut |
|---|---|---|
| Titre app custom | `CustomTitle` | "Nagram X" |
| Titre = nom du dossier actif | `FolderNameAsTitle` | OFF |
| Titre centré (off/toujours/settings/chats) | `CenterActionBarTitleType` | Toujours |
| Pack d'icônes (défaut/Solar/autres) | `IconReplacements` | 0 |
| Style switches (défaut/Modern/MD3) | `SwitchStyle` | Défaut |
| Style sliders (défaut/Modern/MD3) | `SliderStyle` | Défaut |
| Fond du drawer (défaut/avatar/grand/wallpaper) | `DrawerBackground` | Défaut |
| Support Monet (Android 12+) | `MonetHelper` | — |
| Cacher les dividers | `HideDividers` | OFF |
| Fond coloré des messages | `MessageColoredBackground` | ON |
| Flou forcé dans le chat | `forceBlurInChat` | OFF |
| Alpha du flou | `forceBlurInChatAlphaValue` | 127 |
| Contour (stroke) sur les vues | `StrokeOnViews` | ON |
| Cacher barre de navigation du bas | `HideBottomNavigationBar` | OFF |
| Cacher champ de recherche | `HideDialogsSearchField` | OFF |
| Afficher les secondes | `showSeconds` | OFF |
| Style animation retour (Classic/Spring/Predictive) | `BackAnimationStyle` | Classic |
| Animation crossfade spring | `SpringAnimationCrossfade` | ON |
| Désactiver flou avatar | `DisableAvatarBlur` | OFF |
| Cacher stories depuis le header | `HideStoriesFromHeader` | ON |
| Mode tablette | `TabletMode` | Auto |
| Désactiver gestes navigateur intégré | `DisableInAppBrowserGestures` | OFF |

### 2.8 — Tabs & Navigation principale
| Feature | Clé config |
|---|---|
| Cacher l'onglet "Tous" | `HideAllTab` |
| Cacher titres des onglets (icônes seules) | `MainTabsHideTitles` |
| Cacher onglet Contacts | `MainTabsHideContacts` |
| Type de titre onglets (texte/icône/mix) | `tabsTitleType` |
| Ouvrir archives en tirant vers le bas | `OpenArchiveOnPull` |
| Cacher les archives | `HideArchive` |
| Ne pas désarchiver en swipant | `DoNotUnarchiveBySwipe` |
| Cacher le bouton flottant | `DisableDialogsFloatingButton` |
| Désactiver swipe vers prochain channel | `disableSwipeToNext` |
| Onglet "Groupes communs" préféré dans profil | `preferCommonGroupsTab` |

### 2.9 — Messages & Comportement chat
| Feature | Clé config |
|---|---|
| Double-tap action entrante configurable | `DoubleTapAction` |
| Double-tap action sortante configurable | `DoubleTapActionOut` |
| **Forward sans tag auteur** | `showNoQuoteForward` |
| **Forward sans légende (caption)** | `hideCaption` (MessagePreviewParams) |
| Repeat as Copy | `showRepeatAsCopy` |
| Combiner les messages au forward | `CombineMessage` |
| Message silencieux par défaut | `SilentMessageByDefault` |
| Filtre Zalgo | `ZalgoFilter` |
| Filtre Regex (messages) | `RegexFiltersEnabled` / `RegexFiltersData` |
| Filtre Regex dans les chats | `RegexFiltersEnableInChats` / `RegexChatFiltersData` |
| Regex — exclusions par dialogue | `RegexFiltersExcludedDialogs` |
| Bloquer des channels | `BlockedChannelsData` |
| Filtrer des utilisateurs | `CustomFilteredUsersData` |
| Date des messages forwardés | `DateOfForwardedMsg` |
| Afficher l'ID du message | `ShowMessageID` |
| Afficher ID + DC format | `IdDcType` |
| Afficher l'erreur RPC | `ShowRPCError` |
| Marque custom "modifié" | `CustomEditedMessage` |
| Désactiver Markdown | `DisableMarkdown` |
| Parser Markdown (Telegram/Neko) | `MarkdownParser` |
| Pangu (espacement CJK auto) | `EnablePanguOnSending` |
| Afficher spoilers directement | `showSpoilersDirectly` |
| GIF en petite taille | `ShowSmallGIF` |
| Désactiver clic commande = envoi | `DisableClickCommandToSend` |
| Reply en privé depuis un groupe | `showReplyInPrivate` |
| Ne pas auto-lire le vocal suivant | `DontAutoPlayNextVoice` |
| Supprimer chat pour les deux côtés | `DeleteChatForBothSides` |
| Corriger aperçu liens | `FixLinkPreview` |
| Désactiver aperçu liens par défaut | `DisableLinkPreviewByDefault` |
| Confirmation avant appel | `AskBeforeCalling` |
| Menu messages groupés | `GroupedMessageMenu` |
| Confirmer tous les liens externes | `ConfirmAllLinks` |
| Menu par défaut suppression (ban/spam/deleteAll) | `DefaultDeleteMenu*` |
| Envoyer commentaire après forward | `SendCommentAfterForward` |

### 2.10 — Caméra & Vidéo messages
| Feature | Clé config |
|---|---|
| Caméra vidéo (avant/arrière/demander) | `CameraInVideoMessages` |
| Zoom caméra (pinch-to-zoom) | (ChatAttachAlertPhotoLayout) |

### 2.11 — Stickers, Emojis & Réactions
| Feature | Clé config |
|---|---|
| Stickers favoris illimités | `UnlimitedFavoredStickers` |
| Pins illimités | `UnlimitedPinnedDialogs` |
| Taille stickers custom | `stickerSize` |
| Cacher sticker de groupe | `hideGroupSticker` |
| Désactiver section Trending | `DisableTrending` |
| Ne pas envoyer sticker bienvenue | `DontSendGreetingSticker` |
| Cacher temps sur stickers | `HideTimeForSticker` |
| Créateur stickers minimisé | `minimizedStickerCreator` |
| Emoji système | `EmojiUseDefault` |
| **Réactions épinglées par chat** | `UsePinnedReactionsChats` / `PinnedReactionsChats` |
| **Réactions épinglées par channel** | `UsePinnedReactionsChannels` / `PinnedReactionsChannels` |
| Cacher les réactions | `HideReactions` |

### 2.12 — Réseau & Connexion
| Feature | Clé config |
|---|---|
| IPv6 | `IPv6` |
| DNS-over-HTTPS custom | `CustomDoH` |
| Type DNS (défaut/NAX/système/custom DoH) | `DnsType` |
| **API ID/Hash custom** | (NekoXConfig) |
| Désactiver proxy si VPN actif | `DisableProxyWhenVpnEnabled` |
| Enhanced File Loader | `enhancedFileLoader` |
| Upload Boost | `uploadBoost` |

### 2.13 — Médias & Audio/Vidéo
| Feature | Clé config |
|---|---|
| Bitrate audio custom | `customAudioBitrate` |
| Bitrate vidéo amélioré | `EnhancedVideoBitrate` |
| Suppression bruit + amélioration voix | `NoiseSuppressAndVoiceEnhance` |
| Qualité HLS par défaut | `DefaultHlsVideoQuality` |
| Décodeur vidéo (Software/Hardware) | `VideoPlayerDecoder` |
| GIF comme vidéo | `TakeGIFasVideo` |
| Envoyer MP4 comme vidéo (pas document) | `SendMp4DocumentAsVideo` |
| Toujours afficher icône téléchargement | `AlwaysShowDownloadIcon` |
| Sauvegarder dans sous-dossier par chat | `SaveToChatSubfolder` |
| Chemin de sauvegarde custom | `customSavePath` |
| Auto-pause vidéo | `AutoPauseVideo` |

### 2.14 — Boutons ActionBar & Menu contextuel
**ActionBar (sélection messages) :**
- Reply, Edit, Select Between, Copy, Forward — chacun toggleable

**Menu contextuel messages (tous toggleables) :**
Add to Saved, Report, View History, Admin Actions, Change Permissions, Delete Downloaded File, Message Details, Translate, Repeat, Share Messages, Set Reminder, Message Hide, Copy Photo, Copy Frame, Copy Link, Copy Photo as Sticker, Add to Stickers, Add to Favorites, Translate via LLM, Reply in Private, View Deleted, Clear Deleted, Delete Own Messages, Boost Group, Linked Chat, Go to Beginning, Go to Message, Hide Title

**Media viewer (tous toggleables) :**
Forward, No-Quote Forward, Copy Frame, Copy Photo, Set Profile Photo, Scan QR Code

### 2.15 — Raccourcis en-tête de chat
| Feature | Clé config |
|---|---|
| Raccourci Administrateurs | `shortcutsAdministrators` |
| Raccourci Journal d'événements | `shortcutsRecentActions` |
| Raccourci Statistiques | `shortcutsStatistics` |
| Raccourci Permissions | `shortcutsPermissions` |
| Raccourci Membres | `shortcutsMembers` |
| Bouton gauche bas du chat (configurable) | `leftBottomButton` |

### 2.16 — Formatage de texte (menu texte sélectionné)
Chaque bouton de formatage est toggleable individuellement :
**Bold, Italic, Monospace, Code Block, Strikethrough, Underline, Quote, Spoiler, Link, Mention, Date, Regular, Translate** — ordre configurable via `TextStyleOrder`.

### 2.17 — Premium local & Contrôle UI Premium
| Feature | Clé config |
|---|---|
| Premium local | `localPremium` |
| Cacher section Premium | `HidePremiumSection` |
| Cacher section Aide | `HideHelpSection` |
| Contrôle Emoji Status | `PremiumItemEmojiStatus` |
| Contrôle Emoji dans réponses | `PremiumItemEmojiInReplies` |
| Contrôle couleur custom réponses | `PremiumItemCustomColorInReplies` |
| Contrôle wallpaper custom | `PremiumItemCustomWallpaper` |
| Contrôle avatar vidéo | `PremiumItemVideoAvatar` |
| Contrôle Star dans réactions | `PremiumItemStarInReactions` |
| Contrôle effets stickers | `PremiumItemStickerEffects` |
| Contrôle boosts | `PremiumItemBoosts` |

### 2.18 — Push & Notifications
| Feature | Clé config |
|---|---|
| Type de push (FCM/UnifiedPush/Ntfy) | `PushServiceType` |
| Gateway UnifiedPush custom | `PushServiceTypeUnifiedGateway` |
| Dialog in-app pour le push | `PushServiceTypeInAppDialog` |
| Afficher aperçu notif sur écran verrouillé | `ShowNotificationPreviewWhenLocked` |
| Icône de notification custom | `notificationIcon` |
| Désactiver bulles de notifications | `disableNotificationBubbles` |
| Désactiver vibrations | `DisableVibration` |

### 2.19 — Tris & Filtres dialogues
| Feature | Clé config |
|---|---|
| Trier par non-lu | `sort_by_unread` / `SortByUnread` |
| Trier par non-muet | `sort_by_unmuted` |
| Trier utilisateurs en premier | `sort_by_user` |
| Trier contacts en premier | `sort_by_contacts` |
| Ignorer compte non-lu (aucun/muets/tous) | `IgnoreUnreadCount` |

### 2.20 — Divers
| Feature | Clé config |
|---|---|
| Calendrier persan | `UsePersianCalendar` |
| Auto-update channel (off/release/beta) | `AutoUpdateChannel` |
| Classe de performance manuelle | `PerformanceClass` |
| Désactiver Crashlytics | `DisableCrashlyticsCollection` |
| Cacher numéro de téléphone | `HidePhone` |
| Sauter confirmation ouverture liens | `SkipOpenLinkConfirm` |
| Désactiver compte système | `DisableSystemAccount` |
| Désactiver proximité | `DisableProximityEvents` |
| Ignorer utilisateurs bloqués | `IgnoreBlocked` |
| Répéter confirmation | `repeatConfirm` |
| Maps OSMDroid | `useOSMDroidMap` |
| Correction dérive Google Maps | `mapDriftingFixForGoogleMaps` |
| Désactiver caméra instantanée | `DisableInstantCamera` |
| Cacher bouton mute channel | `DisableChannelMuteButton` |
| Cacher bouton son preview vidéo | `DisablePreviewVideoSoundShortcut` |
| Cacher bouton bot dans input | `HideBotButtonInInputField` |
| Désactiver bouton bot "Ouvrir" | `DisableBotOpenButton` |
| Masquer bouton share dans channel | `HideShareButtonInChannel` |
| Send-as sous le hint de messagerie | `ShowSendAsUnderMessageHint` |
| Désactiver auto-download exe/archives | `Win32ExecutableFiles` / `ArchiveFiles` |
| Ignorer restrictions contenu | `ignoreContentRestrictions` |
| Cacher l'envoi-sous-canal | `hideSendAsChannel` |

---

## PARTIE 3 — Ce que NagramX N'A PAS et que d'autres clients ont

### 3.1 — Features absentes confirmées (par analyse de code)

| Feature | Client(s) source | Présent dans NagramX ? |
|---|---|---|
| **Vitesse vocal INLINE dans la bulle** (1x/1.5x/2x direct sur le message) | OwlGram | ❌ (existe dans le player flottant seulement) |
| **Notification quand un contact passe en ligne** | OwlGram, Plus Messenger | ❌ |
| **Caméra — grille de composition** | OwlGram | ❌ |
| **Caméra — timer** | OwlGram | ❌ |
| **Police de caractères custom (TTF)** | OwlGram, Plus Messenger | ❌ |
| **Anti-screenshot par chat normal** | OwlGram, Molly | ❌ (existe seulement sur chats secrets/passcode) |
| **Chiffrement base de données locale (SQLCipher)** | Molly | ❌ |
| **Tracking changements contacts** (nom/photo/username) | Plus Messenger | ❌ |
| **Statistiques d'activité par chat** (messages lus/envoyés/reçus) | Exteragram | ❌ |
| **Export chat vers fichier** (JSON, HTML, TXT) | Telegram Desktop | ❌ |
| **Multi-comptes simultanés** (barre de sélection rapide) | Exteragram | ❌ |
| **Couleurs de noms contacts** (aléatoire ou custom par contact) | Plus Messenger | ❌ |
| **Compteur de mots/caractères** dans le champ de saisie | — | ❌ |
| **Fond de chat par conversation** (wallpaper par dialogue) | Plus Messenger, OwlGram | ❌ (Telegram a par chat via API Premium, mais pas étendu dans NagramX) |

---

## PARTIE 4 — Plan NovagramX — Features à implémenter

### Phase 1 — Quick wins (< 3 jours chacune)

#### ★★★ F-01 · Vitesse vocal inline dans la bulle de message
- **Problème** : Le bouton de vitesse existe dans le mini-player flottant (`AudioPlayerAlert.java`) mais pas directement sur la bulle du message vocal dans le chat.
- **Impact** : Très utilisé, améliore l'expérience quotidienne immédiatement.
- **Comment** : Ajouter un petit bouton `1x → 1.5x → 2x` dans `ChatMessageCell.java` sur les bulles de type `MessageObject.TYPE_VOICE`. Stocker la préférence dans `NaConfig` ou utiliser `MediaController.getInstance().getPlaybackSpeed()`.
- **Fichiers** : `ChatMessageCell.java`, `MediaController.java`, `NaConfig.kt`, `NekoChatSettingsActivity.java`

#### ★★★ F-02 · Compteur de caractères/mots dans le champ de saisie
- **Impact** : Utile pour les posts de canaux, simple à faire.
- **Comment** : Modifier `ChatActivity.java` dans la zone du champ de saisie, ajouter un `TextView` overlay qui compte `text.length()` et `text.split(" ").size` en temps réel. Toggle dans les settings.
- **Fichiers** : `ChatActivity.java`, `NaConfig.kt`, `NekoChatSettingsActivity.java`

#### ★★★ F-03 · Police de caractères custom (TTF)
- **Impact** : Feature très demandée, se différencie de NagramX upstream.
- **Comment** : Permettre de choisir un fichier `.ttf`/`.otf` depuis le stockage ou un menu de polices préinstallées. Injecter via `Typeface.createFromFile()` dans `AndroidUtilities.java` et `Theme.java`.
- **Fichiers** : `AndroidUtilities.java`, `Theme.java`, `NekoGeneralSettingsActivity.java`, `NaConfig.kt`

#### ★★ F-04 · Couleurs de noms contacts (unique par contact)
- **Impact** : Visual, populaire, simple à ajouter.
- **Comment** : Générer une couleur HSL déterministe depuis `userId.hashCode()`, ou permettre une couleur custom par contact. Appliquer dans `ChatMessageCell.java` et `DialogCell.java`.
- **Fichiers** : `ChatMessageCell.java`, `DialogCell.java`, `NaConfig.kt`

#### ★★ F-05 · Compteur de membres en ligne dans les groupes (header)
- **Impact** : Info utile souvent cachée, facile à afficher.
- **Comment** : `ChatInfo.online_count` existe déjà dans le code Telegram — juste l'afficher dans le sous-titre de l'ActionBar.
- **Fichiers** : `ChatActivity.java`

---

### Phase 2 — Features réseau social (1 semaine chacune)

#### ★★★ F-06 · Notification quand un contact passe en ligne
- **Impact** : Feature très demandée depuis des années dans la communauté Telegram.
- **Comment** : Hook sur `MessagesController.processUpdateArray()` qui reçoit les `UserStatus` updates. Si l'utilisateur est dans une liste de surveillance (`NaConfig`), envoyer une notif locale via `NotificationsController`.
- **Fichiers** : `MessagesController.java`, `NotificationsController.java`, `NaConfig.kt`
- **UI** : Bouton "Surveiller l'activité" dans le profil contact

#### ★★★ F-07 · Tracking changements contacts (nom/photo/bio)
- **Impact** : Feature exclusive de Plus Messenger, très appréciée.
- **Comment** : Comparer les données au moment d'une update `TL_updateUserName` / `TL_updateUserPhoto`. Stocker dans une nouvelle table Room `ContactChanges(userId, field, oldVal, newVal, timestamp)`. UI dédiée accessible depuis le profil.
- **Fichiers** : `MessagesController.java`, nouveau `ContactChangesDB.java`, `ProfileActivity.java`

#### ★★ F-08 · Anti-screenshot par chat normal
- **Impact** : Feature de confidentialité forte demandée.
- **Comment** : Stocker une `Set<Long>` de `dialogIds` dans `NaConfig`. Dans `ChatActivity.onResume()` et `onPause()`, appliquer/retirer `WindowManager.LayoutParams.FLAG_SECURE` selon le dialogue actif.
- **Fichiers** : `ChatActivity.java`, `FlagSecureReason.java`, `NaConfig.kt`
- **UI** : Toggle dans le menu "..." du chat (3 points)

#### ★★ F-09 · Fond de chat par conversation (wallpaper per dialog)
- **Impact** : Très populaire, personnalisation visuelle forte.
- **Comment** : Stocker une map `dialogId → wallpaperId/filePath` dans `NaConfig`. Dans `ChatActivity`, charger le fond spécifique avant le fond global.
- **Fichiers** : `ChatActivity.java`, `ThemePreviewActivity.java`, `NaConfig.kt`

---

### Phase 3 — Features avancées (2-3 semaines chacune)

#### ★★★ F-10 · Export de chat (JSON / TXT)
- **Impact** : Feature unique sur mobile, inexistante ailleurs sur Android.
- **Comment** : Lire les messages depuis la DB Telegram locale (SQLite), sérialiser en JSON ou HTML formaté, partager via `Intent.ACTION_SEND`. Inclure médias optionnellement.
- **Fichiers** : Nouveau `ChatExporter.java`, `ChatActivity.java`, `MessagesStorage.java`

#### ★★ F-11 · Statistiques par chat
- **Impact** : Savoir combien de messages on a échangé, médias reçus, etc.
- **Comment** : Requêtes SQL sur la DB locale de Telegram dans `MessagesStorage.java`. Créer une `StatsActivity` affichant : total messages, messages par type (texte/photo/vidéo/vocal), premiers et derniers messages, top heure d'activité.
- **Fichiers** : `MessagesStorage.java`, nouveau `ChatStatsActivity.java`

#### ★★ F-12 · Chiffrement de la base de données locale
- **Impact** : Feature de sécurité forte (comme Molly).
- **Comment** : Intégrer SQLCipher. À la première configuration, demander une passphrase. Chiffrer la DB Telegram locale. **Attention** : lourde modification, impacte toute la couche de stockage.
- **Fichiers** : Toute la couche `MessagesStorage.java`, `ApplicationLoader.java`
- **Note** : Feature de Phase 3 lointaine — compléxité très haute

#### ★★ F-13 · Multi-comptes simultanés (sélection rapide)
- **Impact** : Productivité, populaire chez Exteragram.
- **Comment** : Ajouter une barre persistante (tab bar latérale ou bottom) affichant les avatars de chaque compte connecté avec badge de non-lus. Cliquer bascule de compte sans animation de chargement.
- **Fichiers** : `LaunchActivity.java`, `DrawerLayoutContainer.java`, `NaConfig.kt`

---

## PARTIE 5 — Avantages exclusifs de NovagramX à préserver

Ces features sont **uniques dans l'écosystème** et constituent notre identité :

| Feature exclusive | Description |
|---|---|
| **LLM natif (9 providers)** | Aucun autre client Android ne propose autant de providers IA intégrés |
| **Transcription multi-provider** | Cloudflare Whisper, Gemini, OpenAI Whisper — au choix |
| **Regex filters avec exclusions** | Filtrage précis par expression régulière par dialogue |
| **Ghost Mode lockable** | Verrouillable indépendamment pour chaque paramètre (unique) |
| **Réactions épinglées par type de chat** | Séparation chat vs channel pour les réactions fixées |
| **Solar Icons + MD3 switches** | Design moderne distinctif |
| **UnifiedPush natif** | Notifications sans Google, premier parmi les grands forks |
| **Préférences traduction par langue** | Liste de langues cibles prioritaires multiples |
| **Bookmark system intégré** | Par chat, avec accès direct depuis le header |
| **Forward without caption + no-quote** | Les deux options de forward discret disponibles |

---

## PARTIE 6 — Roadmap

```
Phase 1 · Semaines 1-2 · Quick wins
  ✦ F-01  Vitesse vocal inline dans les bulles
  ✦ F-02  Compteur caractères/mots dans l'input
  ✦ F-03  Police de caractères custom (TTF)
  ✦ F-04  Couleurs de noms contacts
  ✦ F-05  Compteur membres en ligne (header)

Phase 2 · Semaines 3-5 · Features réseau social
  ✦ F-06  Notification quand contact en ligne
  ✦ F-07  Tracking changements contacts
  ✦ F-08  Anti-screenshot par chat
  ✦ F-09  Fond de chat par conversation

Phase 3 · Semaines 6-10 · Features avancées
  ✦ F-10  Export de chat (JSON/TXT)
  ✦ F-11  Statistiques par chat
  ✦ F-12  Chiffrement DB locale
  ✦ F-13  Multi-comptes simultanés
```

---

*Généré le 08/05/2026 — Analyse complète du code source NagramX `dev` + 22 clients Telegram*
