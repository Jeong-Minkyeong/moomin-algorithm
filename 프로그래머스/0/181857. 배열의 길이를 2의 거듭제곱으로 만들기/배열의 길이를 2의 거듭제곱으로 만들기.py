def solution(arr):
    i = 0
    while(1):
        if len(arr) <= (2**i):
            temp = (2**i) - len(arr)
            break
        i += 1
    for i in range(temp):
        arr.append(0)
    return arr