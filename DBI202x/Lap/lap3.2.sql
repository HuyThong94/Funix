-- Yeu cau 1
create table unique_cats(
cat_id int NOT NULL primary key, 
name varchar(100),
age int
);

-- Yeu cau 2
insert into unique_cats(cat_id, name, age)values(1, 'Fred', 23),(2, 'Louise', 3),(3, 'James', 3);

-- Yeu cau 3
create table unique_cats2(
cat_id int NOT NULL auto_increment primary key, 
name varchar(100),
age int
);

-- Yeu cau 4
insert into unique_cats2(name, age)values('Skippy', 4),('Jiff', 3),('Jiff', 3),('Jiff', 3),('Skippy', 4);
-- Yeu cau 5: 
select * from unique_cats2;
-- Trường cat_id sẽ tự động tăng khi insert dữ liệu vào bảng

-- Yeu cau 6
CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    age INT NOT NULL,
    current_status VARCHAR(255) NOT NULL DEFAULT 'employed',
    PRIMARY KEY (id)
);

-- Yeu cau 7
INSERT INTO employees (first_name, last_name, age) VALUES 
('Dora', 'Smith', 58);

-- Yeu cau 8
select * from employees;
-- trường id sẽ tự động tăng
-- trường middle_name sẽ có giá trị mặc định là null do k được truyền dữ liệu vào
-- trường current_status có k được truyền dữ liệu vào nhưng do giá trị defaul là employed nên sẽ có giá trị là employed