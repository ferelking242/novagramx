# NovagramX — Analyse complète & Plan de développement

---

## 1. Panorama des clients Telegram & leurs features exclusives

| Client | Plateforme | Base | Features clés distinctives |
|---|---|---|---|
| **Telegram Officiel** | Android/iOS/Desktop | — | Stories, Topics, Boosts, Premium, Bots, Business |
| **Telegram X** | Android | TDLib | Plus rapide, interface expérimentale |
| **Nekogram / NekogramX** | Android | Telegram | Tabs custom, traduction multi-moteurs, IPv6, DNS custom, Ghost Mode basique |
| **AyuGram** | Android | Telegram | Ghost Mode avancé, historique messages supprimés/édités, last seen local, regex filters |
| **NagramX** | Android | Nekogram + AyuGram | LLM intégré, transcription vocale, Solar Icons, Monet, tout ce qu'il y a en dessous |
| **OwlGram** | Android | Telegram | Caméra améliorée (zoom, timer), transcription vocale, filtres messages, thèmes chat |
| **Exteragram** | Android | Telegram | Multi-compte affiché, Markdown editor, quick reactions panel |
| **Nicegram** | iOS | Telegram | Contenu restreint/18+, traduction, dossiers cloud, quick replies |
| **Plus Messenger** | Android | Telegram | Thèmes par chat, notif custom par chat, onglets custom, statistiques groupe |
| **Catogram** | Android | Telegram | UI minimaliste, thèmes simples |
| **Molly** | Android | Telegram | Sécurité renforcée (FOSS, no Google services, chiffrement DB local) |
| **Unigram** | Windows | TDLib | Client natif Windows, notifications système, intégration OS |
| **Mercurygram** | Android | Telegram | Sans Google services, privacy-first |

---

## 2. Features complètes de NagramX (depuis le code source)

### 2.1 — Vie privée & Ghost Mode (AyuGram)
| Feature | Config key | Défaut |
|---|---|---|
| Ghost Mode — pas de read receipts | `sendReadMessagePackets` | ON |
| Ghost Mode — pas de read pour les stories | `sendReadStoriesPackets` | ON |
| Ghost Mode — cacher statut en ligne | `sendOnlinePackets` | ON |
| Ghost Mode — cacher "en train d'envoyer..." | `sendUploadProgress` | ON |
| Aller offline immédiatement après une action | `sendOfflinePacketAfterOnline` | OFF |
| Afficher Ghost Mode dans le drawer | `showGhostInDrawer` | OFF |
| Afficher le statut Ghost Mode | `showGhostModeStatus` | OFF |
| Verrouiller les params Ghost Mode | `*Locked` configs | OFF |

### 2.2 — Sauvegarde de messages (AyuGram database)
| Feature | Config key | Défaut |
|---|---|---|
| Sauvegarder les messages supprimés | `EnableSaveDeletedMessages` | OFF |
| Sauvegarder l'historique des modifications | `EnableSaveEditsHistory` | OFF |
| Sauvegarder last seen local | `SaveLocalLastSeen` | OFF |
| Sauvegarder les médias dans les messages | `MessageSavingSaveMedia` | ON |
| Sauvegarder médias — chats privés | `SaveMediaInPrivateChats` | ON |
| Sauvegarder médias — channels publics | `SaveMediaInPublicChannels` | ON |
| Sauvegarder médias — channels privés | `SaveMediaInPrivateChannels` | ON |
| Sauvegarder médias — groupes publics | `SaveMediaInPublicGroups` | ON |
| Sauvegarder médias — groupes privés | `SaveMediaInPrivateGroups` | ON |
| Sauvegarder messages de bots | `SaveDeletedMessageForBot` | OFF |
| Marque personnalisée pour messages supprimés | `CustomDeletedMark` | "" |
| Messages supprimés translucides | `TranslucentDeletedMessages` | ON |
| Icône "supprimé" custom | `UseDeletedIcon` | ON |
| Icône "modifié" custom | `UseEditedIcon` | ON |

