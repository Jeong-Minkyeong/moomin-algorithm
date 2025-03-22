select animal_id, name, IF (SEX_UPON_INTAKE LIKE '%Neutered%' or SEX_UPON_INTAKE LIKE '%Spayed%', 'O', 'X') AS '중성화'
from animal_ins
order by animal_id
-- where SEX_UPON_INTAKE LIKE '%Neutered%' or SEX_UPON_INTAKE LIKE '%Spayed%'
