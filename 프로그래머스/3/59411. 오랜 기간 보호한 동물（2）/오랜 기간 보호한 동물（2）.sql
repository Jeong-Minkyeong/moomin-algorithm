SELECT o.animal_id, o.name
FROM ANIMAL_OUTS as o
INNER JOIN ANIMAL_INS as i on o.animal_id = i.animal_id
order by o.datetime - i.datetime desc
limit 2

-- 보호 기간이 길다는 것은 out date - in data