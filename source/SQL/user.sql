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
  'user22',
  'pass22',
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
  'user23',
  'pass23',
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
  'user24',
  'pass24',
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