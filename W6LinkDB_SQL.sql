create database w6linkdb;
use  w6linkdb;


Create table user(
	name varchar(50) not null,
    email varchar(50) not null,
    password varchar(50) not null,
    enabled boolean not null default true,
    authority varchar(50) not null,
    primary key(name));

select * from skill;
select * from posting;
select * from education;
select * from job;
select * from duty;
select * from user;
select * from user_data;
select * from role;
select * from user_data_roles;
select * from user;

insert into user_data (email,enabled,first_name,last_name,password,role_name,username) 
values('s1@test.org', true, 's1', 'm1', 'password', 'recruiter', 's1m1');
insert into role values(1,'recruiter');
select * from authorities;
select * from book;

create table authorities(
	username varchar(50) not null,
    authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)

);

create unique index ix_auth_username on authorities (username,authority);

insert into user(name,email,password) values ('user2','u2@test.org', 'pwd2');
insert into user(name,password) values ('user2', 'pwd2');
insert into user(name,password) values ('Bob', '12345');

insert into authorities(username, authority) values('user1', 'ADMIN');
insert into authorities(username, authority) values('user2', 'ADMIN');
insert into authorities(username, authority) values('Bob', 'ADMIN');

