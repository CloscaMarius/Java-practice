-- ===========================
-- Ex4. Employees (SOLUTION)
-- ===========================

-- !NOTE: before working on your solution, check/run the separate INIT script!

pragma foreign_keys = on; --make sure FK checks are on

---------------------------------------------------------
-- TODO: YOUR SOLUTION BELOW (after you ran init script)
---------------------------------------------------------
--I. SELECT--

--1.--
SELECT *
FROM employees
where
length(FIRST_NAME)>=8;

--2.--
SELECT FIRST_name as FirstName,
LENGTH(FIRST_NAME) as NameLength
FROM employees
where
FIRST_NAME LIKE 'A%'
or FIRST_NAME LIKE 'J%'
or FIRST_NAME LIKE 'M%'
ORDER BY FIRST_NAME ASC ;

--3.--
SELECT first_name ||' '|| last_name as Name,
salary as Salary,
salary * 15 /100 as TAX
FROM employees;

--4.--
SELECT d.ID, d.Name
FROM departments d
where d.ID
not in
(SELECT department_id FROM employees e where d.id=e.DEPARTMENT_ID );

--5.--
SELECT e.FIRST_NAME ||' '||e.LAST_NAME as Name, SALARY
FROM employees e
where SALARY >
(SELECT SALARY FROM employees e2 where e2.LAST_NAME = 'Bell');

--6.--
SELECT e.ID ,e.FIRST_NAME, e.LAST_NAME ,e.SALARY, e.DEPARTMENT_ID
FROM employees e
where SALARY >
(SELECT AVG(e2.SALARY) FROM employees e2, departments d2 where e.DEPARTMENT_ID = d2.id )
;

--II. JOIN--

--1.--
SELECT *
from job_history jh
join employees e on
jh.employee_id = e.ID
WHERE e.SALARY > 10000;

--2.--
SELECT j.NAME as JobName,
e.FIRST_NAME ||' '||e.LAST_NAME as Name,
e.SALARY - j.MIN_SALARY as Difference
from jobs j
join employees e on
j.ID = e.JOB_ID;

--3.--
SELECT j.NAME as JobName, avg(SALARY) as AverageSalary
from jobs j
join employees e
on j.ID = e.JOB_ID
group by j.NAME ;

--4.--
SELECT d.NAME as DepartmentName,
e.FIRST_NAME||' '||e.LAST_NAME as Name,
l.CITY as City
FROM departments d
join employees e
on(d.MANAGER_ID = e.ID)
join locations l
on l.ID = d.LOCATION_ID;

--5.--
SELECT d.ID as DepartmentID,
d.NAME as DepartmentName,
e.FIRST_NAME as FirstName
FROM departments d
join employees e
on d.MANAGER_ID = e.id;

--6.--
SELECT jh.EMPLOYEE_ID as EmployeeID,
j.NAME as JobName,
JULIANDAY( jh.END_DATE) - JULIANDAY(jh.START_DATE) as NumberOfDays
from job_history jh
join jobs j
on jh.JOB_ID = j.ID
where jh.DEPARTMENT_ID = '110';

--III. UPDATE--

--1.--
UPDATE employees
set PHONE_NUMBER = REPLACE (PHONE_NUMBER, '590', '111')
WHERE PHONE_NUMBER LIKE '590%';

--2.--
UPDATE employees
SET  EMAIL = EMAIL || '@wantsome.ro'
where EMAIL not LIKE '%@wantsome.ro';

--3.--
UPDATE employees
set SALARY = '8000'
WHERE ID = 105
and SALARY < 5000;

--4.--
UPDATE employees
set ID = 'SH_CLERK'
WHERE ID = 118
AND department_id=30
AND NOT JOB_ID LIKE 'SH%';

--5.--
UPDATE employees
SET salary = CASE department_id
WHEN 40 THEN salary*2
WHEN 90 THEN salary*3
WHEN 110 THEN salary*10
ELSE salary
END
WHERE department_id IN (40,50,50,60,70,80,90,110);