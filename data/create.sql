create table states (
	id serial primary key,
	status varchar(255) not null
);
create table category (
	id serial primary key,
	name varchar(255) not null
);
create table role (
	id serial primary key,
	name varchar(255) not null
);
create table rules (
	id serial primary key,
	rights varchar(255) not null
);
create table users (
	id serial primary key,
	name varchar(255) not null,
	surname varchar(255) not null,
	role_id int references role(id)
);
create table item (
	id serial primary key,
	text varchar not null,
	user_id int references users(id),
	category_id int references category(id),
	states_id int references states(id)
);
create table comments (
	id serial primary key,
	item_id int references item(id),
	text varchar not null
);
create table attachs (
	id serial primary key,
	name_file varchar not null,
	item_id int references item(id)
);
create table role_rules (
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);