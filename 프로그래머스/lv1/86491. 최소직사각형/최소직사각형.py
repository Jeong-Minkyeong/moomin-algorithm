def solution(sizes):
    answer = [ sorted(i) for i in sizes]
    width = [i[0] for i in answer]
    height = [i[1] for i in answer]
    #return answer
    return max(height) * max(width)