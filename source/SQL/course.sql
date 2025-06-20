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
  (NULL, 'A', '和', '和装レンタル、和風装花など、日本の文化や伝統や、和の要素を取り入れた和婚式スタイル', '1', '2', '3','1,800,000'),
  (NULL, 'B', '洋', '白を基調とした厳かな挙式、バージンロードの入場、会場などロマンチックな雰囲気', '4', '5', '6','2,100,000'),
  (NULL, 'C', '和洋', '和の伝統美と洋の華やかさが調和し、どちらも楽しめる和洋折衷ウェディング', '7', '8', '9','2,700,000');
