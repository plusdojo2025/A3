create table course (
 course_id int  primary key auto_increment,
 course_name VARCHAR (5) not null,
 jm_number VARCHAR (5) not null,
 comment VARCHAR(150) not null,
 option1 VARCHAR (20) not null,
 option2 VARCHAR (20) not null,
 option3 VARCHAR (20) not null
);

insert into course values(null,'A','和','和装レンタル、和風装花など、日本の文化や伝統や、
和の要素を取り入れた和婚式スタイル',1,2,3);