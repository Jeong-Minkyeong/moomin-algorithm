def solution(before, after):
    for c in after:
        if after.count(c) == before.count(c):
            pass
    
        else:
            return 0
    return 1
            