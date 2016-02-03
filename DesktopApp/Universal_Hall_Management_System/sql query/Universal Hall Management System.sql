create  user UHMS 
identified  by uhms
default tablespace system
temporary tablespace temp;

grant CREATE SESSION to "UHMS"; ----connection create----
grant EXP_FULL_DATABASE to "UHMS";     ---- no access--------
grant UNLIMITED TABLESPACE to "UHMS";  --- -granting table space----
grant create sequence to "UHMS";  

commit;


CREATE TABLE users(                 --table for users according to prevelages
id NUMBER(9) NOT NULL PRIMARY KEY,
full_name VARCHAR(50) NOT NULL,
user_name VARCHAR(20) NOT NULL UNIQUE,
password VARCHAR(20) NOT NULL,
user_type number(10) NOT NULL CHECK (user_type BETWEEN 1 AND 5)
);
--drop table users;
INSERT INTO users VALUES(1,'ADMINISTRATOR','admin','admin',1);
select *from users;
INSERT INTO users VALUES(2,'Tahmid Hossain','olee','olee',1);
INSERT INTO users VALUES(3,'Moshiur Rahman','mmrs','mmrs',1);
INSERT INTO users VALUES(4,'Rahman Miah','rahman.miah','a',2);


CREATE TABLE student_info 
(id int,
student_name varchar(60) NOT NULL,
student_dept varchar(10) NOT NULL,
student_session varchar(15) NOT NULL,
student_phone varchar(15) NOT NULL UNIQUE, 
student_email varchar(60) UNIQUE,
PRIMARY KEY (id)
);

--drop table student_info;
CREATE TABLE gardian_info
(
id int PRIMARY KEY REFERENCES student_info(id),
gardian_name varchar(60) NOT NULL,
gardian_email varchar(60) NOT NULL,
gardian_relation varchar(20) NOT NULL,
gardian_phone varchar(15) NOT NULL
);
--drop table gardian_info;

CREATE TABLE hall_floor_info
(
floor number(5),
one_stu number(10),
two_stu number(10),
three_stu number(10),
four_stu number(10)
);
--drop table hall_floor_info;
CREATE TABLE room_status
(
room_no number(20) NOT NULL,
room_capacity number(3) NOT NULL,
room_allocated number(3) DEFAULT 0 
);

--drop table room_status;

--table tracking student check-in-out
CREATE TABLE check_in_out (
id int NOT NULL,
day_time TIMESTAMP,
ttype NUMBER(1) NOT NULL
);

insert into check_in_out VALUES(
2012331049,
CURRENT_TIMESTAMP,
0   --insert changing the value to 0 or 1
);

commit;
--drop table check_in_out;
--test query
--select*from check_in_out;
--select max(day_time) from check_in_out where ttype=0;
--select max(day_time) from check_in_out where ttype=1;
--select ttype from check_in_out where day_time = (select max(day_time) from check_in_out where id=2012331049);
