select count(n.fish_name) as fish_count
from fish_info i join fish_name_info n
where i.fish_type = n.fish_type and (n.fish_name = 'BASS' or n.fish_name = 'snapper')