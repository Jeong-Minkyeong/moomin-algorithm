select d.dept_id, d.dept_name_en, round(avg(SAL), 0) as AVG_SAL
from HR_DEPARTMENT as d
join HR_EMPLOYEES as e on d.dept_id = e.dept_id
group by d.dept_id
order by avg(SAL) desc