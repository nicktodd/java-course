create table people   (
	id int primary key not null,
	name varchar (50) not null,
	age integer not null,
	gender varchar2 (2) not null
) ;

insert into people values (1, 'Paul', 27, 'M');
insert into people values (2, 'Kirstine', 21, 'F');
insert into people values (3, 'Nick', 30, 'M');
insert into people values (4, 'Sarah', 30, 'M');