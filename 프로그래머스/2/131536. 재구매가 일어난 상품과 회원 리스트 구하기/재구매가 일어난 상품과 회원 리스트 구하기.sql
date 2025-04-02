-- 코드를 입력하세요
# select i.user_id, i.product_id
# from online_sale i, (select user_id, product_id from online_sale  group by user_id, product_id having count(*) > 1) j
# where i.user_id = j.user_id and i.product_id = j.product_id

select user_id, product_id 
from online_sale 
group by user_id, product_id 
having count(*) > 1
order by user_id, product_id desc
