
create table user (
 user_id int  primary key auto_increment,
 id varchar (50) not null,
 pw varchar (50) not null,
 f_name varchar (20) not null,
 l_name varchar (20) not null,
 k_f_name varchar (15) not null,
 k_l_name varchar (15) not null,
 birthday varchar (11),
 gender varchar (10),
 zipcode varchar (8),
 address varchar (100),
 email varchar (254),
 phone varchar (15)
);

INSERT INTO user VALUES (
  null,
  'dojouser12',
  '#SEplus2025SEplus',
  '小尾利',
  '爪溜',
  'コオリ',
  'ツメタメ',
  '2000-08-30',
  '女',
  '221-0045',
  '神奈川県横浜市神奈川区神奈川2丁目15-3',
  'tsumetamekoori@gmail.com',
  '045-441-0110'
  );

INSERT INTO user VALUES (
  null,
  'dojouser13',
  '#SEplus2025SEplus',
  '綿名',
  '画目',
  'メンナ',
  'ガメ',
  '1972-05-02',
  '女',
  '330-8533',
  '埼玉県さいたま市浦和区高砂3丁目15-1',
  'gamemenna@gmail.com',
  '048-832-0110'
  );

INSERT INTO user VALUES (
  null,
  'dojouser13',
  '#SEplus2025SEplus',
  '亜夢',
  '彪夢',
  'アム',
  'アム',
  '2004-05-20',
  '男',
  '730-8507',
  '広島県広島市中区基町9-42',
  'namahamuamuamu@gmail.com',
  '082-228-0110'
  );

create table planner (
 planner_id int  primary key auto_increment,
 id varchar (20) not null,
 password varchar (20) not null,
 name varchar (40) not null,
 gender varchar (2),
 phone varchar (11),
 siki_add varchar (100),
 strong_fild varchar (200),
 image varchar (50)
);

