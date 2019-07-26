drop table borrowback;
create table borrowback(
  id varchar(16) constraint borrowback_id_pk primary key constraint b_id_nn not null,
  user_userid varchar(16) not null ,
  book_id varchar(16) not null constraint borrowback_bookid_fk references book(id),
  borrowTime date,
  backTime date,
  renew number(6) default 0 constraint borrowback_renew_ck check(renew in(0,1)),
  state number(6) default 0 constraint borrowback_state_ck check(state in(0,1))
);

--删除序列
drop sequence sequence_borrowback_id;

--创建序列
create sequence sequence_borrowback_id
  increment by 1
  start with 1;

--  插入数据
-- insert into borrowback
-- values (1,null,'B0001','计算机网络','王长征','清华大学出版社',66.6,null,null,null,null);
-- insert into borrowback
-- values (2,null,'B0002','操作系统','王辉','电子工业大学出版社',56.4,null,null,null,null);
-- insert into borrowback
-- values (3,null,'B0003','数据结构','周娟','清华大学出版社',86.0,null,null,null,null);
-- insert into borrowback
-- values (4,null,'B0004','python开发基础','谌勇','电子科技大学出版社',45.8,null,null,1,1);
-- insert into borrowback
-- values (5,null,'B0005','java从入门到精通','王长征','电子科技大学出版社',112.4,null,null,null,null);
-- insert into borrowback
-- values (6,null,'B0006','mysql数据库','魏永丰','电子工业大学出版社',52.2,null,null,null,null);
-- insert into borrowback
-- values (7,null,'B0007','web开发实例','谢剑猛','人民出版社',63.1,null,null,null,null);
-- insert into borrowback
-- values (8,null,'B0008','计算机网络','王长征','清华大学出版社',66.6,null,null,null,null);
-- insert into borrowback
-- values (9,null,'B0009','操作系统','王辉','电子工业大学出版社',56.4,null,null,1,1);
-- insert into borrowback
-- values (10,null,'B0010','数据结构','周娟','清华大学出版社',86.0,null,null,null,null);
-- insert into borrowback
-- values (11,null,'B0011','python开发基础','谌勇','电子科技大学出版社',45.8,null,null,null,null);
-- insert into borrowback
-- values (12,null,'B0012','java从入门到精通','王长征','电子科技大学出版社',112.4,null,null,1,1);
-- insert into borrowback
-- values (13,null,'B0013','mysql数据库','魏永丰','电子工业大学出版社',52.2,null,null,1,null);
-- insert into borrowback
-- values (14,null,'B0014','web开发实例','谢剑猛','人民出版社',63.1,null,null,null,1);
-- insert into borrowback
-- values (15,null,'B0015','java从入门到精通','王长征','电子科技大学出版社',112.4,null,null,null,1);
-- insert into borrowback
-- values (16,null,'B0016','mysql数据库','魏永丰','电子工业大学出版社',52.2,null,null,1,1);
-- insert into borrowback
-- values (17,null,'B0017','web开发实例','谢剑猛','人民出版社',63.1,null,null,null,1);
-- insert into borrowback
-- values (18,null,'B0018','java从入门到精通','王长征','电子科技大学出版社',112.4,null,null,null,1);
-- insert into borrowback
-- values (19,null,'B0019','mysql数据库','魏永丰','电子工业大学出版社',52.2,null,null,1,1);
-- insert into borrowback
-- values (20,null,'B0020','web开发实例','谢剑猛','人民出版社',63.1,null,null,null,1);
-- commit ;



--insert into borrowback values(sequence_borrowback_id.nextval,null
--,'B0021','web开发实例','谢剑猛','人民出版社',63.1,null,null,0,0);
--   bookName varchar(50) not null,
--   author varchar(20) not null,
--   bookPublish varchar(50) not null,
--   bookPrice number (6,1) not null,