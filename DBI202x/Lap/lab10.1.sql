-- Yeu cau 1
create database online_shop;
use online_shop;
create table book(id int primary key auto_increment, name varchar(50) not null, notes varchar(100));

-- Yeu cau 2
create view bookview as select id, name from book;

-- Yeu cau 3
insert into bookview (id, name) values (2, "War and Peace");

-- Yeu cau 4
drop view bookview;

select * from book;

-- khi insert du lieu vao bookview thi se thu hien truc tiep luon ngay tren bang book nen trong bang book se co du lieu