INSERT INTO planner VALUES
 (NULL, 'user01', 'pass01', '式場 涙子（しきば　るいこ）','女','0334980110','東京都渋谷区渋谷1丁目4番1号','海外風ガーデンウェディング','images/planner_1.png'),
 (NULL, 'user02', 'pass02', '誓　愛（ちかい　あい）','女','0334980110','東京都渋谷区渋谷1丁目4番1号','お色直し演出アイデア','images/planner_2.png'),
 (NULL, 'user03', 'pass03', '土橋 連（どばし　れん）','男','0334980110','東京都渋谷区渋谷1丁目4番1号','バリアフリー対応挙式提案','images/planner_3.png'),
 (NULL, 'user04', 'pass04', '姫野 麗（ひめの　れい）','女','0338470110','東京都新宿区新宿6丁目8番','少人数婚プランニング','images/planner_4.png'),
 (NULL, 'user05', 'pass05', '平野 玲央（ひらの　れお）','男','0338470110','東京都新宿区新宿6丁目8番','ペット参加ウェディング','images/planner_5.png'),
 (NULL, 'user06', 'pass06', '幸沢 幸子（さちざわ　さちこ）','女','0338470110','東京都新宿区新宿6丁目8番','ナイトウェディング演出','images/planner_6.png'),
 (NULL, 'user07', 'pass07', '布里山　権太（ふりやま　ごんた）','男','0339860110','東京都豊島区南池袋2丁目26番3号','エンタメ系披露宴演出','images/planner_7.png'),
 (NULL, 'user08', 'pass08', '倉間　ひかり（くらま　ひかり）','女','0339860110','東京都豊島区南池袋2丁目26番3号','家族婚のトータルサポート','images/planner_8.png'),
 (NULL, 'user09', 'pass09', '麺乃　片佐（めんの　かたさ）','女','0339860110','東京都豊島区南池袋2丁目26番3号','音楽演出プロデュース','images/planner_9.png'),
 (NULL, 'user10', 'pass10', '阿武　羅多芽（あぶ　らおおめ）','女','0338470110','東京都品川区北品川3丁目4番7号','和風婚の演出','images/planner_10.png'),
 (NULL, 'user11', 'pass11', '安治　鯉女（あじ　こいめ）','女','0338470110','東京都品川区北品川3丁目4番7号','和装コーディネート','images/planner_11.png'),
 (NULL, 'user12', 'pass12', 'スプリング・サクラ','女','0338470110','東京都品川区北品川3丁目4番7号','神社挙式の手配','images/planner_12.png'),
 (NULL, 'user13', 'pass13', '渦巻　螺旋（うずまき　らせん）','男','0422200110','東京都台東区上野3丁目5番12号','手作りアイテムの提案','images/planner_13.png'),
 (NULL, 'user14', 'pass14', '磯野　ひじき（いその　ひじき）','女','0422200110','東京都台東区上野3丁目5番12号','二部制パーティーの構成','images/planner_14.png'),
 (NULL, 'user15', 'pass15', '味之 幹雄　（あじの もとお）','男','0422200110','東京都台東区上野3丁目5番12号','フォトジェニック演出','images/planner_15.png'),
 (NULL, 'user16', 'pass16', '江戸川 元太（えどがわ　げんた）','男','0425270110','東京都武蔵野市吉祥寺本町2丁目20番6号','ドレス選びのアドバイス','images/planner_16.png'),
 (NULL, 'user17', 'pass17', 'エルマーレ・ポリフェノール','男','0425270110','東京都武蔵野市吉祥寺本町2丁目20番6号','おもてなし重視の進行','images/planner_17.png'),
 (NULL, 'user18', 'pass18', '御祝儀 呉子（ごしゅうぎ　くれこ）','女','0425270110','東京都武蔵野市吉祥寺本町2丁目20番6号','オリジナル誓いの言葉作成','images/planner_18.png'),
 (NULL, 'user19', 'pass19', '佐藤四五六（さとう　しごろ）','女','0334500110','東京都立川市曙町3丁目15番5号','食事重視プランニング','images/planner_19.png'),
 (NULL, 'user20', 'pass20', 'ステイSUM（すていさむ）','女','0334500110','東京都立川市曙町3丁目15番5号','サプライズ演出','images/planner_20.png'),
 (NULL, 'user21', 'pass21', 'ステイチャム','女','0334500110','東京都立川市曙町3丁目15番5号','マタニティ婚サポート','images/planner_21.png');

 -- 意図があって一度消してます。そして下のID、PWで入れています。
 delete from planner;
 
 INSERT INTO planner VALUES
 (NULL, 'dojouser1', '#SEplus2025SEplus', '式場 涙子（しきば　るいこ）','女','0334980110','東京都渋谷区渋谷1丁目4番1号','海外風ガーデンウェディング','images/planner_1.png'),
 (NULL, 'dojouser2', '#SEplus2025SEplus', '誓　愛（ちかい　あい）','女','0334980110','東京都渋谷区渋谷1丁目4番1号','お色直し演出アイデア','images/planner_2.png'),
 (NULL, 'dojouser3', '#SEplus2025SEplus', '土橋 連（どばし　れん）','男','0334980110','東京都渋谷区渋谷1丁目4番1号','バリアフリー対応挙式提案','images/planner_3.png'),
 (NULL, 'dojouser4', '#SEplus2025SEplus', '姫野 麗（ひめの　れい）','女','0338470110','東京都新宿区新宿6丁目8番','少人数婚プランニング','images/planner_4.png'),
 (NULL, 'dojouser5', '#SEplus2025SEplus', '平野 玲央（ひらの　れお）','男','0338470110','東京都新宿区新宿6丁目8番','ペット参加ウェディング','images/planner_5.png'),
 (NULL, 'dojouser6', '#SEplus2025SEplus', '幸沢 幸子（さちざわ　さちこ）','女','0338470110','東京都新宿区新宿6丁目8番','ナイトウェディング演出','images/planner_6.png'),
 (NULL, 'dojouser7', '#SEplus2025SEplus', '布里山　権太（ふりやま　ごんた）','男','0339860110','東京都豊島区南池袋2丁目26番3号','エンタメ系披露宴演出','images/planner_7.png'),
 (NULL, 'dojouser8', '#SEplus2025SEplus', '倉間　ひかり（くらま　ひかり）','女','0339860110','東京都豊島区南池袋2丁目26番3号','家族婚のトータルサポート','images/planner_8.png'),
 (NULL, 'dojouser9', '#SEplus2025SEplus', '麺乃　片佐（めんの　かたさ）','女','0339860110','東京都豊島区南池袋2丁目26番3号','音楽演出プロデュース','images/planner_9.png'),
 (NULL, 'dojouser10', '#SEplus2025SEplus', '阿武　羅多芽（あぶ　らおおめ）','女','0338470110','東京都品川区北品川3丁目4番7号','和風婚の演出','images/planner_10.png'),
 (NULL, 'dojouser11', '#SEplus2025SEplus', '安治　鯉女（あじ　こいめ）','女','0338470110','東京都品川区北品川3丁目4番7号','和装コーディネート','images/planner_11.png'),
 (NULL, 'dojouser12', '#SEplus2025SEplus', 'スプリング・サクラ','女','0338470110','東京都品川区北品川3丁目4番7号','神社挙式の手配','images/planner_12.png'),
 (NULL, 'dojouser13', '#SEplus2025SEplus', '渦巻　螺旋（うずまき　らせん）','男','0422200110','東京都台東区上野3丁目5番12号','手作りアイテムの提案','images/planner_13.png'),
 (NULL, 'dojouser14', '#SEplus2025SEplus', '磯野　ひじき（いその　ひじき）','女','0422200110','東京都台東区上野3丁目5番12号','二部制パーティーの構成','images/planner_14.png'),
 (NULL, 'dojouser15', '#SEplus2025SEplus', '味之 幹雄　（あじの もとお）','男','0422200110','東京都台東区上野3丁目5番12号','フォトジェニック演出','images/planner_15.png'),
 (NULL, 'dojouser16', '#SEplus2025SEplus', '江戸川 元太（えどがわ　げんた）','男','0425270110','東京都武蔵野市吉祥寺本町2丁目20番6号','ドレス選びのアドバイス','images/planner_16.png'),
 (NULL, 'dojouser17', '#SEplus2025SEplus', 'エルマーレ・ポリフェノール','男','0425270110','東京都武蔵野市吉祥寺本町2丁目20番6号','おもてなし重視の進行','images/planner_17.png'),
 (NULL, 'dojouser18', '#SEplus2025SEplus', '御祝儀 呉子（ごしゅうぎ　くれこ）','女','0425270110','東京都武蔵野市吉祥寺本町2丁目20番6号','オリジナル誓いの言葉作成','images/planner_18.png'),
 (NULL, 'dojouser19', '#SEplus2025SEplus', '佐藤四五六（さとう　しごろ）','女','0334500110','東京都立川市曙町3丁目15番5号','食事重視プランニング','images/planner_19.png'),
 (NULL, 'dojouser20', '#SEplus2025SEplus', 'ステイSUM（すていさむ）','女','0334500110','東京都立川市曙町3丁目15番5号','サプライズ演出','images/planner_20.png'),
 (NULL, 'dojouser21', '#SEplus2025SEplus', 'ステイチャム','女','0334500110','東京都立川市曙町3丁目15番5号','マタニティ婚サポート','images/planner_21.png');

 
 create table sikijo (
 sikijo_id int (30) primary key auto_increment,
 jm_number varchar (30) not null,
 name varchar (30) not null,
 address varchar (30) not null,
 image varchar (50),
 sikijo_price varchar (30)
);

