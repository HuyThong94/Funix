use cat_app;
create table people(
first_name varchar(20),
last_name varchar(20),
age int
);
insert into people(first_name, last_name, age)values('Tina', 'Belcher', 13),('Bob', 'Belcher', 42),('Linda', 'Belcher', 45),('Phillip', 'Frond', 38),('Calvin', 'Fischoeder', 70);
select* from people;
drop table people;
show tables;