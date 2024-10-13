use book_data;

-- Yeu cau 1
select count(*) as number_book from books;

-- Yeu cau 2
SELECT COUNT(*) AS number_book, released_year
FROM books
GROUP BY released_year
ORDER BY released_year;

-- Yeu cau 3
SELECT SUM(stock_quantity) AS sum_stock
FROM books;

-- Yeu cau 4
SELECT AVG(released_year) AS avg_released_year
FROM books
GROUP BY author_lname;

-- Yeu cau 5

SELECT 
	CONCAT(author_fname, ' ', author_lname) as fullname,
	max(pages) as pages
from books
WHERE pages = (SELECT MAX(pages) FROM books) 
group by fullname;