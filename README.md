# 副資材管理システム（ Kanri ）
このプロジェクトは、Spring Bootを使用した副資材管理システムです。

生産工場において、作業員および管理者が副資材の在庫情報を管理できるシステムを想定します。


## 管理者向け機能 (FA)

・副資材の追加・編集・削除が可能

・作業員からの申請内容の確認が可能

## チーム(作業員)向け機能 (FT)

・配置場所やカテゴリーから副資材リストの確認ができる

・新規資材の申請や補充申請が可能


## 🧩 管理者向け機能一覧

### FA01 ユーザー認証機能

| 機能ID   | 機能名    | 説明                                      |
| ------ | ------ | --------------------------------------- |
| FA01-1 | ユーザー認証 | セッションに管理者IDが格納されているかを確認。不在の場合はログイン画面に遷移 |
| FA01-2 | ログイン   | IDとパスワード確認後、正しければセッションに管理者IDを格納         |
| FA01-3 | ログアウト  | セッションの管理者IDを破棄                          |

### FA02 資材管理機能

| 機能ID   | 機能名  | 説明            |
| ------ | ---- | ------------- |
| FA02-1 | 資材一覧 | 登録済みの資材を一覧表示  |
| FA02-2 | 資材登録 | 新しい資材を登録する    |
| FA02-3 | 資材編集 | 既存の資材情報を編集・更新 |
| FA02-4 | 資材削除 | 指定された資材を削除    |

### FA03 資材配置管理機能

| 機能ID   | 機能名    | 説明          |
| ------ | ------ | ----------- |
| FA03-1 | 配置情報一覧 | 各資材の配置数量を表示 |
| FA03-2 | 配置情報更新 | 資材の配置数量を更新  |

### FA04 ページ分割機能

| 機能ID   | 機能名         | 説明                   |
| ------ | ----------- | -------------------- |
| FA04-1 | 資材リストのページ分割 | 1ページ15件表示、ページ番号で移動可能 |

### FA05 申請管理機能
| 機能ID   | 機能名       | 説明                                                        |
| ------ | --------- | --------------------------------------------------------- |
| FA05-1 | 申請一覧表示    | 登録済みの申請を一覧表示                      |
| FA05-2 | 申請詳細表示    | 特定の申請情報を詳細表示し、承認または却下を行うフォームを表示                       |
| FA05-3 | 申請ステータス更新 | 詳細画面のフォームから、申請の承認 (`APPROVED`) または却下 (`REJECTED`) を更新 |
| FA05-4 | 申請削除      | 指定された申請情報を削除                        |


## 🧩 チーム(作業員)向け機能一覧

### FT01 ユーザー認証機能

| 機能ID   | 機能名    | 説明                             |
| ------ | ------ | ------------------------------ |
| FT01-1 | ユーザー認証 | セッションに部署IDがあるか確認。不在時はログイン画面に遷移 |
| FT01-2 | ログイン   | ID/パスワード確認後、生徒IDをセッションに格納      |
| FT01-3 | ログアウト  | セッションの部署IDを破棄                  |

### FT02 資材検索機能

| 機能ID   | 機能名       | 説明             |
| ------ | --------- | -------------- |
| FT02-1 | 資材一覧      | 全資材を一覧表示       |
| FT02-2 | 場所ごとの絞り込み | roomIdで資材を絞り込む |

### FT03 資材詳細閲覧機能

| 機能ID   | 機能名    | 説明                      |
| ------ | ------ | ----------------------- |
| FT03-1 | 資材詳細表示 | 選択した資材の詳細（名称、購入日、備考）を表示 |

### FT04 ページ分割機能

| 機能ID   | 機能名         | 説明                   |
| ------ | ----------- | -------------------- |
| FT04-1 | 資材リストのページ分割 | 1ページ10件表示、ページ番号で移動可能 |

### FT05 申請機能

| 機能ID   | 機能名      | 説明                                                                  |
| ------ | -------- | ------------------------------------------------------------------- |
| FT05-1 | 申請フォーム表示 | 新規申請フォームを表示                |
| FT05-2 | 申請送信処理   |申請内容を登録 |


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


