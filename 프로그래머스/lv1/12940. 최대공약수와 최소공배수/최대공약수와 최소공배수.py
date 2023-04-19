import math

def solution(n, m):
    answer = []
    # 최대공약수(gcd)
    answer.append(math.gcd(n,m))
    
    # 최소공배수(lcd)
    i = max(n,m)
    while(1):
        if i % n == 0 and i % m == 0:
            answer.append(i)
            break
        i += 1
    
    return answer