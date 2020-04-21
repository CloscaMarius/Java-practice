-- =============================
-- Ex4. Employees (INIT SCRIPT)
-- =============================
-- NOTE: its easiest to run this is with DBeaver tool, as it can run the WHOLE
--       script at once! (Alt+X), instead of 1 statement at a time in IntelliJ..
--------------------------------------------------------------------------------

pragma foreign_keys = on; --make sure FK checks are on

--------------------------------------------------------------------------------
-- Init script - tables + sample data
--
-- Script compatible with SQLite dialect of sql
-- You can easily run this WHOLE script at once using the DBeaver tool:
--  * first you configure the connection/db file,
--  * then open this script and use the 'Execute SQL script' operation (Alt+X)
--  * after it runs, check for errors and also for the final count of rows
--    in all 7 tables (see the last select)
--------------------------------------------------------------------------------

-- Drop existing tables? (run this manually if needed: select whole text of the row, without the '--' prefix, then: Alt+X)
-- PRAGMA foreign_keys=OFF;drop table job_history; drop table employees; drop table jobs; drop table departments; drop table locations; drop table countries; drop table regions;PRAGMA foreign_keys=ON;

-- Create the tables:
create table regions (
 ID     int primary key,
 NAME   varchar(145));

create table countries (
 ID        varchar(145) primary key,
 NAME      varchar(145),
 REGION_ID varchar(145) references regions(id)); -- a Foreign Key defined inline (short syntax, usable for FK of only 1 column)

create table locations (
 ID             int primary key,
 STREET_ADDRESS varchar(145),
 POSTAL_CODE    varchar(145),
 CITY           varchar(145),
 STATE          varchar(145),
 COUNTRY_ID     varchar(145) references countries(id));

create table jobs (
 ID         varchar(145) primary key,
 NAME       varchar(145),
 MIN_SALARY int,
 MAX_SALARY int);


-- Column departments.manager_id SHOULD be a FK to employees.id.
-- But that table also has a FK to this one, so we must create it later; this means we cannot create the manager_id FK here now.
-- But as SQLite does NOT allow FKs to be added later to existing tables/columns,
-- we will create the table WITHOUT this column for now, and then ADD it later (including its FK), after employees is created!
create table departments (
 ID          int primary key,
 NAME        varchar(145),
 LOCATION_ID int           references locations(id)
 -- ,MANAGER_ID int references employees(id)
);

create table employees (
 ID            int primary key,
 FIRST_NAME    varchar(145),
 LAST_NAME     varchar(145),
 EMAIL         varchar(145),
 PHONE_NUMBER  varchar(145),
 HIRE_DATE     date,
 JOB_ID        varchar(145)  references jobs(id),
 SALARY        int,
 COMISSION_PCT decimal(2,2),
 MANAGER_ID    int           references employees(id),
 DEPARTMENT_ID int           references departments(id));

-- The magic here (to create the circular FK dependency between the 2 tables):
alter table departments 
add column MANAGER_ID int references employees(id);


create table job_history (
 EMPLOYEE_ID   int          references employees(id),
 START_DATE    date,
 END_DATE      date,
 JOB_ID        varchar(145) references jobs(id),
 DEPARTMENT_ID int          references departments(id),
 primary key (EMPLOYEE_ID,START_DATE)); --composite PK, combination of these 2 colum should be unique

-- Delete old data (if needed)
-- DELETE FROM job_history; DELETE FROM employees; DELETE FROM jobs; DELETE FROM departments; DELETE FROM locations; DELETE FROM countries; DELETE FROM regions;

-- Insert sample data:
insert into regions values(2,'Americas');
insert into regions values(3,'Asia');
insert into regions values(1,'Europe');
insert into regions values(4,'Middle East and Africa');
insert into regions values(7,'Moldova');

