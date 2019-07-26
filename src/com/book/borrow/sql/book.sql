drop table book;

create table book(
  id varchar(16) constraint book_id_pk primary key constraint book_id_nn not null,
  bookId varchar(16) not null unique ,
  bookName varchar(50) not null,
  author varchar(20) not null,
  bookPublish varchar(50) not null,
  bookPrice number (6,1) not null,
  count number(16) default 0 not null,
  imgUrl varchar(255) default 'src/com/book/borrow/images/defualt.jpg',
  detail varchar(255) default '暂无数据'
);

insert into book(id,bookId,bookName,author,bookPublish,bookPrice,count)
values (1,'B0001','计算机网络','王长征','清华大学出版社',66.6,10);
insert into book(id,bookId,bookName,author,bookPublish,bookPrice,count)
values (2,'B0002','操作系统','王辉','电子工业大学出版社',56.4,10);
insert into book(id,bookId,bookName,author,bookPublish,bookPrice,count)
values (3,'B0003','数据结构','周娟','清华大学出版社',86.0,10);
insert into book(id,bookId,bookName,author,bookPublish,bookPrice,count)
values (4,'B0004','python开发基础','谌勇','电子科技大学出版社',45.8,10);
insert into book(id,bookId,bookName,author,bookPublish,bookPrice,count)
values (5,'B0005','java从入门到精通','王长征','电子科技大学出版社',112.4,10);
insert into book(id,bookId,bookName,author,bookPublish,bookPrice,count)
values (6,'B0006','mysql数据库','魏永丰','电子工业大学出版社',52.2,10);
insert into book(id,bookId,bookName,author,bookPublish,bookPrice,count)
values (7,'B0007','web开发实例','谢剑猛','人民出版社',63.1,10);
commit;