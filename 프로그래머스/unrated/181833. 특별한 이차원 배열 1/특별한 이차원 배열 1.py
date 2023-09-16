def solution(n):
    answer = []
    temp = []
    for i in range(n):
        for j in range(n):
            if i == j:
                temp.append(1)
            else:
                temp.append(0)
        answer.append(temp)
        temp = []
    return answer