INSERT INTO sikijo VALUES
  (NULL, '洋', 'アンジェリーナ・ジョリーン', '東京都渋谷区渋谷1丁目4番1号','siki_angelina.png','480000'),
  (NULL, '和洋', 'トム・クルージョン', '東京都新宿区新宿6丁目8番','siki_tom.png','550000'),
  (NULL, '洋', 'クリムゾン・ドッピオ', '東京都豊島区南池袋2丁目26番3号','siki_crimson.png','380000'),
  (NULL, '和', 'D４C館', '東京都品川区北品川3丁目4番7号','siki_D4c.png','120000'),
  (NULL, '和洋', 'ドウェイン・ブラザー', '東京都台東区上野3丁目5番12号','siki_dwein.png','520000'),
  (NULL, '洋', 'テイラー２２', '東京都武蔵野市吉祥寺本町2丁目20番6号','siki_taylor.jpeg','410000'),
  (NULL, '和洋', 'エマ・ワトシン', '東京都立川市曙町3丁目15番5号','siki_ema.png','290000');
 
create table course (
 course_id int  primary key auto_increment,
 course_name VARCHAR (5) not null,/*INT　から　VARCHAR　に変更しました*/
 jm_number VARCHAR (5) not null,
 comment VARCHAR(150) not null,
 option1 VARCHAR (20) not null,
 option2 VARCHAR (20) not null,
 option3 VARCHAR (20) not null,
 course_price varchar (30)
);

