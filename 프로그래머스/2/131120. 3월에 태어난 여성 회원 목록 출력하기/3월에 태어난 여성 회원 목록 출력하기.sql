-- 코드를 입력하세요
SELECT member_id, member_name, gender, substring(date_of_birth, 1, 10)
from member_profile
where MONTH(date_of_birth) = 3 and gender = 'W' and tlno is not null
order by member_id