
create database ATMDB;

Use ATMDB;
drop table if exists authorities;
drop table if exists users;


Create table users(
	username varchar(50) not null,
    password varchar(50) not null,
    enabled boolean not null default true,
    primary key(username)

);

create table authorities(
	username varchar(50) not null,
    authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)

);



create unique index ix_auth_username on authorities (username,authority);

insert into users(username,password) values ('user1', 'pwd1');
insert into users(username,password) values ('user2', 'pwd2');

insert into authorities(username, authority) values('user1', 'ADMIN');
insert into authorities(username, authority) values('user2', 'ADMIN');


Use ATM;

Insert into account(acct_num, balance, user_name) values ('101', '20000.00','user1');
Insert into account(acct_num, balance, user_name) values ('100', '15000.00','user2');
Insert into account(acct_num, balance, user_name) values ('102', '10000.00','user1');

Insert into transaction(acct_num,action,amt,reason) values ('101','Deposit','20000.00', 'Initial Deposit');
Insert into transaction(acct_num,action,amt,reason) values ('100','Deposit','15000.00', 'Initial Deposit');
Insert into transaction(acct_num,action,amt,reason) values ('102','Deposit','10000.00', 'Initial Deposit');

desc transaction;

select * from account;