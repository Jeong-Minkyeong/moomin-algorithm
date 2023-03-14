'''divmod : 몫과 나머지를 동시에 구하는 함수'''

def solution(money):
    answer = []
    coffee = {1 : 5500}
    answer.append(money // coffee[1])
    answer.append(money - (answer[0]*coffee[1]))
    return answer