INSERT INTO course VALUES
  (NULL, 'A', '和', '和装レンタル、和風装花など、日本の文化や伝統や、和の要素を取り入れた和婚式スタイル', '1', '2', '3','1800000'),
  (NULL, 'B', '洋', '白を基調とした厳かな挙式、バージンロードの入場、会場などロマンチックな雰囲気', '4', '5', '6','2100000'),
  (NULL, 'C', '和洋', '和の伝統美と洋の華やかさが調和し、どちらも楽しめる和洋折衷ウェディング', '7', '8', '9','2700000');

create table options (
 option_id int primary key auto_increment,
 option_name VARCHAR (30) not null,
 option_price varchar (30)
);

INSERT INTO options VALUES
(null, 'マグロ入刀', '1300000'),
(null, '鏡開き', '60000'),
(null, '鏡抜き', '90000'),
(null, 'シャンパンタワー', '200000'),
(null, 'ピニャータ', '20000'),
(null, '巨大ハンバーガー入刀', '70000'),
(null, '打ち上げ花火', '250000'),
(null, 'かぼちゃ割り', '65000'),
(null, '寿司ケーキ', '60000');

CREATE TABLE sp (
  sp_id INT AUTO_INCREMENT PRIMARY KEY,
  sikijo_id INT NOT NULL,
  planner_id INT NOT NULL
);
INSERT INTO sp (sp_id, sikijo_id, planner_id) VALUES
(NULL, 1, 1),
(NULL, 1, 2),
(NULL, 1, 3),
(NULL, 2, 4),
(NULL, 2, 5),
(NULL, 2, 6),
(NULL, 3, 7),
(NULL, 3, 8),
(NULL, 3, 9),
(NULL, 4, 10),
(NULL, 4, 11),
(NULL, 4, 12),
(NULL, 5, 13),
(NULL, 5, 14),
(NULL, 5, 15),
(NULL, 6, 16),
(NULL, 6, 17),
(NULL, 6, 18),
(NULL, 7, 19),
(NULL, 7, 20),
(NULL, 7, 21);

CREATE TABLE sc (
  sc_id INT AUTO_INCREMENT PRIMARY KEY,
  sikijo_id INT NOT NULL,
  course_id INT NOT NULL
);
INSERT INTO sc (sc_id, sikijo_id, course_id) VALUES
(NULL, 1, 2),
(NULL, 2, 1),
(NULL, 2, 2),
(NULL, 2, 3),
(NULL, 3, 2),
(NULL, 4, 1),
(NULL, 5, 1),
(NULL, 5, 2),
(NULL, 5, 3),
(NULL, 6, 2),
(NULL, 7, 1),
(NULL, 7, 2),
(NULL, 7, 3);

CREATE TABLE apply (
  apply_id   INT PRIMARY KEY AUTO_INCREMENT,
  user_id    INT NOT NULL,
  planner_id INT NOT NULL,
  sikijo_id  INT NOT NULL,
  course_id  INT NOT NULL,
--  option_id  INT NOT NULL,
  remarks varchar(400),
  FOREIGN KEY (`user_id`)    REFERENCES `user`(`user_id`),
  FOREIGN KEY (`planner_id`) REFERENCES `planner`(`planner_id`),
  FOREIGN KEY (`sikijo_id`)  REFERENCES `sikijo`(`sikijo_id`),
  FOREIGN KEY (`course_id`)  REFERENCES `course`(`course_id`)
--  FOREIGN KEY (`option_id`)  REFERENCES `options`(`option_id`)
);

CREATE TABLE AO (
  apply_id  INT NOT NULL,
  option_id INT NOT NULL,
  PRIMARY KEY (apply_id, option_id),
  FOREIGN KEY (option_id) REFERENCES options(option_id)
);


CREATE TABLE chat (
    chat_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id_speaker VARCHAR(255) NOT NULL,
    user_id_listener VARCHAR(255) NOT NULL,
    talk VARCHAR(500),
    image VARCHAR(100),
    `check` INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table memo (
 memo_id int  primary key auto_increment,
 memo varchar(500),
 user_id int (30) not null,
 planner_id int (30) not null
);
