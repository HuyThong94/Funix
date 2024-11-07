-- Yeu cau 1
select * from city where CountryCode= "USA" AND POPULATION > 100000;

-- Yeu cau 2
select name from city where population>120000 and countrycode="USA";

-- Yeu cau 3
select * from city;

-- Yeu cau 4
select * from city where countrycode="jpn";

-- Yeu cau 5
select name from city where countrycode="jpn";

-- Yeu cau 6
select city, state from station;

