USE book_data;
-- Yêu cầu 1:
SELECT 10 != 10;
SELECT 15 > 14 && 99 - 5 <= 94;
SELECT 1 IN (5,3) || 9 BETWEEN 8 AND 10;

-- Yêu cầu 2:
select * from books where released_year < 1980;

select * from books where author_lname = "Eggers" or author_lname = "Chabon";

select * from books where released_year < 2000 and author_lname = "lahiri";

select * from books where pages <= 200 && pages >= 100;

SELECT 
    title, 
    CASE
        WHEN title LIKE '%stories%' THEN 'Short Stories'
        WHEN title LIKE '%Just Kids%' OR title = 'A Heartbreaking Work of Staggering Genius' THEN 'Memoir'
        ELSE 'Novel'
    END AS TYPE
FROM books;