create table users(
	id serial primary key,
	name varchar not null
);
create table meetings(
	id serial primary key,
	name varchar not null
);
create table users_meetings(
	id serial primary key,
	name varchar check(name = 'отклонено' or name = 'подтверждено'),
	users_id int references users(id),
	meetings_id int references meetings(id)
);

insert into users(name) values('Иван');
insert into users(name) values('Маша');
insert into users(name) values('Саша');

insert into meetings(name) values('Фестиваль цветов');
insert into meetings(name) values('Родительское собрание');
insert into meetings(name) values('Евровидение');

insert into users_meetings(name, users_id, meetings_id) values('подтверждено', 1, 1);
insert into users_meetings(name, users_id, meetings_id) values('подтверждено', 1, 2);
insert into users_meetings(name, users_id, meetings_id) values('отклонено', 1, 3);
insert into users_meetings(name, users_id, meetings_id) values('подтверждено', 2, 1);
insert into users_meetings(name, users_id, meetings_id) values('отклонено', 2, 2);
insert into users_meetings(name, users_id, meetings_id) values('отклонено', 2, 3);
insert into users_meetings(name, users_id, meetings_id) values('отклонено', 3, 1);
insert into users_meetings(name, users_id, meetings_id) values('отклонено', 3, 2);
insert into users_meetings(name, users_id, meetings_id) values('отклонено', 3, 3);

select m.name, count(us.id)
from meetings m join users_meetings um
on m.id = um.meetings_id
where us.name = 'подтверждено'
group by m.name;

select m.name from meetings m left join users_meetings um on m.id = um.meetings_id
except
select m.name from meetings m left join users_meetings um on m.id = um.meetings_id
where um.name = 'подтверждено';