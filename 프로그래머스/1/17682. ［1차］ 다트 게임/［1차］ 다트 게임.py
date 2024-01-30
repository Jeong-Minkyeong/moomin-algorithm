def solution(dartResult):
    dart_stack = []
    temp = ''
    
    for i in dartResult:
        if i.isdigit():
            if temp.isdigit():
                dart_stack.pop()
                dart_stack.append(10)
            else:
                dart_stack.append(int(i))
        else:
            if i == 'D':
                dart_stack[-1] **= 2
                
            if i == 'T':
                dart_stack[-1] **= 3
                
            if i == '#':
                dart_stack[-1] *= (-1)
                
            if i == '*':
                if len(dart_stack) == 1:
                    dart_stack[-1] *= 2
                else:
                    dart_stack[-1] *= 2
                    dart_stack[-2] *= 2
        temp = i
                    
    return sum(dart_stack)