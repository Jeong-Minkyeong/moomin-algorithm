import math
def solution(a, b):
    i = 2
    answer = []
    gcd = math.gcd(a, b)
    b = b // gcd
    
    while i <= b:
        if b % i == 0:
            answer.append(i)
            b = b//i
        else:
            i += 1
        
    answer =  list(set(answer))
    for v in answer:
        if v != 2 and v != 5:
            return 2
        else:
            continue
    return 1
    