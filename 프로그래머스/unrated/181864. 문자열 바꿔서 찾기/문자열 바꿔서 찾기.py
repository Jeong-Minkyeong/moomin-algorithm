def solution(myString, pat):
    result = []
    for i in myString:
        if i ==  "A":
            result.append("B")
        elif i == "B":
            result.append("A")
    
    answer = ''.join(result)
    return 1 if pat in answer else 0