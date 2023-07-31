def solution(strArr):
    answer = [ i.upper() for i in strArr]
    for i in range(0, len(answer), 2):
        answer[i] = answer[i].lower()
    return answer