## パッケージ構成（`com.example.app`）

### ⚙️ config パッケージ

* `ValidationConfig.java`：入力バリデーション設定
* `FilterConfig.java`：認証フィルター設定

### 🧭 controller パッケージ

* `AdminController.java`：管理者向けページのリクエスト処理（登録・編集・削除）
* `AdminRequestController.java`：管理者向け申請ページのリクエスト処理
* `LoginController.java`：管理者のログイン・ログアウト処理
* `StaffController.java`：作業員向けページのリクエストを処理
* `TeamLoginController.java`：チーム(作業員)のログイン・ログアウト処理
* `TeamRequestController.java`：チーム(作業員)向け申請ページのリクエスト処理

### 🏷️ domain パッケージ

* `Admin.java`：管理者データクラス
* `Item.java`：資材データクラス
* `Placement.java`：配置データクラス
* `Requset.java`：申請データクラス
* `Room.java`：場所データクラス
* `Team.java`：チームデータクラス

### 🛡️ filter パッケージ

* `AuthFilter.java`：ユーザー認証用フィルター

### 🗺️ mapper パッケージ

* `AdminMapper.java`：adminsテーブル操作
* `ItemMapper.java`：itemsテーブル操作
* `PlacementMapper.java`：placementsテーブル操作
* `RequestMapper.java`：requestsテーブル操作
* `RoomMapper.java`：roomsテーブル操作
* `TeamMapper.java`：teamsテーブル操作

### 🛠️ service パッケージ

* `AdminService.java`：管理者認証処理インターフェース
* `AdminServiceImpl.java`：管理者認証処理実装
* `ItemService.java`：資材操作インターフェース
* `ItemServiceImpl.java`：資材操作実装
* `RequestService.java`：申請操作インターフェース
* `RequestServiceImpl.java`：申請操作実装
* `RoomService.java`：部屋操作インターフェース
* `RoomServiceImpl.java`：部屋操作実装
* `TeamService.java`：チーム(作業員)認証処理インターフェース
* `TeamServiceImpl.java`：チーム(作業員)認証処理実装


## resources 内

### mybatis フォルダ

* 各種Mapper.xmlファイル（SQL記述）

### static フォルダ

* css/js：`bootstrap.min.css`, `style.css`, `bootstrap.min.js`

### templates フォルダ

* admin：`add.html`, `edit.html`, `login.html`,`index.html`,`request-edit.html`,`request-list.html`
* team：`index.html`, `login.html`,`request-from.html`,`show.html`
* parts：`common.html`,

*   `validation.properties`：バリデーションエラーメッセージを記入


## アプリケーション構成図（MVC + DB連携)

※ Controller → Thymeleaf 間で Model を介してデータを渡します。

       ┌─────────────────┐
       │     Client      │ ◀───────────────────────────┐
       └───────┬─────────┘　　　　　             　     │
               │ Request　　　　　　             　     │ response
               ▼         　　　　　 　                  │
       ┌──────────────┐   　　      　　　　　　  ┌─────┴───────┐
       │  Controller  │ ーー▶ 〈 model 〉 ◀ーー　 │  Thymeleaf  │
       └──────────────┘  ーーー forward ーーー▶   └─────────────┘
               ▲
               │ Calls
               ▼
       ┌──────────────┐   　　
       │    Service   │ 
       └──────────────┘ 
               ▲
               │ Uses Mapper
               ▼
       ┌──────────────┐   　　┌───────────┐
       │    Mapper    │ ーー▶ │  MyBatis  │  
       └──────────────┘   　　└─────┬─────┘
               ▲　　　　　　　　　　　│
               │                    │ SQL Access
               │　　　　　　　　　　　▼
         ╭───────────────────────────────╮
         │    　　　 Database  　　　　　　│
         ╰───────────────────────────────╯


## ⚙️ config パッケージ詳細
### 共通アノテーション
- @Configuration (Springの設定クラスを示す)
- @Bean (設定クラス内のメソッドに付けることで、SpringのDIコンテナがそのメソッドの戻り値を管理する)

