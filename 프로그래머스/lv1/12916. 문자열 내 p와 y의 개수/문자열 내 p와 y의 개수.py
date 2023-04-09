def solution(s):
    answer = s.lower()
    if answer.count('p') == answer.count('y') or (answer.count('p') == 0 and answer.count('y') == 0):
        return True 
    else:
        return False
    