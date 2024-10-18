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

-- Yeu cau 3
-- B1: user1
use online_shop;
set transaction isolation level read committed;
start transaction;
insert into customers(name, email) values('name D', 'A@gmail.com');
select * from customers;
-- B2: user2
use online_shop;
select * from ccustomersustomers;
-- B3:  user1
commit; 

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




