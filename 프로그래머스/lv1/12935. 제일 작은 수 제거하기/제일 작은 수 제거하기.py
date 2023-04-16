def solution(arr):
    arr_min = arr.index(min(arr))
    arr.pop(arr_min)
    return arr if arr != [] else [-1]