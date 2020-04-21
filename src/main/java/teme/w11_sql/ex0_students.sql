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


--b) Display the list of course (the description of each) with the statistics: the minimum, maximum and average grade per course


--c) Display the list of students (the name for each) and the number of courses followed by each student


--d) Display the total count of students following Java related courses (which contain 'Java' in their description)


--e) Display the name and average grade for the student with the greatest average grade (based on grades from all his followed courses)


--f) Update the grades of all students following the Java related courses, by increasing current grade by +1, but without getting them past 10
