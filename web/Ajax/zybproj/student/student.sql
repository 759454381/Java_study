
use web;

create table student(
id int(20) primary key auto_increment comment '学生编号',
name varchar(30) not null comment '学生姓名',
pwd varchar(30) not null comment '学生密码',
age int(3) not null comment '学生年龄',
gender char(2) not null comment '学生性别'
)comment '学生表';

drop table student;



insert into student (id,name,pwd,age,gender) values (default,'龙霁芮','123456',28,'女');
insert into student (id,name,pwd,age,gender) values (default,'胡均启','970101',27,'男');
insert into student (id,name,pwd,age,gender) values (default,'万嵘惠','980202',26,'女');
insert into student (id,name,pwd,age,gender) values (default,'吴文澎','991010',25,'男');
insert into student (id,name,pwd,age,gender) values (default,'侯盈格','001122',24,'男');
insert into student (id,name,pwd,age,gender) values (default,'平旭荷','010203',23,'女');

insert into student (id,name,pwd,age,gender) values (default,'汪玄开','112233',23,'男');
insert into student (id,name,pwd,age,gender) values (default,'管寒瑶','443322',60,'女');
insert into student (id,name,pwd,age,gender) values (default,'平茂闻','456456',35,'男');
insert into student (id,name,pwd,age,gender) values (default,'邴驰舒','789789',52,'女');
insert into student (id,name,pwd,age,gender) values (default,'史喜革','556677',33,'男');
insert into student (id,name,pwd,age,gender) values (default,'滕炳帆','112233',42,'男');
insert into student (id,name,pwd,age,gender) values (default,'包润戈','223344',36,'男');
insert into student (id,name,pwd,age,gender) values (default,'温倩贞','774411',34,'女');
insert into student (id,name,pwd,age,gender) values (default,'袁珏一','225588',42,'女');
insert into student (id,name,pwd,age,gender) values (default,'滑芝曼','336699',32,'女');
insert into student (id,name,pwd,age,gender) values (default,'毕桐汝','778899',26,'女');
insert into student (id,name,pwd,age,gender) values (default,'侯阔昌','335577',28,'男');
insert into student (id,name,pwd,age,gender) values (default,'杜娆果','115599',29,'女');
insert into student (id,name,pwd,age,gender) values (default,'喻月晟','884466',30,'男');
insert into student (id,name,pwd,age,gender) values (default,'蓬良嫚','226644',20,'女');
insert into student (id,name,pwd,age,gender) values (default,'范果含','226688',19,'女');
insert into student (id,name,pwd,age,gender) values (default,'顾蒙乐','448866',31,'男');
insert into student (id,name,pwd,age,gender) values (default,'黄童桔','995577',24,'男');
insert into student (id,name,pwd,age,gender) values (default,'郁珑意','995533',27,'女');



select * from student;

delete from student where id=20;





龙霁芮	身份证号码:120101199001019695,出生日期:1990-03-01,性别:女,年龄:20,出生地:天津市 天津市辖区 和平区
胡均启	身份证号码:120101199001011474,出生日期:1990-01-11,性别:男,年龄:23,出生地:天津市 天津市辖区 和平区
贺金习	身份证号码:120101199001015133,出生日期:1990-01-01,性别:男,年龄:25,出生地:天津市 天津市辖区 和平区
万嵘惠	身份证号码:120101199001015539,出生日期:1990-02-21,性别:女,年龄:28,出生地:天津市 天津市辖区 和平区
霍讳青	身份证号码:120101199001014050,出生日期:1990-04-11,性别:男,年龄:29,出生地:天津市 天津市辖区 和平区
万嵘惠	身份证号码:120101199001015715,出生日期:1990-01-01,性别:男,年龄:33,出生地:天津市 天津市辖区 和平区
吴文澎	身份证号码:120101199001019396,出生日期:1990-03-28,性别:男,年龄:30,出生地:天津市 天津市辖区 和平区
解颖旭	身份证号码:120101199001017657,出生日期:1990-06-01,性别:男,年龄:31,出生地:天津市 天津市辖区 和平区
平旭荷	身份证号码:120101199001014499,出生日期:1990-01-21,性别:男,年龄:28,出生地:天津市 天津市辖区 和平区
侯盈格	身份证号码:120101199001018334,出生日期:1990-01-01,性别:女,年龄:26,出生地:天津市 天津市辖区 和平区