### 2.3 — IA & LLM intégré
| Feature | Config key |
|---|---|
| **OpenAI** — clé API + modèle | `LlmProviderOpenAIKey/Model` |
| **Gemini** — clé API + modèle | `LlmProviderGeminiKey/Model` |
| **xAI (Grok)** — clé API + modèle | `LlmProviderXAIKey/Model` |
| **Groq** — clé API + modèle | `LlmProviderGroqKey/Model` |
| **DeepSeek** — clé API + modèle | `LlmProviderDeepSeekKey/Model` |
| **Cerebras** — clé API + modèle | `LlmProviderCerebrasKey/Model` |
| **Ollama** (self-hosted) | `LlmProviderOllamaCloudKey/Model` |
| **OpenRouter** — clé API + modèle | `LlmProviderOpenRouterKey/Model` |
| **Vercel AI Gateway** | `LlmProviderVercelAIGatewayKey/Model` |
| URL API custom (OpenAI-compatible) | `LlmApiUrl` / `LlmApiKey` |
| Prompt système custom | `LlmSystemPrompt` |
| Prompt utilisateur custom | `LlmUserPrompt` |
| Température LLM | `LlmTemperature` (0.7 défaut) |
| Utiliser contexte des messages précédents | `LlmUseContext` |
| Taille du contexte | `LlmContextSize` |
| Traduction via LLM | `ShowTranslateMessageLLM` |

### 2.4 — Transcription vocale
| Feature | Config key |
|---|---|
| Transcription via Cloudflare Whisper | `TranscribeProviderCfAccountID/ApiToken` |
| Transcription via Gemini | `TranscribeProviderGeminiApiKey` |
| Transcription via OpenAI Whisper | `TranscribeProviderOpenAiApiBase/Model/ApiKey` |
| Prompt de transcription custom | `TranscribeProviderOpenAiPrompt` |

### 2.5 — Traduction
| Feature | Config key |
|---|---|
| Moteurs : Google, DeepL, Microsoft, Yandex, LLM | `translationProvider` |
| Traducteur d'articles séparé | `EnableSeparateArticleTranslator` |
| Auto-traduction mode (off/manuel/auto) | `translatorMode` |
| Garder le Markdown après traduction | `translatorKeepMarkdown` |
| Langues cibles préférées (multiples) | `PreferredTranslateTargetLang` |
| Google Translate expérimental | `GoogleTranslateExp` |

### 2.6 — UI & Personnalisation
| Feature | Config key | Défaut |
|---|---|---|
| Titre app custom | `CustomTitle` | "Nagram X" |
| Titre = nom du dossier actif | `FolderNameAsTitle` | OFF |
| Titre centré (toujours/settings/chats) | `CenterActionBarTitleType` | Toujours |
| Icon packs (Solar Icons, autres) | `IconReplacements` | 0 |
| Style des switches (défaut/Modern/MD3) | `SwitchStyle` | Défaut |
| Style des sliders (défaut/Modern/MD3) | `SliderStyle` | Défaut |
| Fond du drawer (avatar/big avatar/wallpaper) | `DrawerBackground` | Défaut |
| Support Monet (couleurs système Android 12+) | (MonetHelper) | — |
| Cacher les dividers | `HideDividers` | OFF |
| Fond coloré des messages | `MessageColoredBackground` | ON |
| Flou forcé dans le chat | `forceBlurInChat` | OFF |
| Valeur alpha du flou | `forceBlurInChatAlphaValue` | 127 |
| Afficher les secondes dans les timestamps | `showSeconds` | OFF |
| Animation crossfade spring | `SpringAnimationCrossfade` | ON |
| Mode tablette | `TabletMode` | Auto |

### 2.7 — Tabs & Navigation
| Feature | Config key |
|---|---|
| Cacher l'onglet "Tous" | `HideAllTab` |
| Type de titre des onglets (texte/icône/mix) | `tabsTitleType` |
| Ouvrir les archives en tirant vers le bas | `OpenArchiveOnPull` |
| Cacher les archives | `HideArchive` |
| Ne pas désarchiver en swipant | `DoNotUnarchiveBySwipe` |
| Cacher le bouton flottant des dialogues | `DisableDialogsFloatingButton` |
| Désactiver swipe vers prochain channel | `disableSwipeToNext` |

