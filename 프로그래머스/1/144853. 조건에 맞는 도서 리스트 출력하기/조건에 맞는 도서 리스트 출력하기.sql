-- 코드를 입력하세요
SELECT book_id, substring(published_date, 1, 10) as published_date
from book
where category = '인문' and YEAR(published_date) = 2021
order by published_date