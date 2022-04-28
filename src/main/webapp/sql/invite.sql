
create table member(
	mid varchar(30) primary key,
	mname varchar(30) not null,
	mpassword varchar(30) not null,
	maccount varchar(30) not null,
	mphone varchar(30) not null,
	mmoney int default 0
);

create table stock(
	spk int primary key,
	sname varchar(100) not null,
	snprice int not null,
	snowprice int default 0,
	sypriceupdown int not null,
	snpercent number(5,2) default 0.0,
	sntrade int not null,
	sstate int default 0
);

create table have(
	hpk int primary key,
	mid varchar(30) not null,
	hsname varchar(100) not null,
	hscnt int not null, 
	hsbuyprice int not null,
--	hscnt2 int default 0,,
--	hsbuyprice2 int default 0, 
	hsnowprice int default 0,
--	avg int 
	foreign key (hpk) references stock(spk) on delete cascade,
	foreign key (mid) references member(mid) on delete cascade
);

create table favorite(
	fpk int primary key,
	spk int not null,
	mid varchar(30) not null,
	foreign key (spk) references stock(spk) on delete cascade,
	foreign key (mid) references member(mid) on delete cascade
);
select * from stock;
select * from favorite;
select * from member;
select * from have;
insert into have value(1,'dasol','삼성전자','3','2500','3600');
insert into have values(1,'dasol','삼성전자','3','2500','3500');
select * from have where hmid='dasol'and hpk='1';
insert into favorite values(1,2,'이다솔');
insert into favorite values(2,3,'이다솔');
insert into member(mid,mname,mpassword,maccount,mphone) values(?,?,?,?,?)
insert into member(mid,mname,mpassword,maccount,mphone) values('dasol','이다솔','1234','1234','1234');
insert into stock values('2','삼성',3500,210,20.0,54352,0);
insert into member values('이다솔','이다솔','1234','120555','31548-7685','010-3058-7698')
insert into member values('이다솔','이다솔','1234','31548-7685','010-3058-7698','500000');
select * from member where mid='hong';
update member set mname='이다솔22',mpassword='1234',maccount='38465112',mphone='0703003000' where mid='dasol';
update have hscnt=hscnt+3,hsbuyprice=(hsbuyprice+2500)/hscnt where hpk=
insert into favorite values((select nvl(max(fpk),0)+1 from favorite),'1','이다솔');
delete favorite where fpk=2;

drop table favorite;
drop table have;
drop table stock;
drop table member;


select stock.* from stock join favorite on stock.spk = favorite.spk where fpk=1;
select stock.* from stock join favorite on stock.spk = favorite.spk where mid='이다솔';
select * from member where mid='이다솔';
select * from stock where sname like '%'||'쌍'||'%';