### FilterConfig
- 認証フィルター(AuthFilter)を有効化しつつ、特定のURLパターンに適用して認証制御を行うための設定

| メソッド名          | 戻り値の型                                | 説明                                                   |
| -------------- | ------------------------------------ | ---------------------------------------------------- |
| `authFilter()` | `FilterRegistrationBean<AuthFilter>` | `/admin/*` と `/team/*` に対して `AuthFilter` を適用するフィルタ登録 |

### ValidationConfig
- バリデーションメッセージをカスタマイズする設定クラス
- validation.properties ファイルのメッセージを使用可能にするための設定

| メソッド名             | 戻り値の型                         | 説明                                                |
| ----------------- | ----------------------------- | ------------------------------------------------- |
| `getValidator()`  | `Validator`                   | `LocalValidatorFactoryBean` を返し、カスタムメッセージソースを設定する |
| `messageSource()` | `ResourceBundleMessageSource` | `validation.properties` をメッセージソースとして登録            |


## 🧭 controller パッケージ詳細
### 共通アノテーション 
- @Controller (SpringにWebリクエストを処理するコントローラーとして認識させる)
- @RequiredArgsConstructor (finalフィールドに対する引数を持つコンストラクタを自動生成)

### AdminController
- 管理者用資材管理画面を担当するコントローラー（`@RequestMapping("/admin")`）

| フィールド名        | 型             | 説明                         |
| ------------- | ------------- | -------------------------- |
| `itemService` | `ItemService` | 資材情報の取得・追加・更新・削除を担当するサービス層 |
| `session`     | `HttpSession` | ページ番号の保存などに使用するセッション       |


| メソッド          | 戻り値      | 引数                                        | 説明                |
| ------------- | -------- | ----------------------------------------- | ----------------- |
| `index`       | `String` | `@RequestParam Integer page, Model model` | 管理者用資材一覧表示（ページ分割） |
| `add (GET)`   | `String` | `Model model`                             | 資材登録フォーム表示        |
| `add (POST)`  | `String` | `Item item, Errors errors, Model model`   | 資材登録処理            |
| `edit (GET)`  | `String` | `Integer id, Model model`                 | 資材編集フォーム表示        |
| `edit (POST)` | `String` | `Item item, Errors errors, Model model`   | 資材編集処理            |
| `delete`      | `void`   | `Integer id`                              | 資材削除処理            |


### AdminRequestController
- 管理者用の申請管理を担当するコントローラー（@RequestMapping("/admin/request")）

| フィールド名           | 型                | 説明                           |
| ---------------- | ---------------- | ---------------------------- |
| `requestService` | `RequestService` | 申請情報の取得、承認・却下、削除などを担当するサービス層 |

| メソッド            | 戻り値      | 引数                                                                                               | 説明                     |
| --------------- | -------- | ------------------------------------------------------------------------------------------------ | ---------------------- |
| `index`         | `String` | `Model model`                                                                                    | 申請一覧表示（管理者画面）          |
| `edit (GET)`    | `String` | `@RequestParam("id") int id, Model model`                                                        | 申請詳細画面の表示（承認または却下フォーム） |
| `edit (POST)`   | `String` | `@ModelAttribute Request request`                                                                | 申請ステータス更新（承認または却下の処理）  |
| `deleteRequest` | `String` | `@RequestParam(name = "id", required = false) Integer id, RedirectAttributes redirectAttributes` | 申請の削除処理と結果メッセージ設定      |


### LoginController
- 管理者のログイン・ログアウト機能を担当するコントローラー（@RequestMapping("/admin/request")）

| メソッド           | 戻り値      | 引数                                                | 説明        |
| -------------- | -------- | ------------------------------------------------- | --------- |
| `login (GET)`  | `String` | `Model model`                                     | ログインページ表示 |
| `login (POST)` | `String` | `Admin admin, Errors errors, HttpSession session` | ログイン処理    |
| `logout`       | `void`   | `なし（HttpSessionはフィールドとして使用）`                      | ログアウト処理   |

