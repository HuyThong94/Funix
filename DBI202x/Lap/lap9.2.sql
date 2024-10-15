use book_shop;

-- Yeu cau 1
 create table reviewers(
 id int auto_increment primary key,
 first_name varchar(100),
 last_name varchar(100)
 );
 
 create table series(
 id int auto_increment primary key,
 title varchar(100) not null,
 released_year year(4),
 genre varchar(100)
 );
  
 create table reviews(
 id int auto_increment primary key,
 rating float,
 series_id int,
 reviewer_id int,
 foreign key (series_id) references series(id),
 foreign key (reviewer_id) references reviewers(id)
 );
 
 -- Yeu cau 2
 INSERT INTO series (title, released_year, genre) VALUES
    ('Archer', 2009, 'Animation'),
    ('Arrested Development', 2003, 'Comedy'),
    ("Bob's Burgers", 2011, 'Animation'),
    ('Bojack Horseman', 2014, 'Animation'),
    ("Breaking Bad", 2008, 'Drama'),
    ('Curb Your Enthusiasm', 2000, 'Comedy'),
    ("Fargo", 2014, 'Drama'),
    ('Freaks and Geeks', 1999, 'Comedy'),
    ('General Hospital', 1963, 'Drama'),
    ('Halt and Catch Fire', 2014, 'Drama'),
    ('Malcolm In The Middle', 2000, 'Comedy'),
    ('Pushing Daisies', 2007, 'Comedy'),
    ('Seinfeld', 1989, 'Comedy'),
    ('Stranger Things', 2016, 'Drama');
 

INSERT INTO reviewers (first_name, last_name) VALUES
    ('Thomas', 'Stoneman'),
    ('Wyatt', 'Skaggs'),
    ('Kimbra', 'Masters'),
    ('Domingo', 'Cortes'),
    ('Colt', 'Steele'),
    ('Pinkie', 'Petit'),
    ('Marlon', 'Crafford');
     
INSERT INTO reviews(series_id, reviewer_id, rating) VALUES
    (1,1,8.0),(1,2,7.5),(1,3,8.5),(1,4,7.7),(1,5,8.9),
    (2,1,8.1),(2,4,6.0),(2,3,8.0),(2,6,8.4),(2,5,9.9),
    (3,1,7.0),(3,6,7.5),(3,4,8.0),(3,3,7.1),(3,5,8.0),
    (4,1,7.5),(4,3,7.8),(4,4,8.3),(4,2,7.6),(4,5,8.5),
    (5,1,9.5),(5,3,9.0),(5,4,9.1),(5,2,9.3),(5,5,9.9),
    (6,2,6.5),(6,3,7.8),(6,4,8.8),(6,2,8.4),(6,5,9.1),
    (7,2,9.1),(7,5,9.7),
    (8,4,8.5),(8,2,7.8),(8,6,8.8),(8,5,9.3),
    (9,2,5.5),(9,3,6.8),(9,4,5.8),(9,6,4.3),(9,5,4.5),
    (10,5,9.9),
    (13,3,8.0),(13,4,7.2),
    (14,2,8.5),(14,3,8.9),(14,4,8.9);

-- Yeu cau 3
select * from reviewers;

select * from series;

select * from reviews;

-- Yeu cau 4
select 
	s.title,
	cast(r.rating as decimal(3,1)) as rating
from series s
left join reviews r on r.series_id = s.id
where r.rating is not null
order by s.title asc;

-- Yeu cau 5
select 
	s.title,
	cast(avg(r.rating) as decimal(7,5)) as avg_rating
from series s
left join reviews r on r.series_id = s.id
where r.rating is not null
group by s.title
order by avg_rating asc;

-- Yeu cau 6
SELECT 
    s.genre,
    CAST(AVG(r.rating) AS DECIMAL (7 , 2 )) AS avg_rating
FROM
    series s
        LEFT JOIN
    reviews r ON r.series_id = s.id
WHERE
    r.rating IS NOT NULL
GROUP BY s.genre
ORDER BY s.genre ASC;

-- Yeu cau 7
SELECT 
    rv.first_name,
    rv.last_name,
    cast(r.rating as decimal(3,1)) as rating
FROM
    reviewers rv
        LEFT JOIN
    reviews r ON r.reviewer_id = rv.id
WHERE
    r.rating IS NOT NULL;

-- Yeu cau 8
SELECT 
    s.title as unreviewed_series
FROM
    series s
        LEFT JOIN
    reviews r ON r.series_id = s.id
WHERE
    r.rating IS NULL
GROUP BY s.title
ORDER BY s.title ASC;

-- Yeu cau 9
SELECT 
    rv.first_name,
    rv.last_name,
    count(r.rating) as COUNT,
     CASE 
     WHEN count(r.rating) > 0 THEN
     (select cast(avg(r.rating)as decimal(4, 2))
		from reviews r
		left join reviewers rw on rw.id = r.reviewer_id
        where r.reviewer_id = rv.id)
        ELSE cast(0 as decimal(4, 2))
        END avg
FROM
    reviewers rv
        LEFT JOIN
    reviews r ON r.reviewer_id = rv.id
    group by rv.id;
