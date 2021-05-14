create table body(
	id serial primary key,
	name varchar not null
);
create table motor(
	id serial primary key,
	name varchar not null
);
create table transmission(
	id serial primary key,
	name varchar not null
);
create table car(
	id serial primary key,
	name varchar not null,
	body_id int references body(id) not null,
	motor_id int references motor(id) not null,
	transmission_id int references transmission(id) not null
);

insert into body(name) values('седан');
insert into body(name) values('универсал');
insert into body(name) values('кабриолет');
insert into motor(name) values('бензин');
insert into motor(name) values('переменный ток');
insert into motor(name) values('паровой');
insert into transmission(name) values('механическая');
insert into transmission(name) values('автоматическая');
insert into transmission(name) values('вариативная');
insert into car(name, body_id, motor_id, transmission_id) values('Audi', 1, 1, 1);
insert into car(name, body_id, motor_id, transmission_id) values('BMW', 1, 1, 2);
insert into car(name, body_id, motor_id, transmission_id) values('Ford', 1, 2, 1);
insert into car(name, body_id, motor_id, transmission_id) values('Honda', 1, 2, 2);
insert into car(name, body_id, motor_id, transmission_id) values('Hyundai', 2, 1, 1);
insert into car(name, body_id, motor_id, transmission_id) values('Kia', 2, 1, 2);

select c.name as Машина, b.name as Кузов, m.name as Мотор, t.name as Коробка_передач
from car c left join body b on c.body_id = b.id
left join motor m on c.motor_id = m.id
left join transmission t on c.transmission_id = t.id;

select b.name
from body b left join car c on c.body_id = b.id
where c.id is null;

select m.name
from motor m left join car c on c.motor_id = m.id
where c.id is null;

select t.name
from transmission t left join car c on c.transmission_id = t.id
where c.id is null;