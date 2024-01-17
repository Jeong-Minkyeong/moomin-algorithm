from itertools import combinations
import math

def is_prime_number(x):
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True 

def solution(nums):
    answer = 0
    for i in combinations(nums, 3):
        num = sum(i)
        if is_prime_number(num):
            answer += 1
    return answer