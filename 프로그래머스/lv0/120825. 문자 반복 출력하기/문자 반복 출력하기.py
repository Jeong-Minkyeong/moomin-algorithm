def solution(my_string, n):
    answer = [ w*n for w in my_string ]
    answer = ''.join(answer)
    return answer