
create table member(
	mid varchar(30) primary key,
	mname varchar(30) not null,
	mpassword varchar(30) not null,
	mmoney int not null,
	maccount varchar(30) not null,
	mphone varchar(30) not null
);

create table stock(
	spk int primary key,
	sname varchar(100) not null,
	snprice int not null,
	sypriceupdown int not null,
	snpercent number(5,2) default 0.0,
	sntrade int not null,
	sstate int default 0
);

create table have(
	hpk int primary key,
	hmid varchar(30) not null,
	hsname varchar(30) not null,
	hscnt int not null,
	hsbuyprice int not null,
	hsnowprice int not null,
	foreign key (hpk) references stock(spk) on delete cascade
);

create table favorite(
	fpk int primary key,
	spk int not null,
	mid varchar(30) not null,
	foreign key (spk) references stock(spk) on delete cascade,
	foreign key (mid) references member(mid) on delete cascade
);
select * from stock;
drop table member;
drop table stock;
drop table have;
drop table favorite;