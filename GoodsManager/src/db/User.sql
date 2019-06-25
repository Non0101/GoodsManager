 alter table Users
   drop constraint FK_USERS_REFERENCE_MYORDER;
   drop table Users cascade constraints;
   
create table Users(
 username    VARCHAR2(40)      not null,
 userpassword   VARCHAR2(40)   not null
)

insert into Users values('admin','admin');
select * from Users where username = 'admin';