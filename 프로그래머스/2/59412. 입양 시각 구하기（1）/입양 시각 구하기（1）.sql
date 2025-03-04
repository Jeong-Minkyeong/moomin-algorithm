-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(animal_id) 
from animal_outs
group by hour(datetime) 
having hour > 8 and hour < 20
order by hour