### 2.8 — Messages & Chat
| Feature | Config key |
|---|---|
| Double-tap action configurable (in/out) | `DoubleTapAction` / `DoubleTapActionOut` |
| Forward sans citation (No-Quote Forward) | `showNoQuoteForward` |
| Repeat as Copy | `showRepeatAsCopy` |
| Combiner les messages au forward | `CombineMessage` |
| Message silencieux par défaut | `SilentMessageByDefault` |
| Filtre Zalgo (caractères spéciaux) | `ZalgoFilter` |
| Filtre Regex (messages) | `RegexFiltersEnabled` / `RegexFiltersData` |
| Filtre Regex dans les chats | `RegexFiltersEnableInChats` |
| Bloquer des channels | `BlockedChannelsData` |
| Filtrer des utilisateurs | `CustomFilteredUsersData` |
| Date des messages forwardés | `DateOfForwardedMsg` |
| Afficher l'ID du message | `ShowMessageID` |
| Afficher ID + DC | `ShowIdAndDc` |
| Afficher l'erreur RPC | `ShowRPCError` |
| Toujours afficher l'icône de téléchargement | `AlwaysShowDownloadIcon` |
| Mark "édité" personnalisée | `CustomEditedMessage` |
| Désactiver Markdown | `DisableMarkdown` |
| Parser Markdown (Telegram/Neko) | `MarkdownParser` |
| Pangu (espacement CJK automatique) | `EnablePanguOnSending` |
| Afficher les spoilers directement | `showSpoilersDirectly` |
| GIF en petite taille | `ShowSmallGIF` |
| Désactiver clic sur commande = envoi | `DisableClickCommandToSend` |
| Reply en privé depuis un groupe | `showReplyInPrivate` |
| Ne pas lire automatiquement le vocal suivant | `DontAutoPlayNextVoice` |

### 2.9 — Stickers & Emojis
| Feature | Config key |
|---|---|
| Stickers favoris illimités | `UnlimitedFavoredStickers` |
| Pins illimités | `UnlimitedPinnedDialogs` |
| Taille des stickers custom | `stickerSize` |
| Cacher sticker de groupe | `hideGroupSticker` |
| Désactiver section Trending | `DisableTrending` |
| Ne pas envoyer le sticker de bienvenue | `DontSendGreetingSticker` |
| Cacher le temps sur les stickers | `HideTimeForSticker` |
| Créateur de stickers minimisé | `minimizedStickerCreator` |
| Émojis système | `EmojiUseDefault` |
| Reactions épinglées par chat/channel | `UsePinnedReactionsChats` / `UsePinnedReactionsChannels` |
| Cacher reactions | `HideReactions` |

### 2.10 — Réseau & Connexion
| Feature | Config key |
|---|---|
| IPv6 | `IPv6` |
| DNS-over-HTTPS custom | `CustomDoH` |
| Type DNS (défaut/NAX/système/custom) | `DnsType` |
| API ID/Hash custom | (NekoXConfig) |
| Désactiver proxy si VPN actif | `DisableProxyWhenVpnEnabled` |
| Enhanced File Loader | `enhancedFileLoader` |
| Upload Boost | `uploadBoost` |

### 2.11 — Média & Audio/Vidéo
| Feature | Config key |
|---|---|
| Bitrate audio custom | `customAudioBitrate` |
| Bitrate vidéo amélioré | `EnhancedVideoBitrate` |
| Suppression bruit + amélioration voix | `NoiseSuppressAndVoiceEnhance` |
| Qualité HLS par défaut | `DefaultHlsVideoQuality` |
| Caméra arrière pour vidéo messages | `rearVideoMessages` |
| Décodeur vidéo (Software/Hardware) | `VideoPlayerDecoder` |
| GIF comme vidéo | `TakeGIFasVideo` |
| Envoyer MP4 comme vidéo (pas document) | `SendMp4DocumentAsVideo` |

### 2.12 — Menu contextuel & ActionBar
| Feature | Toggleable |
|---|---|
| Bouton Reply dans ActionBar | Oui |
| Bouton Edit dans ActionBar | Oui |
| Bouton Select Between | Oui |
| Bouton Copy | Oui |
| Bouton Forward | Oui |
| Add to Saved Messages | Oui |
| Report | Oui |
| View History | Oui |
| Admin Actions | Oui |
| Change Permissions | Oui |
| Delete Downloaded File | Oui |
| Message Details | Oui |
| Translate | Oui |
| Repeat | Oui |
| Share Messages | Oui |
| Set Reminder | Oui |
| Copy Photo | Oui |
| Media viewer — Forward | Oui |
| Media viewer — No-Quote Forward | Oui |
| Media viewer — Copy Frame | Oui |
| Media viewer — Copy Photo | Oui |
| Media viewer — Set Profile Photo | Oui |
| Media viewer — Scan QR Code | Oui |
| Copy Photo as Sticker | Oui |
| Add to Stickers | Oui |
| Translate via LLM | Oui |

