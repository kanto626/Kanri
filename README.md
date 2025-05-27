# Kanri 副資材管理システム（Spring Boot）
このプロジェクトは、Spring Bootを使用した資材管理システムです
生産工場において、作業員および管理者が副資材の在庫情報を管理できるシステムとなります

## 作業員向け機能 (FS)

・配置場所やカテゴリーから副資材リストの確認ができる

・新規資材の申請や補充申請が可能

## 管理者向け機能 (FA)

・副資材の追加・編集・削除が可能

・作業員からの申請内容の確認が可能


## 管理者向け機能一覧

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
| FA04-1 | 資材リストのページ分割 | 1ページ10件表示、ページ番号で移動可能 |

## 社員(作業員)向け機能一覧

### FS01 ユーザー認証機能

| 機能ID   | 機能名    | 説明                             |
| ------ | ------ | ------------------------------ |
| FS01-1 | ユーザー認証 | セッションに部署IDがあるか確認。不在時はログイン画面に遷移 |
| FS01-2 | ログイン   | ID/パスワード確認後、生徒IDをセッションに格納      |
| FS01-3 | ログアウト  | セッションの部署IDを破棄                  |

### FS02 資材検索機能

| 機能ID   | 機能名       | 説明             |
| ------ | --------- | -------------- |
| FS02-1 | 資材一覧      | 全資材を一覧表示       |
| FS02-2 | 場所ごとの絞り込み | roomIdで資材を絞り込む |

### FS03 資材詳細閲覧機能

| 機能ID   | 機能名    | 説明                      |
| ------ | ------ | ----------------------- |
| FS03-1 | 資材詳細表示 | 選択した資材の詳細（名称、購入日、備考）を表示 |

### FS04 ページ分割機能

| 機能ID   | 機能名         | 説明                   |
| ------ | ----------- | -------------------- |
| FS04-1 | 資材リストのページ分割 | 1ページ10件表示、ページ番号で移動可能 |

## 📁 プロジェクト構成 (一部)

```
Kanri/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/app/
│       │       ├── config/             # アプリ全体の設定クラス（認証、バリデーション設定など）
│       │       ├── controller/         # HTTPリクエスト処理（画面とやりとり）
│       │       ├── domain/             # ドメインモデル（エンティティ）
│       │       ├── filter/             # リクエストの前処理・後処理用フィルター
│       │       ├── mapper/             # MyBatis用Mapperインターフェース
│       │       ├── service/            # ビジネスロジックを担当
│       │       └── KanriApplication.java # アプリ起動クラス（mainメソッド）
│       └── resources/
│           ├── mybatis/               # Mapper XMLファイル（SQL記述）
│           ├── static/                # 静的リソース（CSS, JS, 画像など）
│           ├── templates/             # HTMLテンプレート（Thymeleafなど）
│           ├── application.properties # アプリケーション設定
│           └── validation.properties  # バリデーションエラーメッセージ定義
├── pom.xml                            # Mavenビルド設定・依存ライブラリ
```


## パッケージ構成（`com.example.app`）

### config パッケージ

* `ValidationConfig.java`：入力バリデーション設定
* `FilterConfig.java`：認証フィルター設定

### controller パッケージ


* `AdminController.java`：管理者向けページのリクエスト処理（登録・編集・削除）
* `AdminRequestController.java`：管理者向け申請ページのリクエスト処理
* `LoginController.java`：管理者のログイン・ログアウト処理
* `StaffController.java`：作業員向けページのリクエストを処理
* `TeamLoginController.java`：チーム(作業員)のログイン・ログアウト処理
* `TeamRequestController.java`：チーム(作業員)向け申請ページのリクエスト処理

### domain パッケージ

* `Admin.java`：管理者データクラス
* `Item.java`：資材データクラス
* `Placement.java`：配置データクラス
* `Requset.java`：申請データクラス
* `Room.java`：部屋データクラス
* `Team.java`：チームデータクラス

### filter パッケージ

* `AuthFilter.java`：ユーザー認証用フィルター

### mapper パッケージ

* `AdminMapper.java`：adminsテーブル操作
* `ItemMapper.java`：itemsテーブル操作
* `PlacementMapper.java`：placementsテーブル操作
* `RequestMapper.java`：requestsテーブル操作
* `RoomMapper.java`：roomsテーブル操作
* `TeamMapper.java`：teamsテーブル操作

### service パッケージ

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

## controller メソッド詳細

### AdminController

| メソッド        | 戻り値    | 引数                                     | 説明                |
| ----------- | ------ | -------------------------------------- | ----------------- |
| index       | String | RequestParam Integer page, Model model | 管理者用資材一覧表示（ページ分割） |
| add (GET)   | String | Model model                            | 資材登録フォーム表示        |
| add (POST)  | String | Item item, Errors errors, Model model  | 資材登録処理            |
| edit (GET)  | String | Integer id, Model model                | 資材編集フォーム表示        |
| edit (POST) | String | Item item, Errors errors, Model model  | 資材編集処理            |
| delete      | void   | Integer id                             | 資材削除処理            |

