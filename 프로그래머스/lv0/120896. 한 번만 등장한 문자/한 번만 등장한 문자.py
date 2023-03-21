def solution(s):
    answer = [i for i in list(s) if s.count(i) <= 1]
    return ''.join(sorted(answer))