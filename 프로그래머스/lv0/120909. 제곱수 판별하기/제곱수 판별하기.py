def solution(n):
    return (1 if n/(n**(1/2)) == int(n**(1/2)) else 2)