def solution(my_string, m, c):
    answer = [ my_string[c+i-1] for i in range(0, len(my_string), m)]
    return ''.join(answer)
