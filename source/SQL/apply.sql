CREATE TABLE apply (
  apply_id   INT PRIMARY KEY AUTO_INCREMENT,
  user_id    INT NOT NULL,
  planner_id INT NOT NULL,
  sikijo_id  INT NOT NULL,
  course_id  INT NOT NULL,
  FOREIGN KEY (`user_id`)    REFERENCES `user`(`user_id`),
  FOREIGN KEY (`planner_id`) REFERENCES `planner`(`planner_id`),
  FOREIGN KEY (`sikijo_id`)  REFERENCES `sikijo`(`sikijo_id`),
  FOREIGN KEY (`course_id`)  REFERENCES `course`(`course_id`)
);
insert into apply (apply_id,user_id,planner_id,sikijo_id,course_id) value
()
