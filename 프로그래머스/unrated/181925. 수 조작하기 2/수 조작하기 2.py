def solution(numLog):
    temp = numLog[0]
    answer = []
    for i in range(1, len(numLog)):
        if numLog[i] - temp == 1:
            answer.append('w')
            temp = numLog[i]
        elif numLog[i] - temp == -1:
            answer.append('s')
            temp = numLog[i]
        elif numLog[i] - temp == 10:
            answer.append('d')
            temp = numLog[i]
        elif numLog[i] - temp == -10:
            answer.append('a')
            temp = numLog[i]        
    return ''.join(answer)