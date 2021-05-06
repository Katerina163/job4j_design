create table books(
	id serial primary key,
	name varchar(255),
	price money,
	in_stock boolean
);
insert into books(name, price, in_stock) values ('Little Red Riding Hood', 245.23, true);
update books set in_stock = false;
delete from books;
select * from books;