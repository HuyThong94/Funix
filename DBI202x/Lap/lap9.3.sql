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