| メソッド    | 戻り値      | 引数                                               | 説明                   |
| ------- | -------- | ------------------------------------------------ | -------------------- |
| `index` | `String` | `String roomId, Integer categoryId, Model model` | 資材リスト表示。部屋/カテゴリで絞り込み |
| `show`  | `String` | `Integer id, Model model`                        | 資材詳細表示               |


### TeamLoginController
- チーム用ログイン機能を担当するコントローラー（@RequestMapping("/team")）

| フィールド名        | 型             | 説明                   |
| ------------- | ------------- | -------------------- |
| `teamService` | `TeamService` | チーム情報の認証処理を担当するサービス層 |
| `session`     | `HttpSession` | ログイン状態管理のためにセッションを使用 |

| メソッド           | 戻り値      | 引数                                | 説明                  |
| -------------- | -------- | --------------------------------- | ------------------- |
| `login (GET)`  | `String` | `Model model`                     | ログインフォーム表示          |
| `login (POST)` | `String` | `@Valid Team team, Errors errors` | ログイン認証処理（バリデーション含む） |
| `logout`       | `String` | `なし（HttpSessionはフィールドとして使用）`      | ログアウト処理（セッション破棄）    |


### TeamRequestController
- チームメンバー向けの申請フォームと申請送信処理を担当するコントローラー

| フィールド名           | 型                | 説明                     |
| ---------------- | ---------------- | ---------------------- |
| `requestService` | `RequestService` | 申請情報の作成などのサービス層との連携を担当 |

| メソッド       | 戻り値      | 引数                                                                        | 説明                 |
| ---------- | -------- | ------------------------------------------------------------------------- | ------------------ |
| `showForm` | `String` | `Model model`                                                             | 申請フォームの表示          |
| `submit`   | `String` | `@Valid Request request, Errors errors, HttpSession session, Model model` | 申請送信処理（バリデーション・登録） |


## 🏷️ domain パッケージ詳細
### 共通アノテーション 
- @Data (Javaクラスに必要な基本メソッド(アクセッサ等)を自動生成)

### Admin

| フィールド       | 型         | 説明         |
| ----------- | --------- | ---------- |
| `id`        | `Integer` | 管理者ID      |
| `loginId`   | `String`  | ログインID     |
| `loginPass` | `String`  | 暗号化済みパスワード |
| `name`      | `String`  | 管理者名       |

### Item

| フィールド         | 型         | 説明   |
| ------------- | --------- | ---- |
| `id`          | `Integer` | 資材ID |
| `name`        | `String`  | 資材名  |
| `purchasedAt` | `Date`    | 購入日  |
| `loginId`     | `String`  | 備考   |
| `loginPass`   | `Integer` | 総数   |

### Placement

| フィールド    | 型         | 説明   |
| -------- | --------- | ---- |
| `item`   | `Item`    | 資材   |
| `room`   | `Room`    | 場所   |
| `amount` | `Integer` | 配置数量 |

### Room

| フィールド  | 型        | 説明   |
| ------ | -------- | ---- |
| `id`   | `String` | 場所ID |
| `name` | `String` | 場所名  |

### Request

| フィールド          | 型               | 説明                                      |
| -------------- | --------------- | --------------------------------------- |
| `id`           | `Integer`       | 申請ID                                    |
| `teamId`       | `String`        | 申請したチームのID                              |
| `title`        | `String`        | 申請タイトル（30文字以内、必須）                       |
| `content`      | `String`        | 申請内容（必須）                                |
| `status`       | `String`        | 申請のステータス（PENDING / APPROVED / REJECTED） |
| `responseNote` | `String`        | 管理者からの返信メモ                              |
| `requestedAt`  | `LocalDateTime` | 申請日時                                    |

### Team

| フィールド       | 型        | 説明               |
| ----------- | -------- | ---------------- |
| `id`        | `String` | チームID（ログインID、必須） |
| `roomId`    | `String` | チームが所属する場所のID    |
| `loginPass` | `String` | ログインパスワード（必須）    |
| `name`      | `String` | チーム名             |

