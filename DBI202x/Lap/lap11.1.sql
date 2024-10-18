-- Yeu cau 1
CREATE USER user1@localhost IDENTIFIED BY '1';
CREATE USER user2@localhost IDENTIFIED BY '1';
GRANT ALL PRIVILEGES ON *.* TO user1@localhost WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO user2@localhost WITH GRANT OPTION;

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

-- user2
use lab;
select * from student;

-- user2
use lab;
insert into student(name) values('name D');

use lab;
unlock table;

use lab;
select * from student;
-- Nếu sử dụng lock write thì chỉ user1 có thể insert, select vào bảng bị lock
-- Yeu cau 5
use lab;
lock tables student read;

use lab;
select * from student;

use lab;
insert into student(name) values('name E');

-- user2
use lab;
select * from student;

-- user2
use lab;
insert into student(name) values('name F');

use lab;
unlock table;

use lab;
select * from student;
-- Nếu sử dụng lock read thì user1 chỉ có thể select bảng chứ k thể insert, user2 thì insert sẽ chờ đến khi bảng được mở mới truy vấn được

