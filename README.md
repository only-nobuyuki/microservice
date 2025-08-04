#### 対象読者
- 未来の自分（忘れた頃の再参照）

#### 目的と動機
- このプロジェクトは、**マイクロサービス連携やAPI設計、Docker運用、Springの比較学習**を目的とした自己学習用の構成です。
- 技術選定や設計方針は、過去の業務での経験や疑問、今後必要となりそうな技術スタックに基づき構築。

##### 背景例：
- **API連携** → 直近の業務でAPI修正に関与。REST設計や型の定義の必要性を実感。
- **Docker** → ChatGPTとの対話の中でマイクロサービス運用の便利さを知り、触るタイミングを模索していた。
- **Spring構成比較** → Bootあり・なし、軽量構成の比較を通じて現場ごとの構成選択力を高めたい。

#### プロダクト概要
- 三つのREST APIサービスが連携して動作する、**疑似的なECサイト風バックエンド**構成。
- 実際のUIやDB設計は簡素だが、構成力・連携理解・設計原則の実装に主眼を置く。

#### 各サービスの特徴（概要）
- `Inventory Service`：Servletベース、SQLite or H2
- `User Service`：Spring Framework + PostgreSQL
- `Order Service`：Spring Boot + MySQL

#### 開発環境
- Windows 11 + WSL2（Ubuntu）
- VSCode + Docker Desktop + Git + sdkman
- Java 17（sdkmanで管理）、Maven / Gradle 両対応

#### 進め方
- ChatGPTとの対話を通じて、体験したい技術を言語化＆段階設計
- 単なる動作確認ではなく、**「なぜそうするか」** を調査と対話で確認しながら実装
