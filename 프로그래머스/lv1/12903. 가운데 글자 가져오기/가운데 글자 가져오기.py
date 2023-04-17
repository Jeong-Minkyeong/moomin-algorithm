def solution(s):
    answer = len(s)
    return s[ answer // 2] if answer % 2 != 0 else s[answer // 2 -1 :answer // 2+1]