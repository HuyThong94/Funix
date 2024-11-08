-- Yeu cau 1
select sum(ci.population)
from city ci
left join country co on ci.countrycode = co.code
where co.continent = 'Asia';

-- Yeu cau 2
select ci.name
from city ci
left join country co on ci.countrycode = co.code
where co.continent = 'africa';

-- Yeu cau 3
select co.continent,
floor(avg(ci.population))
from city ci
left join country co on ci.countrycode = co.code
where co.continent is not null
group by co.continent;

-- Yeu cau 4
SELECT s.hacker_id, h.name
FROM Submissions s
JOIN Challenges c ON s.challenge_id = c.challenge_id
JOIN Difficulty d ON c.difficulty_level = d.difficulty_level
JOIN Hackers h ON s.hacker_id = h.hacker_id
WHERE s.score = d.score
GROUP BY s.hacker_id, h.name
HAVING COUNT(DISTINCT s.challenge_id) > 1
ORDER BY COUNT(DISTINCT s.challenge_id) DESC, s.hacker_id ASC;

-- Yeu cau 5
SELECT CONCAT(Name, '(', LEFT(Occupation, 1), ')') AS NameProfession
FROM OCCUPATIONS
ORDER BY Name;

SELECT CONCAT('There are a total of ', COUNT(Occupation), ' ', LOWER(Occupation), 's.') AS OccupationCount
FROM OCCUPATIONS
GROUP BY Occupation
ORDER BY COUNT(Occupation), Occupation;

-- Yeu cau 6
select w.id,wp.age,w.coins_needed,w.power 
from wands as w 
inner join wands_property as wp on w.code=wp.code 
where 
	wp.is_evil=0 
	AND w.coins_needed=( select min(a.coins_needed) from wands as a 
	join wands_property as p on a.code=p.code 
	where a.power=w.power AND wp.age=p.age)
order by w.power desc,wp.age desc;

-- Yeu cau 7
WITH challenge_counts AS (
    SELECT h.hacker_id, h.name, COUNT(DISTINCT c.challenge_id) AS t_challenges
    FROM hackers h
    JOIN challenges c ON h.hacker_id = c.hacker_id
    GROUP BY h.hacker_id, h.name
),
max_challenge_count AS (
    SELECT MAX(t_challenges) AS max_no_challenge FROM challenge_counts
),
unique_challenge_counts AS (
    SELECT t_challenges
    FROM challenge_counts
    GROUP BY t_challenges
    HAVING COUNT(*) = 1
)
SELECT cc.hacker_id, cc.name, cc.t_challenges
FROM challenge_counts cc
JOIN max_challenge_count mcc ON cc.t_challenges = mcc.max_no_challenge
   OR cc.t_challenges IN (SELECT t_challenges FROM unique_challenge_counts)
ORDER BY cc.t_challenges DESC, cc.hacker_id;

-- Yeu cau 8
SELECT h.hacker_id, h.name, COALESCE(SUM(max_scores.max_score), 0) AS total_score
FROM Hackers h
JOIN (
    SELECT hacker_id, challenge_id, MAX(score) AS max_score
    FROM Submissions
    GROUP BY hacker_id, challenge_id
) AS max_scores ON h.hacker_id = max_scores.hacker_id
GROUP BY h.hacker_id, h.name
HAVING total_score > 0
ORDER BY total_score DESC, h.hacker_id ASC;

-- Yeu cau 9
SELECT 
    MIN(Start_Date), 
    MAX(End_Date) 
    FROM 
    (SELECT *, DATE_ADD(Start_Date, INTERVAL - DENSE_RANK() OVER ( ORDER BY Start_Date) DAY) AS Grp FROM Projects) B 
    group by grp 
    order by MAX(End_Date)-MIN(Start_Date);
    
-- Yeu cau 10
SELECT s.Name
FROM Students AS s
LEFT JOIN Friends AS f 
ON s.ID = f.ID
LEFT JOIN Packages AS p_stu
ON s.ID = p_stu.ID
LEFT JOIN Packages AS p_fri
ON f.Friend_ID = p_fri.ID
WHERE  p_fri.Salary > p_stu.Salary
ORDER BY p_fri.Salary ASC;

-- Yeu cau 11
select distinct f.x, f.y 
from functions f
where f.x < f.y and exists(select x, y from functions where f.x = y and f.y = x) or 
      f.x = f.y and (select count(x) from functions where x = f.x and x = y) > 1
order by f.x;

-- Yeu cau 12
SELECT c.contest_id, c.hacker_id, c.name,
       COALESCE(SUM(s.total_submissions), 0) AS total_submissions,
       COALESCE(SUM(s.total_accepted_submissions), 0) AS total_accepted_submissions,
       COALESCE(SUM(v.total_views), 0) AS total_views,
       COALESCE(SUM(v.total_unique_views), 0) AS total_unique_views
FROM Contests c
JOIN Colleges col ON c.contest_id = col.contest_id
JOIN Challenges ch ON col.college_id = ch.college_id
LEFT JOIN View_Stats v ON ch.challenge_id = v.challenge_id
LEFT JOIN Submission_Stats s ON ch.challenge_id = s.challenge_id
GROUP BY c.contest_id, c.hacker_id, c.name
HAVING total_submissions > 0 OR total_accepted_submissions > 0 OR total_views > 0 OR total_unique_views > 0
ORDER BY c.contest_id;