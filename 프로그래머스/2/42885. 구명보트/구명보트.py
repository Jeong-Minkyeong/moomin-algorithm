from collections import deque

def solution(people, limit):
    people.sort(reverse=True)
    people_d = deque(people)
    answer = 0
    
    while(len(people_d) > 1):
        if (people_d[0] + people_d[-1]) <= limit:
            people_d.pop()
            people_d.popleft()
            answer += 1
            
        else:
            people_d.popleft()
            answer += 1
            
    return answer + len(list(people_d))
    