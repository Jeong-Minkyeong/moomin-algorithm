select count(f.fish_name) fish_count, f.fish_name
from (select i.id, n.fish_name
from fish_info i join FISH_NAME_INFO n
where i.fish_type = n.fish_type) f
group by f.fish_name
order by count(f.fish_name) desc