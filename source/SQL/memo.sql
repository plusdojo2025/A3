create table sc (
 memo_id int  primary key auto_increment,
 memo varchar(500),
 user_id int (30) not null,
 planner_id int (30) not null
);