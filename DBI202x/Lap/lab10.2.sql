
-- Yeu cau 1
create table categories (id int primary key auto_increment, name varchar(50) not null);
insert into categories (name) values ('Books'), ('Films'), ('Music');
	
create table products (id int primary key auto_increment, 
	name varchar(100) not null, price decimal(7, 2) not null, category_id int not null, 
	quantity_available int default 0,
	foreign key (category_id) references categories(id));
	
insert into products (name, price, category_id, quantity_available) values
('The 39 Steps', 2.99, 1, 200),
('The Exorcist', 6.99, 1, 100),
('The Man Who Mistook His Wife for a Hat', 7.99, 1, 200),
('Withnail and I', 8.99, 2, 400),
('Before Sunrise', 8.99, 2, 300),
('Groundhog Day', 7.99, 2, 200),
('Easy Rider', 6.99, 2, 300),
('David Bowie Greatest Hits', 9.99, 3, 200),
('Depeche Mode Greatest Hits', 9.99, 3, 200);

create table customers (id int primary key auto_increment, name varchar(100) not null,
email varchar(80) not null);

insert into customers (name, email) values
('Chris Walken', 'chris@caveofprogramming.com'),
('Mike Mikkelson', 'mike@quantumlifetime.com'),
('Rog Blake', 'blake@fascinatingexperiments.com');

create table sales (id int primary key auto_increment,
customer_id int not null,
product_id int not null, 
sold_at datetime,
transaction_value decimal(7, 2) default 0,
foreign key (customer_id) references customers(id),
foreign key (product_id) references products(id)
);

insert into sales (customer_id, product_id, sold_at, transaction_value)
values
(1, 4, '2015-03-13 12:24:43', 8.99),
(2, 2, '2015-03-12 11:04:12', 6.99),
(1, 7, '2015-03-12 11:14:12', 6.99),
(3, 2, '2015-03-11 11:05:12', 6.99),
(3, 8, '2015-03-12 11:07:12', 9.99),
(1, 2, '2015-03-11 11:14:12', 6.99),
(2, 4, '2015-03-12 11:04:12', 8.99),
(1, 1, '2015-03-14 11:34:12', 2.99);

select * from customers c join sales s on s.customer_id=c.id join products p on p.id=s.product_id 
join categories cat on cat.id=p.category_id;

-- Yeu cau 2
create view customer_sale1 as select * from sales s join customers c on c.id = s.customer_id;
-- Không chạy được do khi truy vấn sales va customers đều có cột id nên khi truy vấn trả về 2 cột id

create algorithm=merge view customer_sale2 as select c.id  from sales s join customers c on c.id = s.customer_id;

create algorithm=temptable view customer_sale3 as select c.id  from sales s join customers c on c.id = s.customer_id;
-- Truy vấn sale2 và sale 3 đều có cùng kết quả trả về, tuy nhiên về tốc độ thì truy vấn sale_2 sẽ nhanh hơn do gộp các truy vấn con liên quan và sử dụng trực tiếp các bảng cơ sở thay vì tạo bảng tạm.
-- sale3 sẽ phải tạo bảng tạm để lưu trữ kết quả truy vấn trước khi trả về kết quả cuối cùng

create algorithm=merge view customer_sale4 as select count(*), c.id  from sales s join customers c on c.id = s.customer_id;

create algorithm=undefined view customer_sale5 as select count(*), c.id  from sales s join customers c on c.id = s.customer_id;
-- Truy vấn 5 thì hệ thống sẽ tự chọn giá trị algorithm thích hợp
-- Truy vấn 4,5 có thể tạo ra bảng view nhưng sẽ không query hàm select do sử dụng count(*), c.id nhưng lại không group by c.id, nên k thể truy vấn ra được. 
-- Khi thêm group by c.id vào cuối  truy vấn 4 và 5 để tạo ra view thì ở truy vấn 4 do sử dụng count(*) nên hệ thống sẽ sử dụng undefined thay vì merger 
drop view customer_sale4;