## 🛡️ filter パッケージ詳細
###  AuthFilter
- 管理者・チームユーザーの認証チェックを行うフィルター

| メソッド       | 説明                            |
| ---------- | ----------------------------- |
| `doFilter` | 管理者・社員を判別し、未認証時にログイン画面へリダイレクト |


## 🗺️　mapper パッケージ詳細
### 共通アノテーション 
- @Mapper (MyBatisのMapperインターフェースとしてSpringに認識させる)

### AdminMapper

| メソッド              | 戻り値     | 引数               | 説明          |
| ----------------- | ------- | ---------------- | ----------- |
| `selectByLoginId` | `Admin` | `String loginId` | 管理者ログイン情報取得 |

### ItemMapper

| メソッド                      | 戻り値          | 引数                                  | 説明          |
| ------------------------- | ------------ | ----------------------------------- | ----------- |
| `selectAll`               | `List<Item>` | `なし`                                | 全資材取得       |
| `selectByRoomId`          | `List<Item>` | `String roomId`                     | 部屋指定で資材取得   |
| `selectByCategoryId`      | `List<Item>` | `Integer categoryId`                | カテゴリ指定で資材取得 |
| `selectByRoomAndCategory` | `List<Item>` | `String roomId, Integer categoryId` | 両条件で資材取得    |
| `selectById`              | `Item`       | `Integer id`                        | ID指定で資材取得   |
| `insert`                  | `void`       | `Item item`                         | 資材登録        |
| `update`                  | `void`       | `Item item`                         | 資材更新        |
| `deleteById`              | `void`       | `Integer id`                        | 資材削除        |

### PlacementMapper

| メソッド             | 戻り値               | 引数                    | 説明            |
| ---------------- | ----------------- | --------------------- | ------------- |
| `selectByItemId` | `List<Placement>` | `Integer itemId`      | 資材IDに対応する配置取得 |
| `insert`         | `void`            | `Placement placement` | 配置情報登録        |
| `deleteByItemId` | `void`            | `Integer itemId`      | 配置情報削除        |

### RequestMapper

| メソッド                | 戻り値             | 引数                | 説明              |
| ------------------- | --------------- | ----------------- | --------------- |
| `insert`            | `void`          | `Request request` | 新しい申請を登録        |
| `selectAll`         | `List<Request>` | なし                | 全申請を取得（管理者用）    |
| `selectByTeamId`    | `List<Request>` | `String teamId`   | チームごとの申請を取得     |
| `selectById`        | `Request`       | `int id`          | ID指定で申請を1件取得    |
| `updateStatus`      | `void`          | `Request request` | ステータス・返信コメントを更新 |
| `deleteRequestById` | `void`          | `int id`          | ID指定で申請を削除      |

### RoomMapper

| メソッド        | 戻り値          | 引数   | 説明    |
| ----------- | ------------ | ---- | ----- |
| `selectAll` | `List<Room>` | `なし` | 全部屋取得 |

### TeamMapper

| メソッド             | 戻り値    | 引数          | 説明            |
| ---------------- | ------ | ----------- | ------------- |
| `selectByTeamId` | `Team` | `String id` | IDを元にチーム情報を取得 |


## 🛠️ service パッケージ詳細
### 共通アノテーション
- @Service (ビジネスロジックを実装するサービスクラスとしてSpringに認識させる)
- @Transactional (メソッド内の処理を一括してトランザクション管理する)
- @RequiredArgsConstructor (finalフィールドに対する引数を持つコンストラクタを自動生成)

### AdminService
- 管理者のログイン認証を行うサービス
- 主な機能：ログイン情報の検証、認証成功時にセッションへ情報格納

| メソッド    | 戻り値       | 引数                                                      | 説明      |
| ------- | --------- | ------------------------------------------------------- | ------- |
| `login` | `boolean` | `String loginId, String loginPass, HttpSession session` | 管理者認証処理 |

