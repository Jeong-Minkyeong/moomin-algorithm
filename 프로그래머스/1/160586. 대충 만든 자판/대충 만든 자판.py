def solution(keymap, targets):
    keyboard = {}
    answer = [ 0 for i in range(len(targets)) ]
    for km in keymap:
        for i, v in enumerate(km):
            if v in keyboard:
                keyboard[v] = min(keyboard[v], (i+1))
            else:
                keyboard[v] = (i+1)
    for i, v in enumerate(targets):
        for t in v:
            if t not in keyboard:
                answer[i] = -1
                break
            answer[i] += keyboard[t]
                        
    return answer