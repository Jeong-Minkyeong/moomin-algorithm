def solution(t, p):
    temp = [ t[i:i+len(p)] for i in range(len(t)) if not i+len(p) > len(t)]
    answer = [ i for i in temp if int(i) <= int(p)]
    return len(answer)