### ItemService
- 資材（Item）の取得、登録、更新、削除を扱うサービス
- 主な機能：資材情報の管理全般、ページ制御、検索、分類表示

| メソッド                             | 戻り値          | 引数                               | 説明                        |
| -------------------------------- | ------------ | -------------------------------- | ------------------------- |
| `getAll`                         | `List<Item>` | なし                               | 全資材を取得                    |
| `getOneById`                     | `Item`       | `int id`                         | 資材IDで資材情報を1件取得            |
| `getByRoomId`                    | `List<Item>` | `String roomId`                  | 部屋IDで資材リストを取得             |
| `getByPage`                      | `List<Item>` | `int page`                       | ページ番号で資材リストを取得            |
| `getByRoomIdAndPage`             | `List<Item>` | `String roomId, int page`        | 部屋IDとページ番号で資材リストを取得       |
| `setNumPerPage`                  | `void`       | `int numPerPage`                 | 1ページあたりの表示件数を設定           |
| `getNumPerPage`                  | `int`        | なし                               | 1ページあたりの表示件数を取得           |
| `getTotalPages`                  | `int`        | なし                               | 全資材の総ページ数を取得              |
| `getTotlaPagesByRoomId`          | `int`        | `String roomId`                  | 部屋IDで絞り込んだ資材の総ページ数を取得     |
| `deleteById`                     | `void`       | `int id`                         | 資材IDで資材を削除                |
| `add`                            | `void`       | `Item item`                      | 資材を登録し、倉庫に配置              |
| `edit`                           | `void`       | `Item item`                      | 資材および配置情報を更新（数量が0なら配置削除）  |
| `getOneByIdToEdit`               | `Item`       | `int id`                         | 編集用に資材情報（配置情報含む）を取得       |
| `getByCategoryAndRoom`           | `List<Item>` | `String category, String roomId` | カテゴリと部屋IDで資材リストを取得        |
| `getTotlaPagesByCategoryAndRoom` | `int`        | `String category, String roomId` | カテゴリと部屋IDに該当する資材の総ページ数を取得 |
| `getByCategory`                  | `List<Item>` | `String category, Integer page`  | カテゴリ指定＋ページ番号で資材リストを取得     |
| `getTotalPagesByCategory`        | `int`        | `String category`                | カテゴリ指定で資材の総ページ数を取得        |

### RequestService
- 申請（Request）の新規登録・取得・ステータス更新・削除を行うサービス
- 主な機能：チーム別・全体の申請表示、承認処理、削除処理

| メソッド                | 戻り値             | 引数                | 説明              |
| ------------------- | --------------- | ----------------- | --------------- |
| `create`            | `void`          | `Request request` | 新しい申請を追加        |
| `getAll`            | `List<Request>` | なし                | 全申請を取得（管理者用）    |
| `getByTeamId`       | `List<Request>` | `String teamId`   | チームごとの申請を取得     |
| `getById`           | `Request`       | `int id`          | ID指定で申請を1件取得    |
| `updateStatus`      | `void`          | `Request request` | ステータスと返信コメントを更新 |
| `deleteRequestById` | `void`          | `int id`          | ID指定で申請を削除      |


### RoomService
- 部屋情報（Room）の取得を行うサービス
- 主な機能：部屋の一覧取得、IDから部屋名を取得

| メソッド          | 戻り値          | 引数              | 説明                   |
| ------------- | ------------ | --------------- | -------------------- |
| `getAll`      | `List<Room>` | `なし`            | 全ての部屋情報を取得           |
| `getNameById` | `String`     | `String roomId` | 指定された部屋IDに対応する部屋名を取得 |

### TeamService
- チームのログイン認証を行うサービス
- 主な機能：ID・パスワードの検証、認証成功時のセッション設定

| メソッド    | 戻り値       | 引数                                                     | 説明                                        |
| ------- | --------- | ------------------------------------------------------ | ----------------------------------------- |
| `login` | `boolean` | `String id`, `String loginPass`, `HttpSession session` | IDとパスワードが正しいかを判定し、成功時はセッションにチーム名を格納、結果を返す |

