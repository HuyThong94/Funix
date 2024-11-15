-- Yeu cau 1
create database company;
use company;
create table department(
 id int primary key,
 name varchar(100)
);

create table employee(
id int primary key,
name varchar(100),
dep_id int,
foreign key (dep_id) references department(id)
); 

-- Yeu cau 2
insert into department(id, name) value(1, 'Phong ban A'), (2, 'Phong ban B'), (3, 'Phong ban C');
insert into employee(id, name, dep_id) values(1, 'Nguyen Van A', 1), (2, 'Nguyen Van B', 1), (3, 'Nguyen Van C', 2);

select * from department;
select * from employee;

-- Yeu cau 3
delete from department where id = 1;
delete from department where id = 2;
update department set name='Phong ban A1' where id = 1;
delete from employee where id = 3;
delete from department where id = 2;