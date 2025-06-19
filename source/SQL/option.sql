0create table options (
 option_id int primary key auto_increment,
 option_name VARCHAR (30) not null,
 option_price varchar (30)
);

INSERT INTO options VALUES
(null, 'tunaCut', '130'),
(null, 'omochiBreak', '6'),
(null, 'osakeBreak', '9'),
(null, 'champagne', '20'),
(null, 'pinata', '2'),
(null, 'hamburgerCut', '7'),
(null, 'sushiCake', '25'),
(null, 'fireWork', '6.5'),
(null, 'pumpkin', '6');

UPDATE options SET option_name = 'マグロ入刀' WHERE option_id=1;
UPDATE options SET option_name = '鏡開き' WHERE option_id=2;
UPDATE options SET option_name = '鏡抜き' WHERE option_id=3;
UPDATE options SET option_name = 'シャンパンタワー' WHERE option_id=4;
UPDATE options SET option_name = 'ピニャータ' WHERE option_id=5;
UPDATE options SET option_name = '巨大ハンバーガー入刀' WHERE option_id=6;
UPDATE options SET option_name = '打ち上げ花火' WHERE option_id=7;
UPDATE options SET option_name = 'かぼちゃ割り' WHERE option_id=8;
UPDATE options SET option_name = '寿司ケーキ' WHERE option_id=9;