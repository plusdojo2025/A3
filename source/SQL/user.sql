create table user (
 user_id int  primary key auto_increment,
 id varchar (50) not null,
 pw varchar (50) not null,
 f_name varchar (20) not null,
 l_name varchar (20) not null,
 k_f_name varchar (15) not null,
 k_l_name varchar (15) not null,
 birthday varchar (11),
 gender varchar (2),
 zipcode varchar (8),
 address varchar (100),
 email varchar (254),
 phone varchar (15)
);