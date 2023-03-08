'''def solution(n):
    return sum([i for i in range(2, n + 1, 2)])'''

def solution(n):
    sum = 0
    if n%2 == 0:
        for c in range(n//2):
            sum += n
            n -= 2
            
    else:
        n = n-1
        for c in range(n//2):
            sum += n
            n -= 2
    return sum