def solution(i, j, k):
    answer = [ str(n) for n in range(i, j+1)]
    answer = ''.join(answer)
    return answer.count(str(k))