create table planner (
 planner_id int  primary key auto_increment,
 id varchar (20) not null,
 password varchar (20) not null,
 name varchar (40) not null,
 gender varchar (2),
 phone varchar (11),
 siki_add varchar (100),
 strong_fild varchar (200)
);