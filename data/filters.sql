select p.name
from product p join type t on p.type_id = t.id
where t.name like 'сыр';

select p.name
from product p
where p.name like '%мороженое%';

select p.name, p.expired_date
from product p
where date_part('month', p.expired_date) = date_part('month', now() + interval '1 month');

select p.name, p.price
from product p
order by p.price desc
limit 1;

select t.name, count(t.id)
from product p join type t on t.id = p.type_id
group by t.name;

select p.name
from product p join type t on t.id = p.type_id
where t.name like 'сыр'
or t.name like 'молоко';

select t.name, count(t.id)
from product p join type t on t.id = p.type_id
group by t.name
having count(t.id) < 10;

select p.name, t.name
from product p join type t 
on t.id = p.type_id
group by p.name, t.name;