def solution(arr):
    answer = 0
    arr.sort()
    
    for i, v in enumerate(arr):
        if i == 0:
            for k in range(v, (v * arr[i+1]) + 1):
                    if k % v == 0 and k % arr[i+1] == 0:
                        answer = k
                        print(k, i)
                        break
        elif i > 1:
            for k in range(min(answer, v), (answer * v) + 1):
                if k % answer == 0 and k % v == 0:
                    answer = k
                    print(k, i)
                    break
    return answer
# (2,6) 8 14
# (2 6 8) 14