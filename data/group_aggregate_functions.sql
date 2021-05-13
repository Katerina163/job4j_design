insert into devices(name, price) values('телефон', 29990);
insert into devices(name, price) values('ноутбук', 64990);
insert into devices(name, price) values('планшет', 14990);

insert into people(name) values('Вася');
insert into people(name) values('Надя');
insert into people(name) values('Даша');

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(2, 1);
insert into devices_people(device_id, people_id) values(3, 1);
insert into devices_people(device_id, people_id) values(1, 2);
insert into devices_people(device_id, people_id) values(2, 2);
insert into devices_people(device_id, people_id) values(3, 3);

select avg(devices.price) from devices;

select p.name, avg(d.price) from devices d 
join devices_people dp on d.id = dp.device_id
join people p on p.id = dp.people_id
group by p.name;

select p.name, avg(d.price)
from devices d join devices_people dp on d.id = dp.device_id
join people p on p.id = dp.people_id
group by p.name
having avg(d.price) > 30000;