select round(avg(case 
           when length is null then 10
           when length <= 10 then 10
           when length > 10 then length
           end), 2) as average_length
from fish_info

