def solution(left, right):
    answer = [] 
    result = 0
    for i in range(left, right+1):
        arr = [ n for n in range(1, i+1) if i % n ==0 ]
        answer.append(arr)
    answer = [len(i) for i in answer]
    for i in answer:
        if i % 2 == 0:
            result += left
        else:
            result -= left
        left += 1
        
    return result