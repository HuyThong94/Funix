
-- Yeu cau 1
create database book_shop;

use book_shop;

create table students(
id int auto_increment primary key,
first_name varchar(150) not null
);

create table papers(
student_id int,
title varchar(150),
grade int,
foreign key (student_id) references students(id)
);

-- Yeu cau 2
insert into students(first_name) values('Caleb'), ('Samantha'), ('Raj'), ('Carlos'), ('Lisa');

INSERT INTO papers (student_id, title, grade ) VALUES
(1, 'My First Book Report', 60),
(1, 'My Second Book Report', 75),
(2, 'Russian Lit Through The Ages', 94),
(2, 'De Montaigne and The Art of The Essay', 98),
(4, 'Borges and Magical Realism', 89);

-- Yeu cau 3

select * from students;

select * from papers;

-- Yeu cau 4
-- KQ1
select 
	s.first_name,
    p.title,
    p.grade
from students s
left join papers p on s.id = p.student_id;

-- KQ2
select 
	s.first_name,
    ifnull(p.title, 'MISSING'),
    ifnull(p.grade, 0)
from students s
left join papers p on s.id = p.student_id;

-- KQ3
select 
	s.first_name,
    COALESCE(avg(p.grade), 0) as average
from students s
left join papers p on s.id = p.student_id
group by s.first_name
order by average desc;

-- KQ3
select 
	s.first_name,
    COALESCE(avg(p.grade), 0) as average,
    CASE 
	   WHEN COALESCE(AVG(p.grade), 0) >= 70 THEN 'PASSING'
	   ELSE 'FAILING'
   END AS passing_status
from students s
left join papers p on s.id = p.student_id
group by s.first_name
order by average desc;