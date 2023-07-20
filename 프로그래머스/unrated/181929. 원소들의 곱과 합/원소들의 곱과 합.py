import math

def solution(num_list):
    answer = math.prod(num_list)
    return 1 if answer < (sum(num_list)**2) else 0