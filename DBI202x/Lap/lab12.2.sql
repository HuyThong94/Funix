use online_shop;

-- B1
start transaction;
insert into categories set name = 'name A';
select * from categories;

-- B2
savepoint test1;

-- B3
update categories set name = 'name B' where id = 1;
select * from categories;

-- B4
rollback to test1;
select * from categories;

-- Khi thực hiện câu truy vấn ở b3, do chưa dùng câu truy vấn savepoint nên khi dùng câu truy vấn rollback ở b4 thì câu truy vấn ở b3 sẽ bị quay lạitrạng thái đã lưu bởi saveponit.
