import re

def solution(new_id):
    answer = ''
    new_id_1 = new_id.lower()
    new_id_2 = re.sub(r"[^0-9a-zA-Z-_.]", "", new_id_1)
    new_id_3 = new_id_2.replace('.', ' ').strip()
    new_id_4 = new_id_3.split(' ')
    new_id_4 = [ i for i in new_id_4 if i != ""]
    new_id_4 = '.'.join(new_id_4)
    if len(new_id_4) == 0:
        new_id_4 = "a"
        
    if len(new_id_4) > 15:
        new_id_4 = new_id_4[:15]
    
    if new_id_4[-1] == '.':
        new_id_4 = new_id_4[:-1]
    
    if len(new_id_4) < 3:
        new_id_4 +=  (3 - len(new_id_4)) * new_id_4[-1]
    return new_id_4