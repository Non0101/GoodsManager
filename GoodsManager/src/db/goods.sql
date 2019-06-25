create table goods(
   goods_id              NUMBER(10)                         not null,
   goods_name            VARCHAR2(120)                     not null,
   goods_changjia        VARCHAR2(100)                     not null,
   goods_guige           VARCHAR2(100)                     not null,
   goods_price           NUMBER(38)                        not null,
   goods_picture         VARCHAR2(180)                     not null,
   goods_pihao           VARCHAR2(180)                     not null,
   goods_tiaoma          VARCHAR2(180)                     not null
)

insert into goods values(1,'阿莫西林胶囊','哈药集团制药总厂','0.25g*10s',5,'F://01.jpg','123456','123456789')
insert into goods values(2,'阿莫西林胶囊','哈药集团制药总厂','0.25g*10s',5,'F://01.jpg','123456','123456789')
insert into goods values(3,'阿莫西林胶囊','哈药集团制药总厂','0.25g*10s',5,'F://01.jpg','123456','123456789')
insert into goods values(4,'阿莫西林胶囊','哈药集团制药总厂','0.25g*10s',5,'F://01.jpg','123456','123456789')
insert into goods values(5,'阿莫西林胶囊','哈药集团制药总厂','0.25g*10s',5,'F://01.jpg','123456','123456789')
insert into goods values(6,'阿莫西林胶囊','哈药集团制药总厂','0.25g*10s',5,'F://01.jpg','123456','123456789')

select * from Goods where goods_tiaoma = '123456789'