### 2.13 — Autres
| Feature | Config key |
|---|---|
| Local Premium (UI premium sans abonnement) | `localPremium` |
| Ignorer restrictions de contenu | `ignoreContentRestrictions` |
| Cacher la section Premium | `HidePremiumSection` |
| Cacher la section Aide | `HideHelpSection` |
| Calendrier persan | `UsePersianCalendar` |
| Trier par non-lu/non-muet/contacts | `sort_by_unread` etc. |
| Type de push service (FCM/UnifiedPush) | `PushServiceType` |
| Classe de performance manuelle | `PerformanceClass` |
| Désactiver Crashlytics | `DisableCrashlyticsCollection` |
| Chemin de sauvegarde custom | `customSavePath` |
| Auto-update channel (release/beta/off) | `AutoUpdateChannel` |
| Mode bouton gauche (bas du chat) | `LeftBottomButtonAction` |
| Raccourcis : Admins, Event Log, Stats... | `shortcuts*` |

---

## 3. Features d'autres clients NON présentes dans NagramX

### Haute valeur — Absentes dans NagramX
| Feature | Client source | Complexité |
|---|---|---|
| **Notification sonore par chat** (son différent par chat) | Plus Messenger | Moyenne |
| **Caméra améliorée** (zoom, timer, grille) | OwlGram | Haute |
| **Vitesse de lecture vocal en accès rapide** (bouton 1x/1.5x/2x inline) | OwlGram | Faible |
| **Online notification** (notif quand un contact devient en ligne) | OwlGram | Moyenne |
| **Anti-screenshot** par chat | Molly | Moyenne |
| **Chiffrement base de données locale** | Molly | Haute |
| **Export chat en JSON/HTML** | Telegram Desktop | Haute |
| **Statistiques de lecture** par chat | Exteragram | Moyenne |
| **Batch forward** (forward vers plusieurs chats en une fois) | - | Faible |
| **Quick reactions panel** personnalisable (order custom) | Exteragram | Faible |
| **Message bookmark** (différent de Saved Messages — catégories) | - | Moyenne |
| **Fond de chat différent par conversation** | Plus Messenger | Moyenne |
| **Police de caractères** custom (au-delà de la police système) | Plus Messenger | Faible |
| **Filtre par type de média** dans la recherche chat | Telegram Desktop | Moyenne |
| **Compteur de mots/caractères** dans le champ de saisie | - | Très faible |
| **Auto night mode** basé sur l'heure | OwlGram | Faible |

---

## 4. Plan NovagramX — Features à ajouter (prioritisées)

### Niveau 1 — Facile, fort impact (< 1 semaine chacune)

#### F-01 · Compteur de mots/caractères dans le champ de saisie
- **Pourquoi** : Demandé par des milliers d'utilisateurs, utile pour posts/canaux
- **Comment** : Modifier `ChatActivity.java` — ajouter un `TextView` overlay sur le champ de saisie, compter en temps réel
- **Fichiers** : `ChatActivity.java`, `NaConfig.kt` (toggle on/off), `NekoChatSettingsActivity.java`

#### F-02 · Vitesse lecture vocal inline (bouton rapide)
- **Pourquoi** : NagramX a le toggle global mais pas de bouton inline dans le player audio
- **Comment** : Ajouter un bouton 1x → 1.5x → 2x dans `VoiceMessagePlaybackView` ou le player audio
- **Fichiers** : `MediaController.java`, cells audio dans `ChatMessageCell.java`

#### F-03 · Batch forward (forward vers plusieurs chats d'un coup)
- **Pourquoi** : Feature très demandée, différenciante
- **Comment** : Modifier le dialog de sélection de forward pour accepter une liste multi-chats
- **Fichiers** : `ShareAlert.java`, `ForwardParams.java`

#### F-04 · Quick reactions panel — ordre personnalisable
- **Pourquoi** : NagramX peut épingler des reactions mais pas réorganiser le panel rapide
- **Comment** : Drag-and-drop dans les settings de reactions, stocker l'ordre dans `NaConfig`
- **Fichiers** : `ReactionsDoubleTapView.java`, `NaConfig.kt`

#### F-05 · Auto night mode basé sur l'heure
- **Pourquoi** : Complète le système de thèmes existant
- **Comment** : Scheduler dans `ApplicationLoader`, toggle + plage horaire dans les settings
- **Fichiers** : `ApplicationLoader.java`, `NekoGeneralSettingsActivity.java`, `NaConfig.kt`

