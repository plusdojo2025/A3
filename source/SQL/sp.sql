/*create table sp (
 sp_id int  primary key auto_increment,
 sikijo_id int (30) not null,
 planner_id int (20) not null
);
*/

/*複数値をリレーションテーブルで処理できる*/

 CREATE TABLE sp (
  sp_id INT AUTO_INCREMENT PRIMARY KEY,
  sikijo_id INT NOT NULL,
  planner_id INT NOT NULL
);
INSERT INTO sp (sp_id, sikijo_id, planner_id) VALUES
(NULL, 1, 1),
(NULL, 1, 2),
(NULL, 1, 3),
(NULL, 2, 4),
(NULL, 2, 5),
(NULL, 2, 6),
(NULL, 3, 7),
(NULL, 3, 8),
(NULL, 3, 9),
(NULL, 4, 10),
(NULL, 4, 11),
(NULL, 4, 12),
(NULL, 5, 13),
(NULL, 5, 14),
(NULL, 5, 15),
(NULL, 6, 16),
(NULL, 6, 17),
(NULL, 6, 18),
(NULL, 7, 19),
(NULL, 7, 20),
(NULL, 7, 21);
 