### AdminRequestController

| メソッド          | 戻り値    | 引数                                                                                             | 説明                     |
| ------------- | ------ | ---------------------------------------------------------------------------------------------- | ---------------------- |
| index         | String | Model model                                                                                    | 申請一覧表示（管理者画面）          |
| edit (GET)    | String | @RequestParam("id") int id, Model model                                                        | 申請詳細画面の表示（承認または却下フォーム） |
| edit (POST)   | String | @ModelAttribute Request request                                                                | 申請ステータス更新（承認または却下の処理）  |
| deleteRequest | String | @RequestParam(name = "id", required = false) Integer id, RedirectAttributes redirectAttributes | 申請の削除処理と結果メッセージ設定      |


### LoginController

| メソッド         | 戻り値    | 引数                                              | 説明        |
| ------------ | ------ | ----------------------------------------------- | --------- |
| login (GET)  | String | Model model                                     | ログインページ表示 |
| login (POST) | String | Admin admin, Errors errors, HttpSession session | ログイン処理    |
| logout       | void   |なし（HttpSessionはフィールドとして使用）                             | ログアウト処理   |

### StaffController

| メソッド  | 戻り値    | 引数                                             | 説明                   |
| ----- | ------ | ---------------------------------------------- | -------------------- |
| index | String | String roomId, Integer categoryId, Model model | 資材リスト表示。部屋/カテゴリで絞り込み |
| show  | String | Integer id, Model model                        | 資材詳細表示               |


### TeamLoginController

| メソッド         | 戻り値    | 引数                              | 説明                  |
| ------------ | ------ | ------------------------------- | ------------------- |
| login (GET)  | String | Model model                     | ログインフォーム表示          |
| login (POST) | String | @Valid Team team, Errors errors | ログイン認証処理（バリデーション含む） |
| logout       | String | なし（HttpSessionはフィールドとして使用）      | ログアウト処理（セッション破棄）    |

### TeamRequestController

| メソッド     | 戻り値    | 引数                                                                      | 説明                 |
| -------- | ------ | ----------------------------------------------------------------------- | ------------------ |
| showForm | String | Model model                                                             | 申請フォームの表示          |
| submit   | String | @Valid Request request, Errors errors, HttpSession session, Model model | 申請送信処理（バリデーション・登録） |

## service メソッド詳細

### AdminService

| メソッド  | 戻り値     | 引数                                                    | 説明      |
| ----- | ------- | ----------------------------------------------------- | ------- |
| login | boolean | String loginId, String loginPass, HttpSession session | 管理者認証処理 |

### ItemService

| メソッド                 | 戻り値        | 引数                                | 説明          |
| -------------------- | ---------- | --------------------------------- | ----------- |
| getAll               | List<Item> |                                   | 全資材を取得      |
| getByRoomId          | List<Item> | String roomId                     | 部屋指定で資材取得   |
| getByCategoryId      | List<Item> | Integer categoryId                | カテゴリ指定で資材取得 |
| getByRoomAndCategory | List<Item> | String roomId, Integer categoryId | 両条件で資材取得    |
| getOneById           | Item       | Integer id                        | ID指定で資材取得   |
| add                  | void       | Item item                         | 資材登録        |
| edit                 | void       | Item item                         | 資材更新        |
| deleteById           | void       | Integer id                        | 資材削除        |

### RoomService

| メソッド        | 戻り値         | 引数            | 説明                     |
| ----------- | ----------- | ------------- | ---------------------- |
| getAll      | List\<Room> | なし            | 全ての部屋情報を取得           |
| getNameById | String      | String roomId | 指定された部屋IDに対応する部屋名を取得 |

### RequestService

| メソッド名                 | 戻り値             | 引数                | 説明                    |
| --------------------- | --------------- | ----------------- | --------------------- |
| `create()`            | `void`          | `Request request` | 新しい申請データを登録           |
| `getAll()`            | `List<Request>` | なし                | すべての申請データを取得          |
| `getByTeamId()`       | `List<Request>` | `String teamId`   | 指定されたチームIDに紐づく申請一覧を取得 |
| `getById()`           | `Request`       | `int id`          | 申請IDから1件の申請データを取得     |
| `updateStatus()`      | `void`          | `Request request` | 申請の承認/却下など、ステータスを更新   |
| `deleteRequestById()` | `void`          | `int id`          | 指定された申請IDの申請データを削除    |


## mapper メソッド詳細

### ItemMapper

| メソッド                    | 戻り値        | 引数                                | 説明          |
| ----------------------- | ---------- | --------------------------------- | ----------- |
| selectAll               | List<Item> |                                   | 全資材取得       |
| selectByRoomId          | List<Item> | String roomId                     | 部屋指定で資材取得   |
| selectByCategoryId      | List<Item> | Integer categoryId                | カテゴリ指定で資材取得 |
| selectByRoomAndCategory | List<Item> | String roomId, Integer categoryId | 両条件で資材取得    |
| selectById              | Item       | Integer id                        | ID指定で資材取得   |
| insert                  | void       | Item item                         | 資材登録        |
| update                  | void       | Item item                         | 資材更新        |
| deleteById              | void       | Integer id                        | 資材削除        |

