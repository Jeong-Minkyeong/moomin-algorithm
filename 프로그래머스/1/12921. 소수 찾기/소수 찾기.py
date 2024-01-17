def is_prime(x):
    for i in range(2, int(x**0.5)+1):
        if x % i == 0:
            return False
    return True

def solution(n):
    answer = 0
    nums = [ i for i in range(2,n+1)]
    for i in nums:
        if is_prime(i):
            answer += 1
    return answer