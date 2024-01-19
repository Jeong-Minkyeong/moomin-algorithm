def solution(n, m, section):
    count = 0
    section.sort()
    paint = m
    
    for i in range(len(section)-1):
        if paint == 0:
            count += 1
            paint = m
            continue
    
        if (section[i+1] - section[i]) >= paint:
            count += 1
            paint = m
            continue
                
        paint -= (section[i+1] - section[i])
    return count+1