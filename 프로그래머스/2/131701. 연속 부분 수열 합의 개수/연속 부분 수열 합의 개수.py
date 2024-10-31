def solution(elements):
    answer = set()
    size = len(elements)
    elements *= 2
    
    for i in range(1, size):
        for j in range(size):
            temp = elements[j:j+i]
            answer.add(sum(temp))
    return len(answer)+1
