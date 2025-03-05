-- 코드를 입력하세요
SELECT f.flavor
from first_half f, ICECREAM_INFO i
where f.flavor = i.flavor and INGREDIENT_TYPE = 'fruit_based'
and total_order >= 3000
order by total_order desc