#### F-06 · Police de caractères custom
- **Pourquoi** : Feature populaire (Plus Messenger), facile à implémenter via `Typeface`
- **Comment** : Charger une police TTF depuis le stockage ou bundled, appliquer via `AndroidUtilities`
- **Fichiers** : `AndroidUtilities.java`, `NekoGeneralSettingsActivity.java`

---

### Niveau 2 — Impact moyen, effort moyen (1-2 semaines chacune)

#### F-07 · Online notification (alerte quand contact en ligne)
- **Pourquoi** : Populaire chez OwlGram, NagramX a déjà `showOnlineStatus`
- **Comment** : Hook sur les updates de présence dans `MessagesController`, envoyer notif locale
- **Fichiers** : `MessagesController.java`, `NotificationsController.java`, `NaConfig.kt`

#### F-08 · Fond de chat par conversation
- **Pourquoi** : Différencier visuellement ses conversations
- **Comment** : Stocker une map `dialogId → wallpaperId` dans `NaConfig`, charger dans `ChatActivity`
- **Fichiers** : `ChatActivity.java`, `ThemePreviewActivity.java`, `NaConfig.kt`

#### F-09 · Statistiques de lecture par chat
- **Pourquoi** : Savoir combien de messages on a lu/envoyé dans un chat
- **Comment** : Compteurs locaux dans la DB AyuGram ou une nouvelle table Room
- **Fichiers** : `AyuDatabase.java`, nouvelle entité `ChatStats`, UI dans profil du chat

#### F-10 · Notification sonore par chat
- **Pourquoi** : Identifier un chat à l'oreille sans regarder l'écran
- **Comment** : Stocker une map `dialogId → soundUri` dans `NaConfig`, injecter dans `NotificationsController`
- **Fichiers** : `NotificationsController.java`, profil chat UI, `NaConfig.kt`

---

### Niveau 3 — Complexe mais très différenciant (2-4 semaines)

#### F-11 · Anti-screenshot par chat
- **Pourquoi** : Feature de confidentialité forte (Molly/Signal)
- **Comment** : `WindowManager.LayoutParams.FLAG_SECURE` activé/désactivé par `dialogId` dans `ChatActivity`
- **Fichiers** : `ChatActivity.java`, `NaConfig.kt`

#### F-12 · Export chat (JSON / texte)
- **Pourquoi** : Feature unique sur mobile (dispo que sur Desktop)
- **Comment** : Parser les messages depuis la DB Telegram locale, générer JSON/HTML, partager via `Intent`
- **Fichiers** : Nouveau `ChatExporter.java`, `ChatActivity.java`

#### F-13 · Message Bookmark avec catégories
- **Pourquoi** : Au-delà des Saved Messages — système de signets organisés
- **Comment** : Nouvelle table Room `bookmarks(messageId, chatId, category, note)`, UI dédiée
- **Fichiers** : Nouveau `BookmarkDatabase.java`, `BookmarkActivity.java`, `NaConfig.kt`

---

## 5. Roadmap suggérée

```
Phase 1 (Semaine 1-2) — Quick wins
  ✦ F-01 Compteur de caractères
  ✦ F-02 Vitesse vocal inline
  ✦ F-03 Batch forward
  ✦ F-04 Quick reactions order
  ✦ F-05 Auto night mode
  ✦ F-06 Police custom

Phase 2 (Semaine 3-4) — Features réseau social
  ✦ F-07 Online notification
  ✦ F-08 Fond par chat
  ✦ F-10 Notif sonore par chat

Phase 3 (Semaine 5-8) — Features avancées
  ✦ F-09 Stats de lecture
  ✦ F-11 Anti-screenshot
  ✦ F-12 Export chat
  ✦ F-13 Bookmark system
```

---

## 6. Ce que NagramX a et que personne d'autre n'a (nos avantages à garder)

- **LLM intégré natif** (9 providers) — unique dans l'écosystème Telegram
- **Transcription vocale multi-provider** (CF Whisper + Gemini + OpenAI)
- **Regex filters** avec exclusions par dialogue
- **Ghost mode lockable** (verrouillable par passcode)
- **Reactions épinglées** configurables séparément par chat et par channel
- **Solar Icons** & switch styles MD3
- **UnifiedPush** (push sans Google)
- **Auto-update channel** (release/beta)

---

*Généré le 08/05/2026 — Analyse du code source NagramX branche `dev`*
