def solution(s):
    answer = s.split()
    result = [int(i) for i in answer]
    s_min = str(min(result))
    s_max = str(max(result))
    return s_min + ' ' + s_max