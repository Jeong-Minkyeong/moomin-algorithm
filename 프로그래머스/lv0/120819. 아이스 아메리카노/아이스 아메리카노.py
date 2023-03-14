def solution(money):
    answer = []
    coffee = {1 : 5500}
    answer.append(money // coffee[1])
    answer.append(money - (answer[0]*coffee[1]))
    return answer