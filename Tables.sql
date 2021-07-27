use amdocs;

create table user1(
user_id int primary key,
name varchar(100),
phone_no bigint,
email varchar(100),
address varchar(100),
reg_date date,
password varchar(100)
);
ALTER TABLE user1 AUTO_INCREMENT=100;
drop table user1;
select * from user1;
select name from user1 where name='Ankit' and password='ankit';
insert into user1(user_id,name,phone_no,email,address,reg_date,password)
values (101,'Ankit',4578008234,'ankit@gmail.com','noida','2021-01-03','ankit'),
(102,'Rahul',9586234712,'rahul@gmail.com','banglore','2021-03-03','rahul'),
(103,'Gouthami',8524379162,'gouthami@gmail.com','anantpur','2021-02-03','gouthami'),
(104,'Ishwarya',9256279162,'iswarya@gmail.com','nellore','2021-02-22','ishwarya'),
(105,'Harshitha',7456279162,'harshitha@gmail.com','vijayawada','2020-01-22','harshitha');

delete from user1 where user_id=106;

create table contact(
user_id int,
name varchar(100),
email varchar(100),
phone_no bigint,
message varchar(100),
contact_id int primary key auto_increment,
FOREIGN KEY (user_id) REFERENCES user1(user_id)
);
select * from contact;
drop table contact;

insert into contact(user_id,name,email,phone_no,message)
values (101,'Ankit','ankit@gmail.com',1234,'Message'),
(102,'Rahul','rahul@gmail.com',1235,'Message'),
(103,'Gouthami','gouthami@gmail.com',1236,'Message'),
(104,'Ishwarya','iswarya@gmail.com',1237,'Message'),
(105,'Harshitha','harshitha@gmail.com',1238,'Message');



create table admin(
admin_id int primary key,
name varchar(100),
email varchar(100),
password varchar(100)
);
select * from admin;
select name from admin where name='Ankit';
drop table admin;

insert into admin()
values (1,'Rahul','rahul@gmail.com','pass'),
(2,'Ankit','ankit@gmail.com','pass'),
(3,'Gouthami','gouthami@gmail.com','pass'),
(4,'Ishwarya','iswarya@gmail.com','pass'),
(5,'Harshitha','harshitha@gmail.com','pass');


create table course(
course_id int primary key,
c_name varchar(100),
c_desp varchar(100),
c_fees varchar(100),
c_resource varchar(100)
);
select * from course;
drop table course;

insert into course()
values (111,'JAVA','Programming language',299,'video.mp4'),
(112,'C Programming','Programming language',199,'cprogram.mp4'),
(113,'C++ Programming','Programming language',199,'c++program.mp4');


create table feedback(
user_id int,
name varchar(100),
email varchar(100),
feedbackmessage varchar(100),
f_id int primary key auto_increment,
FOREIGN KEY (user_id) REFERENCES user1(user_id)
);
select * from feedback;
drop table feedback;
delete from feedback where name="Riya";
insert into feedback(user_id,name,email,feedbackmessage)
values (101,'Ankit','ankit@gmail.com','good'),
(105,'Harshitha','harshitha@gmail.com','good');


create table mapping(
id int primary key auto_increment,
name varchar(100),
course_id int,
course_name varchar(100)
);
select * from mapping;
drop table mapping;