use book_data;

-- Yeu cau 1
SELECT CURTIME();
SELECT CURDATE();
SELECT DAYOFWEEK(CURDATE());
SELECT DAYOFWEEK(NOW());
SELECT DATE_FORMAT(NOW(), '%w') + 1;
SELECT DAYNAME(NOW());
SELECT DATE_FORMAT(NOW(), '%W');
SELECT DATE_FORMAT(CURDATE(), '%m/%d/%Y');
SELECT DATE_FORMAT(NOW(), '%M %D at %h:%i');

-- Yeu cau 2
create table  tweets (
content varchar(140),
username varchar(20),
created_at timestamp default now()
);

insert into 
	tweets(content, username)
values
	('this is my first tweet', 'coltscat'),
	('this is my second tweet', 'coltscat');
    
select * from tweets;