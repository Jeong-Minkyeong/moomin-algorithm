def solution(progresses, speeds):
    answer = []
    deploy = []
    count = 0
    
    for i in range(len(progresses)):
        rest = (100-progresses[i]) % speeds[i] 
        progress = (100-progresses[i]) // speeds[i] 
        if rest == 0:
            deploy.append(progress)
            continue
        deploy.append(progress+1)
    
    while(len(deploy) > 0):
        count = 0
        
        for i in range(len(deploy)):
            deploy[i] -= 1
            
        while(len(deploy) > 0 and deploy[0] <= 0):
            deploy.pop(0)
            count += 1
        if count != 0:
            answer.append(count)
    return answer