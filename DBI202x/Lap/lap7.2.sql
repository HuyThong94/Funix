-- Yeu cau 1
select sum(population) 
from city 
where district='california';

-- Yeu cau 2
select avg(population)
from city
where district='california';

-- Yeu cau 3
select round(avg(population))
from city;

-- Yeu cau 4
select sum(population) as sum_population
from city
where countrycode = 'jpn';

-- Yeu cau 5
select 
    max(population) - min(population)
from city;

-- Yeu cau 6
SELECT CEIl(AVG(Salary) - AVG(CAST(REPLACE(Salary, '0', '') AS UNSIGNED))) AS error_amount
FROM EMPLOYEES;

-- Yeu cau 7
SELECT MAX(salary * months) AS max_total_earnings, 
       COUNT(*) AS employee_count
FROM EMPLOYEE
WHERE salary * months = (SELECT MAX(salary * months) FROM EMPLOYEE);

-- Yeu cau 8
select 
    round(sum(lat_n),2),
    round(sum(long_w), 2)
from station;

-- Yeu cau 9
SELECT COUNT(*) - COUNT(DISTINCT city)
FROM station;

-- Yeu cau 10
-- Shortest city name
SELECT CITY, LENGTH(CITY) AS NAME_LENGTH
FROM STATION
ORDER BY NAME_LENGTH ASC, CITY ASC
LIMIT 1;
-- Longest city name
SELECT CITY, LENGTH(CITY) AS NAME_LENGTH
FROM STATION
ORDER BY NAME_LENGTH desc, CITY desc
LIMIT 1;

-- Yeu cau 11
select 
    truncate(sum(lat_n), 4) 
from station
where lat_n > 38.7880 and lat_n < 137.2345;

-- Yeu cau 12
select truncate(max(lat_n), 4) as lat_n_max
from station
where lat_n < 137.2345;

-- Yeu cau 13
select 
    Round(LONG_W, 4) as long_w
from STATION
WHERE LAT_N = (
    SELECT MAX(LAT_N)
    FROM STATION
    WHERE LAT_N < 137.2345
);

-- Yeu cau 14
SELECT ROUND(MIN(LAT_N), 4) AS LAT_N
FROM STATION
WHERE LAT_N > 38.7780;

-- Yeu cau 15
SELECT ROUND(LONG_W, 4) AS LONG_W
FROM STATION
WHERE LAT_N = 
            (SELECT 
                MIN(LAT_N)
            FROM STATION 
            WHERE LAT_N > 38.7780);
            
-- Yeu cau 16
SELECT ROUND(
    ABS(MAX(LAT_N) - MIN(LAT_N)) + ABS(MAX(LONG_W) - MIN(LONG_W)), 4
) AS MANHATTAN_DISTANCE
FROM STATION;

-- Yeu cau 17
SELECT 
    C.COMPANY_CODE,
    C.FOUNDER,
    COUNT(DISTINCT LM.LEAD_MANAGER_CODE) AS COUNT_LM,
    COUNT(DISTINCT SM.SENIOR_MANAGER_CODE) AS COUNT_SM,
    COUNT(DISTINCT M.MANAGER_CODE) AS COUNT_M,
    COUNT(DISTINCT E.EMPLOYEE_CODE) AS COUNT_E
    
FROM COMPANY C
LEFT JOIN LEAD_MANAGER LM ON C.COMPANY_CODE = LM.COMPANY_CODE
LEFT JOIN SENIOR_MANAGER SM ON C.COMPANY_CODE = SM.COMPANY_CODE
LEFT JOIN MANAGER M ON C.COMPANY_CODE = M.COMPANY_CODE
LEFT JOIN EMPLOYEE E ON C.COMPANY_CODE = E.COMPANY_CODE
GROUP BY 
    C.COMPANY_CODE, C.FOUNDER
ORDER BY COMPANY_CODE ASC;

-- Yeu cau 18
    SELECT 
    FORMAT(
        SQRT(POW(MAX(LAT_N) - MIN(LAT_N), 2) + POWER(MAX(LONG_W) - MIN(LONG_W), 2)), 4
    ) AS EUCLIDEAN_DISTANCE
FROM 
    STATION;