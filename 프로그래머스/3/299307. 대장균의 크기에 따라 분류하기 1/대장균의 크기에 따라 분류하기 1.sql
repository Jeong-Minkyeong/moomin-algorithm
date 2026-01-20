select e.id as "ID",
    (case
        when e.size_of_colony <= 100 then "LOW"
        when e.size_of_colony > 100 and e.size_of_colony <= 1000 then "MEDIUM"
        ELSE "HIGH"
    end) as "SIZE"
from ECOLI_DATA e
order by e.id
