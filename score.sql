drop database if exists score;

create database score;
use score

create table course
(
  course_id int unsigned not null auto_increment primary key,
  course_name varchar(20) not null,
  user_id int unsigned not null,
  constraint foreign key(user_id) references user(user_id) on delete cascade on update cascade
);

create table score
(
  value int unsigned,
  user_id int unsigned not null,
  course_id int unsigned not null
);


create table user
(
  user_id int unsigned not null auto_increment primary key,
  user_name varchar(10) not null,
  password varchar(20) not null,
  role enum("student", "teacher") not null
);

alter table score add foreign key(user_id) references user(user_id) on delete cascade on update cascade;
alter table score add foreign key(course_id) references course(course_id) on delete cascade on update cascade;

insert user(user_name, password, role) values("teacher1", "11111", "teacher");
insert user(user_name, password, role) values("student1", "11111", "student");
insert course(course_name, user_id) values("Maths", "1");
insert score(value, user_id, course_id) values("82", "2", "1");
insert course(course_name, user_id) values("English", "1");
insert score(value, user_id, course_id) values("60", "2", "2");

drop view if exists course_score;

create view course_score
as
select course_name, value, score.user_id
from course join score on course.course_id = score.course_id;

drop view if exists student_score;

create view student_score
as
select user_name, value, course_id
from score join user on score.user_id = user.user_id;