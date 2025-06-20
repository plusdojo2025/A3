0create table options (
 option_id int primary key auto_increment,
 option_name VARCHAR (30) not null,
 option_price varchar (30)
);

INSERT INTO options VALUES
(null, 'マグロ入刀', '130'),
(null, '鏡開き', '6'),
(null, '鏡抜き', '9'),
(null, 'シャンパンタワー', '20'),
(null, 'ピニャータ', '2'),
(null, '巨大ハンバーガー入刀', '7'),
(null, '打ち上げ花火', '25'),
(null, 'かぼちゃ割り', '6.5'),
(null, '寿司ケーキ', '6');

/*
UPDATE options SET option_name = '' WHERE option_id=1;
UPDATE options SET option_name = '' WHERE option_id=2;
UPDATE options SET option_name = '' WHERE option_id=3;
UPDATE options SET option_name = '' WHERE option_id=4;
UPDATE options SET option_name = '' WHERE option_id=5;
UPDATE options SET option_name = '' WHERE option_id=6;
UPDATE options SET option_name = '' WHERE option_id=7;
UPDATE options SET option_name = '' WHERE option_id=8;
UPDATE options SET option_name = '' WHERE option_id=9;
*/