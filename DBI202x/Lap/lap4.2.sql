use book_data;

-- Yêu cầu 1:
select concat(author_fname,author_lname) from books;

select concat_ws("-", author_fname, author_lname) from books;

-- Yêu cầu 2:
select substring("data analyst", 5, 11);

-- Yêu cầu 3:
select replace("data analyst", "analyst", "science");

select replace(title, " ", "->") from books;

-- Yêu cầu 4:
select reverse("data analyst");

-- Yêu cầu 5:
select char_length("data analyst");

select char_length(title) from books;

-- Yêu cầu 6:
select upper("database");

select upper(title) from books;

-- Yêu cầu 7:
select lower("DATABASE");

select lower(title) from books;