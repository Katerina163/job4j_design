select p.name
from product p
where p.type_id = 2;

select p.name
from product p
where p.name like '%мороженое%';

select p.name
from product p
where p.expired_date = current_date + interval '1 month';

select p.name, p.price
from product p
order by p.price desc
limit 1;

select t.name, count(t.id)
from product p join type t on t.id = p.type_id
group by t.name;

select p.name
from product p
where p.type_id = 1
or p.type_id = 2;

select t.name, count(t.id)
from product p join type t on t.id = p.type_id
group by t.name
having count(t.id) < 10;

select p.name, t.name
from product p join type t 
on t.id = p.type_id
group by p.name, t.name;