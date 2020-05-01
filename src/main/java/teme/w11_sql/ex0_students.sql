-- ========================
-- Ex0. Students (warm-up)
-- ========================

pragma foreign_keys = on; --make sure FK checks are on

----------------------------------------------
-- Init script - tables + sample data
-----------------------------------------------

-- Drop existing tables? (run this manually if needed: select whole text of the row, without the '--' prefix, then: Alt+X)
-- drop table grades; drop table courses; drop table students;

-- 1) Create 'students' table, with 3 columns:
--      id    - integer number, Primary Key of this table
--      name  - text, unique values, mandatory
--      email - text, optional

-- TODO!


-- 2) Create 'courses' table, with 3 columns:
--      id          - integer number, Primary Key of this table
--      description - text, unique values, mandatory
--      duration    - integer number, optional

-- TODO!


-- 3) Create 'grades' table, with 3 columns:
--      course_id - integer number, mandatory, Foreign Key to id from courses
--      stud_id   - integer number, mandatory, Foreign Key to id from students
--      grade     - integer number, mandatory
--    Extra: the combination of course_id + stud_id should be forced to be unique for each row

-- TODO!

create table students( id integer not null primary key,
    name text unique not null,
    email text
);

create table courses( id integer not null primary key,
    description text unique not null,
    duration integer
);

create table grades( course_id references courses (id) not null,
    stud_id references students(id) not null,
    grade integer not null
);


-----------------------------------------------
-- Once you created the 3 tables above correctly, the queries below should
-- execute without errors, and insert some sample data to your tables:

insert into students(id, name) values(1, 'Andrei');
insert into students(id, name) values(2, 'Bogdan');
insert into students(id, name, email) values(3, 'Cristi', 'cristi@gmail.com');
insert into students(id, name) values(4, 'Daniel');

insert into courses (id, description, duration) values (101, 'Intro', 1 );
insert into courses (id, description, duration) values (201, 'Java', 4 );
insert into courses (id, description, duration) values (202, 'Java Advanced', 4 );
insert into courses (id, description, duration) values (301, 'Python', 4 );

insert into grades values(301, 3, 9);
insert into grades values(301, 1, 8);
insert into grades values(101, 1, 10);
insert into grades values(101, 2, 10);
insert into grades(course_id, stud_id, grade) values(301, 2, 7);
insert into grades values(201, 2, 9);
insert into grades values(202, 1, 9);
insert into grades values(201, 4, 10);
insert into grades values(202, 4, 9);
insert into grades values(202, 3, 8);


select * from
    (select count() courses  from courses),
	(select count() students from students),
	(select count() grades   from grades);

select * from students;
select * from courses;
select * from grades;

----------------------------------------------
-- TODO: YOUR SOLUTION BELOW
-----------------------------------------------

--a) Display all student grades, showing columns: course description, student name, grade; to be sorted by: course (ASC) + grade (DESC)
SELECT
	courses.description as course,
	students.name as student,
	grade
FROM
	grades
INNER JOIN courses ON
	grades.course_id = courses.id
INNER JOIN students ON
	grades.stud_id = students.id
ORDER BY
	description ASC,
	grade DESC;

--b) Display the list of course (the description of each) with the statistics: the minimum, maximum and average grade per course
select
	c.description as course,
	min(g.grade) as min_grade,
	max(g.grade) as max_grade,
	avg(g.grade) as average_grade
from
	courses c
join grades g on
	c.id = g.course_id
group by
	c.id;

--c) Display the list of students (the name for each) and the number of courses followed by each student
SELECT
	name as student_name,
	COUNT() as number_of_courses
FROM
	students
JOIN grades ON
	grades.stud_id = students.id
group BY students.name;

--d) Display all the Java related courses (which contain 'Java' in their description)
SELECT * FROM courses WHERE description LIKE '%java%';

--e) Display the name and average grade for the student with the greatest average grade
-- (based on grades from all his followed courses)
SELECT
	s.name,
	avg(g.grade) as average_grade
FROM
	students s
JOIN grades g ON
	g.stud_id = s.id
GROUP BY
	s.name
order by average_grade desc
limit 1;

--f) Update the grades of all students following the Java related courses,
-- by increasing current grade by +1, but without getting them past 10
UPDATE
	grades
set
	grade = grade + 1
where
	grade < 10
	and course_id in (
	select
		id
	from
		courses
	where
		lower(description) like '%java%')