insert into states(status) values('в процессе');
insert into category (name) values('Активная заявка');
insert into role(name) values('пользователь');
insert into rules(rights) values('комментировать');
insert into comments(text) values('что-то сломалось');
insert into users(name, surname, role_id) values('Иван', 'Иванов', 1);
insert into item(text, user_id, category_id, states_id) values('ой', 1, 1, 1);
insert into attachs(name_file, item_id) values('файл', 1);
insert into role_rules(role_id, rules_id) values(1, 1);