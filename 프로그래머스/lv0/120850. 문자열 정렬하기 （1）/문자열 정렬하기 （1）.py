import re

def solution(my_string):
    answer = re.sub('[^0-9]', '', my_string)

    return sorted(list(map(int, answer)))
    