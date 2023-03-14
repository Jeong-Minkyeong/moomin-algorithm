def solution(array):
    array.sort()
    answer = array[(len(array)-1)//2]
    return answer