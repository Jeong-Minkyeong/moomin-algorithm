def solution(arr):
    answer = []
    count = 0
    while(1):
        for i in range(len(arr)):
            if arr[i] >= 50 and arr[i] % 2 == 0:
                answer.append(arr[i] // 2)
            elif arr[i] < 50 and arr[i] % 2 != 0:
                answer.append(arr[i]*2+1)
            else:
                answer.append(arr[i])
        count += 1

        if answer == arr:
            return count-1
        else:
            arr = answer
            answer = []
    return count-1