insert into countries values('AR','Argentina',2);
insert into countries values('AU','Australia',3);
insert into countries values('BE','Belgium',1);
insert into countries values('BR','Brazil',2);
insert into countries values('CA','Canada',2);
insert into countries values('CH','Switzerland',1);
insert into countries values('CN','China',3);
insert into countries values('DE','Germany',1);
insert into countries values('DK','Denmark',1);
insert into countries values('EG','Egypt',4);
insert into countries values('FR','France',1);
insert into countries values('HK','HongKong',3);
insert into countries values('IL','Israel',4);
insert into countries values('IN','India',3);
insert into countries values('IT','Italy',1);
insert into countries values('JP','Japan',3);
insert into countries values('KW','Kuwait',4);
insert into countries values('MX','Mexico',2);
insert into countries values('NG','Nigeria',4);
insert into countries values('NL','Netherlands',1);
insert into countries values('SG','Singapore',3);
insert into countries values('UK','United Kingdom',1);
insert into countries values('US','United States of America',2);
insert into countries values('ZM','Zambia',4);
insert into countries values('ZW','Zimbabwe',4);

insert into locations values(1000,'1297 Via Cola di Rie','989','Roma','','IT');
insert into locations values(1100,'93091 Calle della Testa','10934','Venice','','IT');
insert into locations values(1200,'2017 Shinjuku-ku','1689','Tokyo','Tokyo Prefecture','JP');
insert into locations values(1300,'9450 Kamiya-cho','6823','Hiroshima','','JP');
insert into locations values(1400,'2014 Jabberwocky Rd','26192','Southlake','Texas','US');
insert into locations values(1500,'2011 Interiors Blvd','99236','South San Francisco','California','US');
insert into locations values(1600,'2007 Zagora St','50090','South Brunswick','New Jersey','US');
insert into locations values(1700,'2004 Charade Rd','98199','Seattle','Washington','US');
insert into locations values(1800,'147 Spadina Ave','M5V 2L7','Toronto','Ontario','CA');
insert into locations values(1900,'6092 Boxwood St','YSW 9T2','Whitehorse','Yukon','CA');
insert into locations values(2000,'40-5-12 Laogianggen','190518','Beijing','','CN');
insert into locations values(2100,'1298 Vileparle (E)','490231','Bombay','Maharashtra','IN');
insert into locations values(2200,'12-98 Victoria Street','2901','Sydney','New South Wales','AU');
insert into locations values(2300,'198 Clementi North','540198','Singapore','','SG');
insert into locations values(2400,'8204 Arthur St','','London','','UK');
insert into locations values(2500,'''Magdalen Centre','OX9 9ZB',' The Oxford ','Oxford','UK');
insert into locations values(2600,'9702 Chester Road','9629850293','Stretford','Manchester','UK');
insert into locations values(2700,'Schwanthalerstr. 7031','80925','Munich','Bavaria','DE');
insert into locations values(2800,'Rua Frei Caneca 1360','01307-002','Sao Paulo','Sao Paulo','BR');
insert into locations values(2900,'20 Rue des Corps-Saints','1730','Geneva','Geneve','CH');
insert into locations values(3000,'Murtenstrasse 921','3095','Bern','BE','CH');
insert into locations values(3100,'Pieter Breughelstraat 837','3029SK','Utrecht','Utrecht','NL');
insert into locations values(3200,'Mariano Escobedo 9991','11932','Mexico City','Distrito Federal','MX');

insert into jobs values('AC_ACCOUNT','Public Accountant',4200,9000);
insert into jobs values('AC_MGR','Accounting Manager',8200,16000);
insert into jobs values('AD_ASST','Administration Assistant',3000,6000);
insert into jobs values('AD_PRES','President',20000,40000);
insert into jobs values('AD_VP','Administration Vice President',15000,30000);
insert into jobs values('AL CLERK','ALL Clerk',3500,5000);
insert into jobs values('FI_ACCOUNT','Accountant',4200,9000);
insert into jobs values('FI_MGR','Finance Manager',8200,16000);
insert into jobs values('HR_REP','Human Resources Representative',4000,9000);
insert into jobs values('IT_PROG','Programmer',4000,10000);
insert into jobs values('MK_MAN','Marketing Manager',9000,15000);
insert into jobs values('MK_REP','Marketing Representative',4000,9000);
insert into jobs values('PR_REP','Public Relations Representative',4500,10500);
insert into jobs values('PU_CLERK','Purchasing Clerk',2500,5500);
insert into jobs values('PU_MAN','Purchasing Manager',8000,15000);
insert into jobs values('SA_MAN','Sales Manager',10000,20000);
insert into jobs values('SA_REP','Sales Representative',6000,12000);
insert into jobs values('SH_CLERK','Shipping Clerk',2500,5500);
insert into jobs values('ST_CLERK','Stock Clerk',2000,5000);
insert into jobs values('ST_MAN','Stock Manager',5500,8500);

-- disble FK tempoarely, as department.manager_id refferes employees not existing yet!
pragma foreign_keys = off;
insert into departments values(10,'Administration',1700,200);
insert into departments values(20,'Marketing',1800,201);
insert into departments values(30,'Purchasing',1700,114);
insert into departments values(40,'Human Resources',2400,203);
insert into departments values(50,'Shipping',1500,121);
insert into departments values(60,'IT',1400,103);
insert into departments values(70,'Public Relations',2700,204);
insert into departments values(80,'Sales',2500,145);
insert into departments values(90,'Executive',1700,100);
insert into departments values(100,'Finance',1700,108);
insert into departments values(110,'Accounting',1700,205);
insert into departments values(120,'Treasury',1700,100);
insert into departments values(130,'Corporate Tax',1700,100);
insert into departments values(140,'Control And Credit',1700,100);
insert into departments values(150,'Shareholder Services',1700,100);
insert into departments values(160,'Benefits',1700,100);
insert into departments values(170,'Manufacturing',1700,100);
insert into departments values(180,'Construction',1700,100);
insert into departments values(190,'Contracting',1700,100);
insert into departments values(200,'Operations',1700,100);
insert into departments values(210,'IT Support',1700,100);
insert into departments values(220,'NOC',1700,100);
insert into departments values(230,'IT Helpdesk',1700,100);
insert into departments values(240,'Government Sales',1700,100);
insert into departments values(250,'Retail Sales',1700,100);
insert into departments values(260,'Recruiting',1700,100);
insert into departments values(270,'Payroll',1700,100);
pragma foreign_keys = on;

insert into employees values(100,'Steven','King','daking','0747291186',strftime('1987-06-17'),'AD_PRES',24000,0,null,90);
insert into employees values(101,'Neena','Kochhar','NKOCHHAR','515.123.4568',strftime('1987-06-18'),'AD_VP',17000,0,100,90);
insert into employees values(102,'Lex','De Haan','LDEHAAN','515.123.4569',strftime('1987-06-19'),'AD_VP',17000,0,100,90);
insert into employees values(103,'Alexander','Hunold','AHUNOLD','590.423.4567',strftime('1987-06-20'),'IT_PROG',9000,0,102,60);
insert into employees values(104,'Bruce','Ernst','BERNST','590.423.4568',strftime('1987-06-21'),'IT_PROG',6000,0,103,60);
insert into employees values(105,'David','Austin','DAUSTIN','590.423.4569',strftime('1987-06-22'),'IT_PROG',3000,0,103,60);
insert into employees values(106,'Valli','Pataballa','VPATABAL','590.423.4560',strftime('1987-06-23'),'IT_PROG',4800,0,103,60);
insert into employees values(107,'Diana','Lorentz','DLORENTZ','590.423.5567',strftime('1987-06-24'),'IT_PROG',4200,0,103,60);
insert into employees values(108,'Nancy','Greenberg','NGREENBE','515.124.4569',strftime('1987-06-25'),'FI_MGR',12000,0,101,100);
insert into employees values(109,'Daniel','Faviet','DFAVIET','515.999.4169',strftime('1987-06-26'),'FI_ACCOUNT',9000,0,108,100);
insert into employees values(110,'John','Chen','JCHEN','515.999.4269',strftime('1987-06-27'),'FI_ACCOUNT',8200,0,108,100);
insert into employees values(111,'Ismael','Sciarra','ISCIARRA','515.124.4369',strftime('1987-06-28'),'FI_ACCOUNT',7700,0,108,100);
insert into employees values(112,'Jose Manuel','Urman','JMURMAN','515.124.4469',strftime('1987-06-29'),'FI_ACCOUNT',7800,0,108,100);
insert into employees values(113,'Luis','Popp','LPOPP','515.124.4567',strftime('1987-06-30'),'FI_ACCOUNT',6900,0,108,100);
insert into employees values(114,'Den','Raphaely','DRAPHEAL','515.127.4561',strftime('1987-07-01'),'PU_MAN',11000,0,100,30);
insert into employees values(115,'Alexander','Khoo','AKHOO','515.127.4562',strftime('1987-07-02'),'PU_CLERK',3100,0,114,30);
insert into employees values(116,'Shelli','Baida','SBAIDA','515.127.4563',strftime('1987-07-03'),'PU_CLERK',2900,0,114,30);
insert into employees values(117,'Sigal','Tobias','STOBIAS','515.127.4564',strftime('1987-07-04'),'PU_CLERK',2800,0,114,30);
insert into employees values(118,'Guy','Himuro','GHIMURO','515.127.4565',strftime('1987-07-05'),'PU_CLERK',2600,0,114,30);
insert into employees values(119,'Karen','Colmenares','KCOLMENA','515.127.4566',strftime('1987-07-06'),'PU_CLERK',2500,0,114,30);
insert into employees values(120,'Matthew','Weiss','MWEISS','650.123.1234',strftime('1987-07-07'),'ST_MAN',8000,0,100,50);
insert into employees values(121,'Adam','Fripp','AFRIPP','650.123.2234',strftime('1987-07-08'),'ST_MAN',8200,0,100,50);
insert into employees values(122,'Payam','Kaufling','PKAUFLIN','650.123.3234',strftime('1987-07-09'),'ST_MAN',7900,0,100,50);
insert into employees values(123,'Shanta','Vollman','SVOLLMAN','650.123.4234',strftime('1987-07-10'),'ST_MAN',6500,0,100,50);
insert into employees values(124,'Kevin','Mourgos','KMOURGOS','650.123.5234',strftime('1987-07-11'),'ST_MAN',5800,0,100,20);
insert into employees values(125,'Julia','Nayer','JNAYER','650.124.1214',strftime('1987-07-12'),'ST_CLERK',3200,0,120,50);
insert into employees values(126,'Irene','Mikkilineni','IMIKKILI','650.124.1224',strftime('1987-07-13'),'ST_CLERK',2700,0,120,50);
insert into employees values(127,'James','Landry','JLANDRY','650.124.1334',strftime('1987-07-14'),'ST_CLERK',2400,0,120,50);
insert into employees values(128,'Steven','Markle','SMARKLE','650.124.1434',strftime('1987-07-15'),'ST_CLERK',2200,0,120,50);
insert into employees values(129,'Laura','Bissot','LBISSOT','650.124.5234',strftime('1987-07-16'),'ST_CLERK',3300,0,121,50);
insert into employees values(130,'Mozhe','Atkinson','MATKINSO','650.124.6234',strftime('1987-07-17'),'ST_CLERK',2800,0,121,50);
insert into employees values(131,'James','Marlow','JAMRLOW','650.124.7234',strftime('1987-07-18'),'ST_CLERK',2500,0,121,50);
insert into employees values(132,'TJ','Olson','TJOLSON','650.124.8234',strftime('1987-07-19'),'ST_CLERK',2100,0,121,50);
insert into employees values(133,'Jason','Mallin','JMALLIN','650.127.1934',strftime('1987-07-20'),'ST_CLERK',3300,0,122,50);
insert into employees values(134,'Michael','Rogers','MROGERS','650.127.1834',strftime('1987-07-21'),'ST_CLERK',2900,0,122,50);
insert into employees values(135,'Ki','Gee','KGEE','650.127.1734',strftime('1987-07-22'),'ST_CLERK',2400,0,122,20);
insert into employees values(136,'Hazel','Philtanker','HPHILTAN','650.127.1634',strftime('1987-07-23'),'ST_CLERK',2200,0,122,50);
insert into employees values(137,'Renske','Ladwig','RLADWIG','650.121.1234',strftime('1987-07-24'),'ST_CLERK',3600,0,123,50);
insert into employees values(138,'Stephen','Stiles','SSTILES','650.121.2034',strftime('1987-07-25'),'ST_CLERK',3200,0,123,50);
insert into employees values(139,'John','Seo','JSEO','650.121.2019',strftime('1987-07-26'),'ST_CLERK',2700,0,123,50);
insert into employees values(140,'Joshua','Patel','JPATEL','650.121.1834',strftime('1987-07-27'),'ST_CLERK',2500,0,123,50);
insert into employees values(141,'Trenna','Rajs','TRAJS','650.121.8009',strftime('1987-07-28'),'ST_CLERK',3500,0,124,50);
insert into employees values(142,'Curtis','Davies','CDAVIES','650.121.2994',strftime('1987-07-29'),'ST_CLERK',3100,0,124,50);
insert into employees values(143,'Randall','Matos','RMATOS','650.121.2874',strftime('1987-07-30'),'ST_CLERK',2600,0,124,50);
insert into employees values(144,'Peter','Vargas','PVARGAS','650.121.2004',strftime('1987-07-31'),'ST_CLERK',2500,0,124,50);
insert into employees values(145,'John','Russell','JRUSSEL','011.44.1344.429268',strftime('1987-08-01'),'SA_MAN',14000,0.40,100,80);
insert into employees values(146,'Karen','Partners','KPARTNER','011.44.1344.467268',strftime('1987-08-02'),'SA_MAN',13500,0.30,100,80);
insert into employees values(147,'Alberto','Errazuriz','AERRAZUR','011.44.1344.429278',strftime('1987-08-03'),'SA_MAN',12000,0.30,100,80);
insert into employees values(148,'Gerald','Cambrault','GCAMBRAU','011.44.1344.619268',strftime('1987-08-04'),'SA_MAN',11000,0.30,100,80);
insert into employees values(149,'Eleni','Zlotkey','EZLOTKEY','011.44.1344.429018',strftime('1987-08-05'),'SA_MAN',10500,0.20,100,80);
insert into employees values(150,'Peter','Tucker','PTUCKER','011.44.1344.129268',strftime('1987-08-06'),'SA_REP',10000,0.30,145,80);
insert into employees values(151,'David','Bernstein','DBERNSTE','011.44.1344.345268',strftime('1987-08-07'),'SA_REP',9500,0.25,145,80);
insert into employees values(152,'Peter','Hall','PHALL','011.44.1344.478968',strftime('1987-08-08'),'SA_REP',9000,0.25,145,80);
insert into employees values(153,'Christopher','Olsen','COLSEN@wantsome.ro','011.44.1344.498718',strftime('1987-08-09'),'SA_REP',8000,0.20,145,80);
insert into employees values(154,'Nanette','Cambrault','NCAMBRAU','011.44.1344.987668',strftime('1987-08-10'),'SA_REP',7500,0.20,145,80);
insert into employees values(155,'Oliver','Tuvault','OTUVAULT','011.44.1344.486508',strftime('1987-08-11'),'SA_REP',7000,0.15,145,80);
insert into employees values(156,'Janette','King','JKING','011.44.1345.429268',strftime('1987-08-12'),'SA_REP',10000,0.35,146,80);
insert into employees values(157,'Patrick','Sully','PSULLY','011.44.1345.929268',strftime('1987-08-13'),'SA_REP',9500,0.35,146,80);
insert into employees values(158,'Allan','McEwen','AMCEWEN','011.44.1345.829268',strftime('1987-08-14'),'SA_REP',9000,0.35,146,80);
insert into employees values(159,'Lindsey','Smith','LSMITH','011.44.1345.729268',strftime('1987-08-15'),'SA_REP',8000,0.30,146,80);
insert into employees values(160,'Louise','Doran','LDORAN','011.44.1345.629268',strftime('1987-08-16'),'SA_REP',7500,0.30,146,80);
insert into employees values(161,'Sarath','Sewall','SSEWALL','011.44.1345.529268',strftime('1987-08-17'),'SA_REP',7000,0.25,146,80);
insert into employees values(162,'Clara','Vishney','CVISHNEY','011.44.1346.129268',strftime('1987-08-18'),'SA_REP',10500,0.25,147,80);
insert into employees values(163,'Danielle','Greene','DGREENE','011.44.1346.229268',strftime('1987-08-19'),'SA_REP',9500,0.15,147,80);
insert into employees values(164,'Mattea','Marvins','MMARVINS','011.44.1346.329268',strftime('1987-08-20'),'SA_REP',7200,0.10,147,80);
insert into employees values(165,'David','Lee','DLEE','011.44.1346.529268',strftime('1987-08-21'),'SA_REP',6800,0.10,147,80);
insert into employees values(166,'Sundar','Ande','SANDE','011.44.1346.629268',strftime('1987-08-22'),'SA_REP',6400,0.10,147,80);
insert into employees values(167,'Amit','Banda','ABANDA','011.44.1346.729268',strftime('1987-08-23'),'SA_REP',6200,0.10,147,80);
insert into employees values(168,'Lisa','Ozer','LOZER','011.44.1343.929268',strftime('1987-08-24'),'SA_REP',11500,0.25,148,80);
insert into employees values(169,'Harrison','Bloom','HBLOOM','011.44.1343.829268',strftime('1987-08-25'),'SA_REP',10000,0.20,148,80);
insert into employees values(170,'Tayler','Fox','TFOX','011.44.1343.729268',strftime('1987-08-26'),'SA_REP',9600,0.20,148,80);
insert into employees values(171,'William','Smith','WSMITH','011.44.1343.629268',strftime('1987-08-27'),'SA_REP',7400,0.15,148,80);
insert into employees values(172,'Elizabeth','Bates','EBATES','011.44.1343.529268',strftime('1987-08-28'),'SA_REP',7300,0.15,148,80);
insert into employees values(173,'Sundita','Kumar','SKUMAR','011.44.1343.329268',strftime('1987-08-29'),'SA_REP',6100,0.10,148,80);
insert into employees values(174,'Ellen','Abel','EABEL','011.44.1644.429267',strftime('1987-08-30'),'SA_REP',11000,0.30,149,80);
insert into employees values(175,'Alyssa','Hutton','AHUTTON','011.44.1644.429266',strftime('1987-08-31'),'SA_REP',8800,0.25,149,80);
insert into employees values(176,'Jonathon','Taylor','JTAYLOR','011.44.1644.429265',strftime('1987-09-01'),'SA_REP',8600,0.20,149,80);
insert into employees values(177,'Jack','Livingston','JLIVINGS','011.44.1644.429264',strftime('1987-09-02'),'SA_REP',8400,0.20,149,80);
insert into employees values(178,'Kimberely','Grant','KGRANT','011.44.1644.429263',strftime('1987-09-03'),'SA_REP',7000,0.15,149,20);
insert into employees values(179,'Charles','Johnson','CJOHNSON','011.44.1644.429262',strftime('1987-09-04'),'SA_REP',6200,0.10,149,80);
insert into employees values(180,'Winston','Taylor','WTAYLOR','650.507.9876',strftime('1987-09-05'),'SH_CLERK',3200,0,120,50);
insert into employees values(181,'Jean','Fleaur','JFLEAUR','650.507.9877',strftime('1987-09-06'),'SH_CLERK',3100,0,120,50);
insert into employees values(182,'Martha','Sullivan','MSULLIVA','650.507.9878',strftime('1987-09-07'),'SH_CLERK',2500,0,120,50);
insert into employees values(183,'Girard','Geoni','GGEONI','650.507.9879',strftime('1987-09-08'),'SH_CLERK',2800,0,120,50);
insert into employees values(184,'Nandita','Sarchand','NSARCHAN','650.509.1876',strftime('1987-09-09'),'SH_CLERK',4200,0,121,50);
insert into employees values(185,'Alexis','Bull','ABULL','650.509.2876',strftime('1987-09-10'),'SH_CLERK',4100,0,121,50);
insert into employees values(186,'Julia','Dellinger','JDELLING','650.509.3876',strftime('1987-09-11'),'SH_CLERK',3400,0,121,50);
insert into employees values(187,'Anthony','Cabrio','ACABRIO','650.509.4876',strftime('1987-09-12'),'SH_CLERK',3000,0,121,50);
insert into employees values(188,'Kelly','Chung','KCHUNG','650.505.1876',strftime('1987-09-13'),'SH_CLERK',3800,0,122,20);
insert into employees values(189,'Jennifer','Dilly','JDILLY','650.505.2876',strftime('1987-09-14'),'SH_CLERK',3600,0,122,50);
insert into employees values(190,'Timothy','Gates','TGATES','650.505.3876',strftime('1987-09-15'),'SH_CLERK',2900,0,122,50);
insert into employees values(191,'Randall','Perkins','RPERKINS','650.505.4876',strftime('1987-09-16'),'SH_CLERK',2500,0,122,50);
insert into employees values(192,'Sarah','Bell','SBELL','650.501.1876',strftime('1987-09-17'),'SH_CLERK',4000,0,123,50);
insert into employees values(193,'Britney','Everett','BEVERETT','650.501.2876',strftime('1987-09-18'),'SH_CLERK',3900,0,123,50);
insert into employees values(194,'Samuel','McCain','SMCCAIN','650.501.3876',strftime('1987-09-19'),'SH_CLERK',3200,0,123,50);
insert into employees values(195,'Vance','Jones','VJONES','650.501.4876',strftime('1987-09-20'),'SH_CLERK',2800,0,123,50);
insert into employees values(196,'Alana','Walsh','AWALSH','650.507.9811',strftime('1987-09-21'),'SH_CLERK',3100,0,124,50);
insert into employees values(197,'Kevin','Feeney','KFEENEY','650.507.9822',strftime('1987-09-22'),'SH_CLERK',3000,0,124,20);
insert into employees values(198,'Donald','OConnell','DOCONNEL','650.507.9833',strftime('1987-09-23'),'SH_CLERK',2600,0,124,50);
insert into employees values(199,'Douglas','Grant','DGRANT','650.507.9844',strftime('1987-09-24'),'SH_CLERK',2600,0,124,50);
insert into employees values(200,'Jennifer','Whalen','JWHALEN','515.123.4444',strftime('1987-09-25'),'AD_ASST',4400,0,101,10);
insert into employees values(201,'Michael','Hartstein','MHARTSTE','515.123.5555',strftime('1987-09-26'),'MK_MAN',13000,0,100,20);
insert into employees values(202,'Pat','Fay','PFAY','603.123.6666',strftime('1987-09-27'),'MK_REP',6000,0,201,20);
insert into employees values(203,'Susan','Mavris','SMAVRIS','515.123.7777',strftime('1987-09-28'),'HR_REP',6500,0,101,40);
insert into employees values(204,'Hermann','Baer','HBAER','515.123.8888',strftime('1987-09-29'),'PR_REP',10000,0,101,70);
insert into employees values(205,'Shelley','Higgins','SHIGGINS','515.123.8080',strftime('1987-09-30'),'AC_MGR',12000,0,101,110);
insert into employees values(206,'William','Gietz','WGIETZ','515.123.8181',strftime('1987-10-01'),'AC_ACCOUNT',8300,0,205,110);

insert into job_history values (101,strftime('1989-09-21'),strftime('1993-10-27'),'AC_ACCOUNT',110);
insert into job_history values (101,strftime('1993-10-28'),strftime('1997-03-15'),'AC_MGR',110);
insert into job_history values (102,strftime('1993-01-13'),strftime('1998-07-24'),'IT_PROG',60);
insert into job_history values (114,strftime('1998-03-24'),strftime('1999-12-31'),'ST_CLERK',50);
insert into job_history values (122,strftime('1999-01-01'),strftime('1999-12-31'),'ST_CLERK',50);
insert into job_history values (176,strftime('1998-03-24'),strftime('1998-12-31'),'SA_REP',80);
insert into job_history values (176,strftime('1999-01-01'),strftime('1999-12-31'),'SA_MAN',80);
insert into job_history values (201,strftime('1996-02-17'),strftime('1999-12-19'),'MK_REP',20);
--insert into job_history values (70000,strftime('1987-09-17'),strftime('1993-06-17'),'AD_ASST',90);
--insert into job_history values (70000,strftime('1994-07-01'),strftime('1998-12-31'),'AC_ACCOUNT',90);


select * from 
	(select count() regions from regions),
	(select count() countries from countries),
	(select count() locations from locations),
	(select count() departments from departments),
	(select count() jobs from jobs),
	(select count() employees from employees),
	(select count() job_history from job_history);


--select * from regions;
--select * from countries;
--select * from locations;
--select * from departments;
--select * from jobs;
--select * from employees;
--select * from job_history;


