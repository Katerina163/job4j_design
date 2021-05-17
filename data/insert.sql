insert into states(id, status) values(1, 'в процессе');
insert into category (id, name) values(1, 'Активная заявка');
insert into role(id, name) values(1, 'пользователь');
insert into rules(id, rights) values(1, 'комментировать');
insert into users(id, name, surname, role_id) values(1, 'Иван', 'Иванов', 1);
insert into item(id, text, user_id, category_id, states_id) values(1, 'ой', 1, 1, 1);
insert into comments(text, item_id) values('что-то сломалось', 1);
insert into attachs(name_file, item_id) values('файл', 1);
insert into role_rules(role_id, rules_id) values(1, 1);