drop database Customers;

create database Customers;

-- switch to the customers database (It's case sensitive)
use Customers;

-- import customers.csv
-- Right-click on tables and select import, use the wizard to import the csv file



-- see how many customers are in our table: (use back ticks for strings)
select count(*) as `Customer Count` from customers;

-- how many unique companies are in our table?
select count(distinct company)as 'Distinct Companies' from customers ;

-- add a column for the CompanyID to the customers table
alter table customers add CompanyID int;

-- notice that the companyId is null
select companyID, company from customers;

-- create a table for the companies
-- this statement will also create a companyID column which will
-- increment when you insert a new record
create table Company (
companyID int NOT NULL AUTO_INCREMENT,
Company varchar(50),
primary key (companyID)
);

-- see what's in your company table now
select * from Company;

-- see the definition of the company table
describe Company;

-- add a test company to verify that the identity field works
insert into Company(company)values ('Dave Company');

-- see what's in your companies table now
select * from Company;

-- add unique companies from customers to the company table
insert into Company (company) select distinct company from customers;

-- look at what you've done
select * from Company;

-- another way to select is to list the fields
select companyID, Company from customers;

/*
If you get ...
Error Code: 1175. You are using safe update mode and you tried 
to update a table without a WHERE that uses a KEY column 
To disable safe mode, toggle the option in 
Preferences -> SQL Editor and reconnect.

To reconnect: Query Menu -> Reconnect to Server
*/

-- update the compnayId in the customers table
update customers c set c.companyID = (select t.companyID from
Company t where t.company=c.company);

-- query to check your data
select c.companyID,c.company,t.companyID,t.Company from
customers c inner join Company t on c.CompanyID=t.CompanyID;

-- remove the company column from the customers table. It is no longer needed
alter table customers drop column company;

-- notice you won't see the company column
select * from customers;

-- the company column and the id are in Company
select * from Company;

-- a query to bring it all back together
select fullname, company from customers 
inner join Company on 
customers.companyid=Company.companyid;


 
