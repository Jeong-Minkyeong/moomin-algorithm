-- 코드를 입력하세요
-- select * from CAR_RENTAL_COMPANY_CAR

SELECT car_type, count(options) as cars
from CAR_RENTAL_COMPANY_CAR
where options like '%시트%'
group by car_type
order by car_type