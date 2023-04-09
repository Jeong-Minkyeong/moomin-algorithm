def solution(num, total):
    answer = 0
    for i in range(1, num):
        answer += i
    answer = (total-answer)//num
    return [i for i in range(answer, answer+num) ]