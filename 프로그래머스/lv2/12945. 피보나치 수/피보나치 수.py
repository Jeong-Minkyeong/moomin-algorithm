def solution(n):
    a, b = 0, 1
    temp = a+b
    for i in range(n-2):
        a, b = b, temp
        temp = a + b
    return temp%(1234567)