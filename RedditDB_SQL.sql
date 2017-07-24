use redditDB;

select * from Link;
select * from users;
select * from user;
select * from authorities;

insert into user (username, password) values ('DJakademiks','Smite');

insert into user (username, password) values ('user1','pwd1');

insert into authorities (username, authority) values ('DJakademiks','ADMIN');

insert into authorities (username, authority) values ('user1','ADMIN');