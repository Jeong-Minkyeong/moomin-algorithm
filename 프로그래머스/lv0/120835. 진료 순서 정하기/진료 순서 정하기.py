def solution(emergency):
    answer = sorted(emergency, reverse = True)
    answer = [(answer.index(i))+1 for i in emergency ]
    return answer