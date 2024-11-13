USE book_data;

-- Yêu cầu 1:
SELECT * from books order by pages desc limit 1;

-- Yêu cầu 2:
SELECT title, released_year from books order by released_year  desc limit 3;

-- Yêu cầu 3:
SELECT title, author_lname from books where author_lname like "% %";

-- Yêu cầu 4:
SELECT title, released_year, stock_quantity from books order by stock_quantity asc limit 3;

-- Yêu cầu 5:
SELECT title, author_lname from books order by author_lname ASC, title ASC;
