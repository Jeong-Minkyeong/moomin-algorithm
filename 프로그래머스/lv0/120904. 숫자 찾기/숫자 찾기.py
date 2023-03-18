def solution(num, k):
    answer = [ str(num).index(i)+1 for i in str(num) if i == str(k)]
    answer.append(-1)
    return int(answer[0])