### RoomMapper

| メソッド      | 戻り値        | 引数 | 説明    |
| --------- | ---------- | -- | ----- |
| selectAll | List<Room> |    | 全部屋取得 |

### PlacementMapper

| メソッド           | 戻り値             | 引数                  | 説明            |
| -------------- | --------------- | ------------------- | ------------- |
| selectByItemId | List<Placement> | Integer itemId      | 資材IDに対応する配置取得 |
| insert         | void            | Placement placement | 配置情報登録        |
| deleteByItemId | void            | Integer itemId      | 配置情報削除        |

### AdminMapper

| メソッド            | 戻り値   | 引数             | 説明          |
| --------------- | ----- | -------------- | ----------- |
| selectByLoginId | Admin | String loginId | 管理者ログイン情報取得 |

## domain クラス定義

### Item.java

| フィールド       | 型       | 説明   |
| ----------- | ------- | ---- |
| id          | Integer | 資材ID |
| name        | String  | 資材名  |
| purchasedAt | Date    | 購入日  |
| loginId     | String  | 備考   |
| loginPass   | Integer | 総数   |

### Room.java

| フィールド | 型      | 説明   |
| ----- | ------ | ---- |
| id    | String | 場所ID |
| name  | String | 場所名  |

### Placement.java

| フィールド  | 型       | 説明   |
| ------ | ------- | ---- |
| item   | Item    | 資材   |
| room   | Room    | 場所   |
| amount | Integer | 配置数量 |

### Admin.java

| フィールド     | 型       | 説明         |
| --------- | ------- | ---------- |
| id        | Integer | 管理者ID      |
| loginId   | String  | ログインID     |
| loginPass | String  | 暗号化済みパスワード |
| name      | String  | 管理者名       |

## 認証フィルター

### AuthFilter.java

| メソッド     | 説明                            |
| -------- | ----------------------------- |
| doFilter | 管理者・社員を判別し、未認証時にログイン画面へリダイレクト |

## データベース情報

| No | データベース名       | 文字コード   | 照合順序                 |
| -- | ------------- | ------- | -------------------- |
| 1  | materials\_db | utf8mb4 | utf8mb4\_general\_ci |

### テーブル一覧

| No | テーブル名             | 内容             | データベースNo |
| -- | ----------------- | -------------- | -------- |
| 1  | admins            | 管理者のログイン情報     | 1        |
| 2  | departments       | 社員(ライン)のログイン情報 | 1        |
| 3  | items             | 資材情報           | 1        |
| 4  | rooms             | 場所情報           | 1        |
| 5  | placements        | 配置場所と数量の情報     | 1        |
| 6  | department\_rooms | ラインごとの資材場所情報   | 1        |

### テーブル定義：admins
| カラム名        | 型           | オプション   | 内容            |
| ----------- | ----------- | ------- | ------------- |
| login\_id   | VARCHAR(10) | プライマリキー | ログインID        |
| login\_pass | CHAR(60)    | 必須      | パスワード（BCrypt） |
| name        | VARCHAR(30) | 必須      | 表示用の名前        |

### テーブル定義：departments
| カラム名     | 型           | オプション   | 内容            |
| -------- | ----------- | ------- | ------------- |
| id       | VARCHAR(10) | プライマリキー | ログインID        |
| line\_id | CHAR(6)     | ユニーク、必須 | パスワード（BCrypt） |
| name     | VARCHAR(30) | 必須      | 表示用の名前        |

### テーブル定義：items
| カラム名          | 型            | オプション    | 内容     |
| ------------- | ------------ | -------- | ------ |
| id            | INT          | 主キー、自動連番 | 資材ID   |
| name          | VARCHAR(30)  | 必須       | 資材品名   |
| purchased\_at | DATE         | 必須       | 資材の購入日 |
| note          | VARCHAR(255) |          | 備考     |

### テーブル定義：rooms
| カラム名 | 型           | オプション   | 内容    |
| ---- | ----------- | ------- | ----- |
| id   | CHAR(4)     | プライマリキー | 場所ID  |
| name | VARCHAR(30) | 必須      | 場所の名前 |

### テーブル定義：placements
| カラム名     | 型           | オプション   | 内容   |
| -------- | ----------- | ------- | ---- |
| item\_id | INT         | プライマリキー | 資材ID |
| room\_id | VARCHAR(30) | プライマリキー | 場所ID |
| amount   | DATE        | 必須      | 数量   |

### テーブル定義：department_rooms
| カラム名           | 型       | オプション | 内容      |
| -------------- | ------- | ----- | ------- |
| department\_id | INT     |       | 所属ラインID |
| room\_id       | CHAR(4) |       | 場所ID    |

