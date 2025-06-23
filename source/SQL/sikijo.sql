/*画像のパス追加済み（藤原　6/22）*/
/*すでにMySQLに登録してしまった方はDrop table planner;でテーブルごと削除後、変更後の↓を全文入れなおした方が早いと思います！*/
create table sikijo (
 sikijo_id int (30) primary key auto_increment,
 jm_number varchar (30) not null,
 name varchar (30) not null,
 address varchar (30) not null,
 image varchar (50),
 sikijo_price varchar (30)
);

INSERT INTO sikijo VALUES
  (NULL, '洋', 'アンジェリーナ・ジョリーン', '東京都渋谷区渋谷1丁目4番1号','siki_angelina.png','48'),
  (NULL, '和洋', 'トム・クルージョン', '東京都新宿区新宿6丁目8番','siki_tom.png','55'),
  (NULL, '洋', 'クリムゾン・ドッピオ', '東京都豊島区南池袋2丁目26番3号','siki_crimson.png','38'),
  (NULL, '和', 'D４C館', '東京都品川区北品川3丁目4番7号','siki_D4c.png','12'),
  (NULL, '和洋', 'ドウェイン・ブラザー', '東京都台東区上野3丁目5番12号','siki_dowein.png','52'),
  (NULL, '洋', 'テイラー２２', '東京都武蔵野市吉祥寺本町2丁目20番6号','siki_taylor.png','41'),
  (NULL, '和洋', 'エマ・ワトシン', '東京都立川市曙町3丁目15番5号','siki_ema.png','29');