def solution(citations):
    answer = []
    citations.sort(reverse =True)
    h = 0
    for v in citations:
        if v > h:
            h += 1
    return h
            
