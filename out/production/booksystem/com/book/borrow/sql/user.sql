drop table l_user;

create table l_user(
	id varchar2(10) constraint l_user_id_pk primary key,
	name varchar2(10) constraint l_user_name_nn not null,
	userid varchar2(12) constraint l_user_userid_nn not null
	constraint l_user_userid_un unique,
	password varchar2(15) constraint l_user_password_nn not null,
	gender char(5) constraint l_user_gender_ck check(gender in('男','女')),
	age number(2),
	phone char(11) constraint l_user_phone_un unique,
	inclass varchar2(10)
);

insert into l_user
values (1,'张三','20190712001','1234','男',18,'18870804523','软工7班');

commit ;