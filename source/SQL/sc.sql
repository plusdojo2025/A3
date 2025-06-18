/*1つの式場に複数のコースがあることに気が付きました（6/17藤原）
↓エラーになる
create table sc (
 sc_id int  primary key auto_increment,
 sikijo_id int (30) not null,
 course_id int (30) not null
);

insert into sc value 
(null,'1','2'),
(null,'2','1,2,3'),
(null,'3','2'),
(null,'4','1'),
(null,'5','1,2,3'),
(null,'6','2'),
(null,'7','1,2,3');
*/

/*複数値をリレーションテーブルで処理できる*/
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