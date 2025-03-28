select sum(score) as score, e.emp_no, e.emp_name, e.position, e.email
from hr_employees e join hr_grade g
where e.emp_no = g.emp_no
group by e.emp_no
order by score desc
limit 1