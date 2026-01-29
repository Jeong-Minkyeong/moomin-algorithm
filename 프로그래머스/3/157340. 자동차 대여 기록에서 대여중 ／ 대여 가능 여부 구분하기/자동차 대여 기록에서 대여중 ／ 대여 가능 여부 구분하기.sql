select c2.car_id as "CAR_ID", 
    (case
        when c1.car_id is null then "대여 가능"
        else "대여중" 
    end) as "AVAILABILITY"
from (select h.car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    where h.start_date <= "2022-10-16" and h.end_date >= "2022-10-16")
    as c1 right join CAR_RENTAL_COMPANY_RENTAL_HISTORY as c2 on c1.car_id = c2.car_id
group by c2.car_id
order by c2.car_id desc
