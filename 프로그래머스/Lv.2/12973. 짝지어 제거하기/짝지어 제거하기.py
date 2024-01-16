def solution(s):
    # stack을 활용!
    stack = []
    for i in s:
        if len(stack) == 0:
            stack.append(i)
        else:
            if i == stack[-1]:
                stack.pop()
            else:
                stack.append(i)
            
    return 1 if len(stack) == 0 else 0
        
        
        
    