## データベース情報

| No | データベース名        | 文字コード     | 照合順序                 |
| -- | -------------- | --------- | -------------------- |
| 1  | `materials_db` | `utf8mb4` | `utf8mb4_general_ci` |

##　📚 テーブル一覧

| No | テーブル名              | 内容             | データベースNo |
| -- | ------------------ | -------------- | -------- |
| 1  | `admins`           | 管理者のログイン情報     | 1        |
| 2  | `departments`      | 社員(ライン)のログイン情報 | 1        |
| 3  | `items`            | 資材情報           | 1        |
| 4  | `rooms`            | 場所情報           | 1        |
| 5  | `placements`       | 配置場所と数量の情報     | 1        |
| 6  | `department_rooms` | ラインごとの資材場所情報   | 1        |

### テーブル定義：admins
| カラム名         | 型             | オプション   | 内容              |
| ------------ | ------------- | ------- | --------------- |
| `login_id`   | `VARCHAR(10)` | プライマリキー | ログインID          |
| `login_pass` | `CHAR(60)`    | 必須      | パスワード（`BCrypt`） |
| `name`       | `VARCHAR(30)` | 必須      | 表示用の名前          |

### テーブル定義：departments
| カラム名      | 型             | オプション   | 内容              |
| --------- | ------------- | ------- | --------------- |
| `id`      | `VARCHAR(10)` | プライマリキー | ログインID          |
| `line_id` | `CHAR(6)`     | ユニーク、必須 | パスワード（`BCrypt`） |
| `name`    | `VARCHAR(30)` | 必須      | 表示用の名前          |

### テーブル定義：items
| カラム名           | 型              | オプション    | 内容     |
| -------------- | -------------- | -------- | ------ |
| `id`           | `INT`          | 主キー、自動連番 | 資材ID   |
| `name`         | `VARCHAR(30)`  | 必須       | 資材品名   |
| `purchased_at` | `DATE`         | 必須       | 資材の購入日 |
| `note`         | `VARCHAR(255)` |          | 備考     |

### テーブル定義：rooms
| カラム名   | 型             | オプション   | 内容    |
| ------ | ------------- | ------- | ----- |
| `id`   | `CHAR(4)`     | プライマリキー | 場所ID  |
| `name` | `VARCHAR(30)` | 必須      | 場所の名前 |

### テーブル定義：placements
| カラム名      | 型             | オプション   | 内容                  |
| --------- | ------------- | ------- | ------------------- |
| `item_id` | `INT`         | プライマリキー | 資材ID                |
| `room_id` | `VARCHAR(30)` | プライマリキー | 場所ID                |
| `amount`  | `DATE`        | 必須      | 数量（※型に誤りがあるかもしれません） |

### テーブル定義：department_rooms
| カラム名            | 型         | オプション | 内容      |
| --------------- | --------- | ----- | ------- |
| `department_id` | `INT`     |       | 所属ラインID |
| `room_id`       | `CHAR(4)` |       | 場所ID    |

### テーブル定義：requests

| カラム名            | 型             | オプション                      | 内容                                   |
| --------------- | ------------- | -------------------------- | ------------------------------------ |
| `id`            | `INT`         | プライマリキー / AUTO\_INCREMENT  | 申請ID（自動採番）                           |
| `team_id`       | `CHAR(4)`     | NOT NULL / 外部キー            | 申請したチームのID（`teams.id`と紐づく）           |
| `title`         | `VARCHAR(30)` | NOT NULL                   | 申請タイトル                               |
| `content`       | `TEXT`        | NOT NULL                   | 申請内容                                 |
| `status`        | `VARCHAR(10)` | DEFAULT 'PENDING'          | 申請の状態（PENDING / APPROVED / REJECTED） |
| `response_note` | `TEXT`        | NULL 可                     | 管理者からの返信コメント                         |
| `requested_at`  | `DATETIME`    | DEFAULT CURRENT\_TIMESTAMP | 申請日時                                 |

