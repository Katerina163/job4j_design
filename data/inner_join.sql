create table dish (
	id serial primary key,
	name varchar not null
);
create table people (
	id serial primary key,
	name varchar(255) not null,
	favorite_dish_id int references dish(id)
);
insert into dish(name) values('борщ');
insert into dish(name) values('жареная картошка');
insert into dish(name) values('омлет');
insert into dish(name) values('шоколад');

insert into people(name, favorite_dish_id) values('Оля', 4);
insert into people(name, favorite_dish_id) values('Коля', 2);
insert into people(name, favorite_dish_id) values('Миша', 3);
insert into people(name, favorite_dish_id) values('Саша', 2);

select people.name as Имя, dish.name as Блюдо
from people join dish
on people.favorite_dish_id = dish.id;

select people.name as Имя, dish.name as Блюдо
from people join dish
on people.favorite_dish_id = dish.id
and people.name like '%ша';

select people.name as Имя, dish.name as Блюдо
from people join dish
on people.favorite_dish_id = dish.id
and people.favorite_dish_id = 2;