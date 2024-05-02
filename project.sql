create database rhd1;
use rhd1;
create table rhd2(
slno int,
rhd_names varchar(50),
address varchar(50),
phone_number int
);
desc rhd2;
insert into rhd2 (slno ,rhd_names ,address ,phone_number)
values(1, 'kathir' ,'dpm', 1234);
select* from rhd2;
drop database rhd1;
drop table rhd2;
