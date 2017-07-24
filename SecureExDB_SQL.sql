
create database SecureExDB;
Use secureexdb;
drop table if exists authorities;
drop table if exists users;


Create table users(
	username varchar(50) not null,
    password varchar(50) not null,
    enabled boolean not null default true,
    primary key(username)

);

select * from users;
select * from authorities;
select * from book;

create table authorities(
	username varchar(50) not null,
    authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)

);

create unique index ix_auth_username on authorities (username,authority);

insert into users(username,password) values ('user1', 'pwd1');
insert into users(username,password) values ('user2', 'pwd2');
insert into users(username,password) values ('Bob', '12345');

insert into authorities(username, authority) values('user1', 'ADMIN');
insert into authorities(username, authority) values('user2', 'ADMIN');
insert into authorities(username, authority) values('Bob', 'ADMIN');

insert into book values('1', 'a1', 'img1', 't1');
insert into book values('2', 'a2', 'img2', 't2');
insert into book values('3', 'a3', 'img3', 't3');