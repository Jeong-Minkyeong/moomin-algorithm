'''def solution(s1, s2):
    return len(set(s1)&set(s2))'''

def solution(s1, s2):
    answer = [ w for w in s1 if w in s2]
    return len(answer)