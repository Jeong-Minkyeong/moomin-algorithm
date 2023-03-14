import re

def solution(my_string):
    my_string = re.sub(r'[^0-9]', '', my_string)
    return sum(list(map(int, my_string)))