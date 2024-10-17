USE hr;


-- Yeu cau 1
SELECT 
	emp.first_name,
    emp.last_name,
    emp.job_id,
    emp.salary
FROM employees emp
WHERE lower(emp.first_name) LIKE lower(concat('s','%'));

-- Yeu cau 2
SELECT 
	emp.employee_id,
	emp.first_name,
    emp.last_name,
    emp.job_id,
    emp.salary
FROM employees emp
WHERE emp.salary = (select max(salary) from employees);

-- Yeu cau 3
SELECT 
    emp.first_name,
    emp.last_name,
    emp.job_id,
    emp.salary
FROM employees emp
WHERE emp.salary = (
    SELECT DISTINCT salary
    FROM employees
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
);

-- Yeu cau 4
SELECT 
    emp.first_name,
    emp.last_name,
    emp.job_id,
    emp.salary
FROM employees emp
WHERE emp.salary = (
    SELECT DISTINCT salary
    FROM employees
    ORDER BY salary DESC
    LIMIT 1 OFFSET 2
);

-- Yeu cau 5
SELECT 
    concat(emp.first_name, " ", emp.last_name) as employee,
    emp.salary as emp_sal,
    concat(mgr.first_name, " ", mgr.last_name) as manager,
    mgr.salary as mgr_sal
FROM employees emp
JOIN employees mgr on emp.manager_id = mgr.employee_id;

-- Yeu cau 6
SELECT 
    mgr.employee_id,
    CONCAT(mgr.first_name, " ", mgr.last_name) AS manager_name,
    COUNT(emp.employee_id) AS number_of_reportees
FROM employees mgr
LEFT JOIN employees emp ON emp.manager_id = mgr.employee_id
GROUP BY mgr.employee_id, mgr.first_name, mgr.last_name
ORDER BY number_of_reportees DESC;

-- Yeu cau 7
SELECT 
    d.department_name,
    COUNT(emp.employee_id) AS emp_count
FROM departments d
LEFT JOIN employees emp ON emp.department_id = d.department_id
GROUP BY d.department_id, d.department_name
ORDER BY emp_count DESC;

-- Yeu cau 8
SELECT 
    DATE_FORMAT(hire_date, '%Y') AS hired_year,
    COUNT(employee_id) AS employees_hired_count
FROM employees
GROUP BY hired_year
ORDER BY employees_hired_count DESC, hired_year asc;

-- Yeu cau 9
SELECT 
	min(salary) AS min_sal,
    max(salary) as max_sal,
    floor(avg(salary)) as avg_sal
FROM employees;

-- Yeu cau 10
SELECT 
	concat(first_name, " ", last_name) as employee,
    salary,
    CASE
		WHEN salary >= 2000 and salary < 5000 then "low"
		WHEN salary >= 5000 and salary < 10000 then "mid"
        else "high"
        end salary_level
FROM employees
order by employee;

-- Yeu cau 11
SELECT 
	concat(first_name, " ", last_name) as employee,
    replace(phone_number, ".", "-") as phone_number
FROM employees;

-- Yeu cau 12
SELECT 
	concat(first_name, " ", last_name) as employee,
	hire_date
FROM employees
where date_format(hire_date, "%m-%Y") = "08-1994";

-- Yeu cau 13
SELECT 
	concat(emp.first_name, emp.last_name) as employee,
    emp.employee_id,
    d.department_name as department,
    d.department_id,
    emp.salary
FROM employees emp
LEFT JOIN departments d on d.department_id = emp.department_id
WHERE emp.salary > (SELECT AVG(salary) FROM employees)
ORDER BY d.department_id, emp.employee_id;

-- Yeu cau 14
SELECT 
    d.department_id,
    d.department_name as department,
    MAX(emp.salary) as Maximum_salary
FROM departments d
LEFT JOIN employees emp on d.department_id = emp.department_id
WHERE emp.salary is not null
group by d.department_name
ORDER BY d.department_id;

-- Yeu cau 15
SELECT 
    first_name,
    last_name,
    employee_id,
    salary
FROM employees
WHERE salary >= (select min(salary) from employees)
ORDER BY salary
limit 5;

-- Yeu cau 16
SELECT 
	lower(first_name) as name,
	REVERSE(lower(first_name)) AS name_in_reverse
FROM employees;

-- Yeu cau 17
SELECT 
	employee_id,
	concat(first_name, " ", last_name) as employee,
	hire_date
FROM employees
where date_format(hire_date, "%d") > "15";

-- Yeu cau 18
SELECT 
    concat(mgr.first_name, " ", mgr.last_name) as manager,
    concat(emp.first_name, " ", emp.last_name) as employee,
    mgr.department_id as mgr_dept,
    emp.department_id as emp_dept
FROM employees emp
JOIN employees mgr on emp.manager_id = mgr.employee_id
WHERE mgr.department_id != emp.department_id
order by manager;