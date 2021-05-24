select p.name, c.name
from person p join company c
on c.id = p.company_id
where c.id = 5;

select c.name, count(p.name)
from person p join company c
on c.id = p.company_id
group by c.name
limit 1;