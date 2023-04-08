from math import gcd

def solution(numer1, denom1, numer2, denom2):
    
    num = (numer1*denom2)+(numer2*denom1)
    denom =  denom1*denom2
    answer = [num, denom]
    
    g = gcd(answer[0], answer[1])
    return [i // g for i in answer]