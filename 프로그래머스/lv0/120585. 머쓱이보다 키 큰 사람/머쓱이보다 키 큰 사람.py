def solution(array, height):
    answer = [ p for p in array if p > height]
    return len(answer)