# 副資材管理システム（ Kanri ）
このプロジェクトは、Spring Bootを使用した副資材管理システムです。

生産工場において、作業員および管理者が副資材の在庫情報を管理できるシステムを想定します。

## 👥 ユーザー分類と機能概要

### 管理者向け機能 (FA)

- 副資材の追加・編集・削除

- 作業員からの申請内容の確認・承認・却下

### チーム(作業員)向け機能 (FT)

- 配置場所やカテゴリーから副資材を検索・閲覧

- 資材の新規・補充申請

## 📁 主なプロジェクト構成

```
Kanri/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/app/
│       │       ├── config/             　 # アプリ全体の設定クラス（認証、バリデーション設定など）
│       │       ├── controller/         　 # HTTPリクエスト処理（画面とやりとり）
│       │       ├── domain/             　 # テーブル対応のデータ保持クラス
│       │       ├── filter/             　 # リクエストの前処理・後処理用フィルター
│       │       ├── mapper/             　 # MyBatis用Mapperインターフェース
│       │       ├── service/             　# ビジネスロジック(業務処理、データ操作)を担当
│       │       └── KanriApplication.java  # アプリ起動クラス（mainメソッド）
│       └── resources/
│           ├── mybatis/               　  # Mapper XMLファイル（SQL記述）
│           ├── static/                　  # 静的リソース（CSS, JS, 画像など）
│           ├── templates/             　  # HTMLテンプレート（Thymeleafなど）
│           ├── application.properties 　  # アプリケーション設定
│           └── validation.properties  　  # バリデーションエラーメッセージ定義
├── pom.xml                            　  # Mavenビルド設定・依存ライブラリ
```

## 🛠️ 開発環境・技術構成
- Java 21 / Spring Boot 3.4.3
- Thymeleaf / Bootstrap / MyBatis
- MySQL / Maven
