-- Yeu cau 3
create database lab;
use lab;
create table student(
id int primary key auto_increment,
name varchar(100)
);
insert into student(name) values('name A'),('name B');

-- Yeu cau 4
use lab;
lock tables student write;

use lab;
select * from student;

use lab;
insert into student(name) values('name C');

use lab;
select * from student;

-- user2
use lab;
insert into student(name) values('name D');

use lab;
unlock table;

use lab;
select * from student;
drop database lab
