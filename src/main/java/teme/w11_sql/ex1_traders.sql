-- ========================
-- Ex1. Traders (warm-up)
-- ========================

pragma foreign_keys = on; --make sure FK checks are on

----------------------------------------------
-- Init script - tables + sample data
-----------------------------------------------

-- Drop existing tables? (run this manually if needed: select whole text of the row, without the '--' prefix, then: Alt+X)
-- drop table traders;
-- drop table transactions;

----------------------------------------------
-- TODO: YOUR SOLUTION BELOW
----------------------------------------------

-- Create the 2 tables:
create table traders (
    id   int primary key,
    name text not null unique,
    city text not null
);

create table transactions (
    id        int primary key,
    year      int,
    value     int,
    trader_id int not null references traders (id)
);



-- Insert some test data in theme:

insert into traders values (1, 'Tony', 'Milan');
insert into traders values (2, 'John', 'Cambridge');
insert into traders values (3, 'Oliver', 'Cambridge');
insert into traders values (4, 'Ion', 'Iasi');

insert into transactions values(1, 2011, 100, 1);
insert into transactions values(2, 2012, 80, 1);
insert into transactions values(3, 2013, 120, 1);
insert into transactions values(4, 2011, 50, 3);
insert into transactions values(5, 2010, 130, 2);
insert into transactions values(6, 2011, 70, 2);
insert into transactions values(7, 2012, 90, 2);
insert into transactions values(8, 2011, 60, 4);
insert into transactions values(9, 2012, 140, 4);



-- The queries to solve rest of requirements

--1. Find all transactions from a specific year (like 2019) and sort them by value (small to high)
SELECT *
FROM
	transactions
Where
	YEAR = 2011
ORDER BY
	value;


--2. What are the names of all the unique cities where traders work?
SELECT DISTINCT city
FROM
	traders;


--3. Find all traders from a some city (like 'Cambridge'), sort them by name (desc)
SELECT *
FROM
	traders
Where
	city = 'Cambridge'
ORDER BY
	name;


