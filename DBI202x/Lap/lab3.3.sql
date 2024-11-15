use cat_app;

-- Yêu cầu 1:
create table cats(
cat_id int not null auto_increment primary key,
name varchar(100),
breed varchar(100),
age int
);

-- Yêu cầu 2:
insert into cats(name, breed, age) values ('Ringo', 'Tabby', 4),
('Cindy', 'Maine Coon', 10),
('Dumbledore', 'Maine Coon', 11),
('Egg', 'Persian', 4),
('Misty', 'Persian', 4),
('George Michael', 'Ragdoll', 9),
('Jackson', 'Sphynx', 7);

-- Yêu cầu 3:
-- 3.1
select cat_id from cats;
-- 3.2
select name, breed from cats;
-- 3.3
select name, age from cats;

-- Yêu cầu 4: 
-- 4.1
select cat_id as id from cats;
-- 4.2
select name as car_name, breed as kitty_breed from cats;