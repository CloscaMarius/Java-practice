-- ========================
-- Ex2. Suppliers
-- ========================

pragma foreign_keys = on; --make sure FK checks are on

----------------------------------------------
-- Init script - tables + sample data
-----------------------------------------------

-- Drop existing tables? (run this manually if needed: select whole text of the row, without the '--' prefix, then: Alt+X)
-- drop table suppliers;

create table suppliers (
  supplier_id int not null primary key,
  supplier_name varchar(50) not null,
  city varchar(50), 
  state varchar(25));

insert into suppliers (supplier_id, supplier_name, city, state) values (100, 'Microsoft', 'Redmond', 'Washington');
insert into suppliers (supplier_id, supplier_name, city, state) values (200, 'Google', 'Mountain View', 'California');
insert into suppliers (supplier_id, supplier_name, city, state) values (300, 'Oracle', 'Redwood City', 'California');
insert into suppliers (supplier_id, supplier_name, city, state) values (400, 'Kimberly-Clark', 'Irving', 'Texas');
insert into suppliers (supplier_id, supplier_name, city, state) values (500, 'Tyson Foods', 'Springdale', 'Arkansas');
insert into suppliers (supplier_id, supplier_name, city, state) values (600, 'SC Johnson', 'Racine', 'Wisconsin');
insert into suppliers (supplier_id, supplier_name, city, state) values (700, 'Dole Food Company', 'Westlake Village', 'California');
insert into suppliers (supplier_id, supplier_name, city, state) values (800, 'Flowers Foods', 'Thomasville', 'Georgia');
insert into suppliers (supplier_id, supplier_name, city, state) values (900, 'Electronic Arts', 'Redwood City', 'California');

select count() suppliers_count from suppliers;

----------------------------------------------
-- TODO: YOUR SOLUTION BELOW
----------------------------------------------

