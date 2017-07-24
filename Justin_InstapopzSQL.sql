create database instapopzDB;
use instapopzdb;

select * from user_data;
select * from image;
select * from likes;
insert into user_data (email,enabled,password,role_name,username) 
values('s1@test.org', true, 'password', 'USER', 'satmeh'); 

delete from image where user_id = 1;
insert into image ( caption,filter_url1,filter_url2,filter_value,img_name,img_src,like_count,user_id)
values('cap_flowers','filter_flower1','filter_flower2',1,'rose',
'http://res.cloudinary.com/demo/image/upload/sample.jpg',5,1);


insert into image ( caption,filter_url1,filter_url2,filter_value,img_name,img_src,like_count,user_id)
values('cap_flowers','https://static.pexels.com/photos/36753/flower-purple-lical-blosso.jpg','https://static.pexels.com/photos/36753/flower-purple-lical-blosso.jpg',1,'rose',
'https://static.pexels.com/photos/36753/flower-purple-lical-blosso.jpg',5,2);

insert into image ( caption,filter_url1,filter_url2,filter_value,img_name,img_src,like_count,user_id)
values('cap_flowers','https://static.pexels.com/photos/36753/flower-purple-lical-blosso.jpg','filter_flower2',1,'rose',
'https://static.pexels.com/photos/36753/flower-purple-lical-blosso.jpg',5,2);

insert into likes values(2,2);