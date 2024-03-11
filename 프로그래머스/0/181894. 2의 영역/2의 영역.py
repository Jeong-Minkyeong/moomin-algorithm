def solution(arr):
    start, end = -1, -1
    for i, v in enumerate(arr):
        if start == -1 and v == 2:
            start = i
            end = i + 1
            print(start, end)
        elif start != -1 and v == 2:
            end = i + 1
    return [-1] if start == -1 and end == -1 else arr[start:end] 