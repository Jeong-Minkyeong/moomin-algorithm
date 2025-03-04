-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE, sum(total_order) as total_order
from FIRST_HALF f, ICECREAM_INFO i
where f.flavor = i.flavor
group by i.ingredient_type
order by total_order