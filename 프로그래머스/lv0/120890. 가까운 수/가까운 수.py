def solution(array, n):
    array.sort()
    answer = [abs(n - i) for i in array]
    return array[answer.index(min(answer))]