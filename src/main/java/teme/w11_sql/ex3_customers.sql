-- ========================
-- Ex3. Customers
-- ========================

pragma foreign_keys = on; --make sure FK checks are on

----------------------------------------------
-- Init script - tables + sample data
-----------------------------------------------

-- Drop existing tables? (run this manually if needed: select whole text of the row, without the '--' prefix, then: Alt+X)
-- drop table orders; drop table customers;

create table customers (
  customer_id      int         not null primary key,
  last_name        varchar(50) not null,
  first_name       varchar(50) not null,
  favorite_website varchar(50));

create table orders (
  order_id    int not null primary key,
  customer_id int references customers(customer_id),
  order_date  datetime);

insert into customers (customer_id, last_name, first_name, favorite_website) values (4000, 'Jackson', 'Joe', 'techonthenet.com');
insert into customers (customer_id, last_name, first_name, favorite_website) values (5000, 'Smith', 'Jane', 'digminecraft.com');
insert into customers (customer_id, last_name, first_name, favorite_website) values (6000, 'Ferguson', 'Samantha', 'bigactivities.com');
insert into customers (customer_id, last_name, first_name, favorite_website) values (7000, 'Reynolds', 'Allen', 'checkyourmath.com');
insert into customers (customer_id, last_name, first_name, favorite_website) values (8000, 'Anderson', 'Paige', null);
insert into customers (customer_id, last_name, first_name, favorite_website) values (9000, 'Johnson', 'Derek', 'techonthenet.com');

insert into orders (order_id, customer_id, order_date) values (1,7000,datetime('2018-04-18'));
insert into orders (order_id, customer_id, order_date) values (2,5000,datetime('2018-04-18'));
insert into orders (order_id, customer_id, order_date) values (3,8000,datetime('2018-04-19'));
insert into orders (order_id, customer_id, order_date) values (4,4000,datetime('2018-04-20'));
insert into orders (order_id, customer_id, order_date) values (5,null,datetime('2018-05-01'));
insert into orders (order_id, customer_id, order_date) values (6,4000,datetime('2018-05-02'));

select * from
	(select count() customers from customers),
	(select count() orders from orders);

----------------------------------------------
-- TODO: YOUR SOLUTION BELOW
----------------------------------------------

