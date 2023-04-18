def solution(s):
    num =[ '1', '0', '2', '3', '4', '5', '6', '7', '8', '9']
    if len(s) == 4 or len(s)==6:
        pass
    else:
        return False
    for i in s:
        if i not in num:
            return False
    return True