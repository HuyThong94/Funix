
-- Yêu cầu 1:
create database shirts_db;
use shirts_db;

-- Yêu cầu 2:
create table shirts(
shirt_id int not null auto_increment primary key,
article varchar(100),
color varchar(100),
shirt_size varchar(100),
last_worn int
);

-- Yêu cầu 3:
insert into shirts(article,color,shirt_size,last_worn ) values 
('t-shirt', 'white', 'S', 10),
('t-shirt', 'green', 'S', 200),
('polo shirt', 'black', 'M', 10),
('tank top', 'blue', 'S', 50),
('t-shirt', 'pink', 'S', 0),
('polo shirt', 'red', 'M', 5),
('tank top', 'white', 'S', 200),
('tank top', 'blue', 'M', 15);

-- Yêu cầu 4:
select * from shirts; 

-- Yêu cầu 5:
show tables;
insert into shirts(article, shirt_size, last_worn ) values ('polo shirt','M',50);

-- Yêu cầu 6:
select article, color from shirts; 

-- Yêu cầu 7:
select article, color, shirt_size, last_worn from shirts where shirt_size='M'; 

-- Yêu cầu 8:
update shirts set shirt_size="L" where article="polo shirt";

-- Yêu cầu 9:
delete from shirts where last_worn =200;