import math

def solution(n):
    answer = [ n for c in range(1, n+1) if n%c == 0]
    return len(answer)