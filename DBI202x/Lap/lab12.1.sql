-- Yeu cau 1
select @session.tx_tsolation;

-- Yeu cau 2
-- B2: user1
use online_shop;
set transaction isolation level read uncommitted;
start transaction;
select * from customers;
-- B3: user2
use online_shop;
update customers set name = 'name C' where id = 2;
-- B4: user1
select * from customers;
-- user1 có thể nhin thấy được cập nhật ở b3 do user2 sử dụng read uncommitted, 

-- Yeu cau 3
-- B1: user1
use online_shop;
set transaction isolation level read committed;
start transaction;
insert into customers(name, email) values('name D', 'A@gmail.com');
select * from customers;

-- Câu insert đã thực hiện thành công;

-- B2: user2
use online_shop;
select * from customers;
-- user2 không thể nhìn thấy dữ liệu vừa cập nhật của user1 do user1 sử dụng read committed.
-- B3:  user1
commit; 
-- B4: user2
use online_shop;
select * from customers;
-- user 2 có thể nhìn thấy dự liệu vừa cập nhật

-- Yeu cau 4
-- B1: user1
use online_shop;
set transaction isolation level repeatable read;
start transaction;
update customers set name='name E' where id = 1;
select * from customers;
-- B2: user2
use online_shop;
update customers set name='name F' where id = 1;
-- B3: user1
commit; 
select * from customers;

-- Yeu cau 5
-- b1: user1
use online_shop;
set transaction isolation level serializable;
start transaction;
select * from customers;
-- b2: user2
use online_shop;
insert into customers(name, email) values('name A', 'A@gmail.com');
select * from customers;
-- b3: user1
select * from customers;
-- b4: user1
commit;
select * from customers;
-- ở b3, sau khi user2 insert thì truy vấn sẽ bị hoãn, cho đến khi user1 commit thì mới tiếp tục truy vấn và thực hiện 

-- Yeu cau 6
-- B1: user1
use online_shop;
set transaction isolation level serializable;
start transaction;
select * from customers;
-- B2: user2
update customers set name = 'name B' where id = 1;
-- B3: user1
commit;
select * from customers;  



