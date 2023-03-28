import math

def solution(balls, share):
    answer1 = [n for n in range(1, balls+1)]
    answer2 = sorted(answer1, reverse = True)
    return   math.prod(answer2[:share]) // math.prod(answer1[:share]) 