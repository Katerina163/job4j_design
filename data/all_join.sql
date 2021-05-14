create table departments(
	id serial primary key,
	name varchar not null
);
create table emploees(
	id serial primary key,
	departments_id int references departments(id),
	name varchar not null
);

insert into departments(name) values('Департамент доходов');
insert into departments(name) values('Правовой департамент');
insert into departments(name) values('Административный департамент');
insert into departments(name) values('Департамент финансовой политики');

insert into emploees(name, departments_id) values('Иванов', 1);
insert into emploees(name, departments_id) values('Смирнов', 1);
insert into emploees(name, departments_id) values('Смирнов', 3);
insert into emploees(name, departments_id) values('Кузнецов', 3);
insert into emploees(name, departments_id) values('Попов', 3);
insert into emploees(name, departments_id) values('Васильев', 4);
insert into emploees(name, departments_id) values('Петров', 4);
insert into emploees(name, departments_id) values('Соколов', 4);
insert into emploees(name, departments_id) values('Михайлов', 4);

select d.name, e.name
from departments d left join emploees e
on d.id = e.departments_id;

select d.name, e.name
from departments d right join emploees e
on d.id = e.departments_id;

select d.name, e.name
from departments d full join emploees e
on d.id = e.departments_id;

select d.name, e.name
from departments d left join emploees e
on d.id = e.departments_id
where e.name is null;

select d.name, e.name
from departments d left join emploees e
on d.id = e.departments_id
where e.name like '%ов';

select d.name, e.name
from emploees e right join departments d
on d.id = e.departments_id
where e.name like '%ов';

create table teens(
	id serial primary key,
	name varchar(255)  not null,
	gender char(1) not null
);

insert into teens(name, gender) values('Оксана', 'Ж');
insert into teens(name, gender) values('Олеся', 'Ж');
insert into teens(name, gender) values('Мария', 'Ж');
insert into teens(name, gender) values('Андрей', 'М');
insert into teens(name, gender) values('Артём', 'М');
insert into teens(name, gender) values('Евгений', 'М');

select t.name, te.name
from teens t cross join teens te;