def solution(answers):
    user1 = [1, 2, 3, 4, 5]
    user2 = [2, 1, 2, 3, 2, 4, 2, 5]
    user3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    winner = [0,0,0]
    c = 0
    
    for i, v in enumerate(answers):
        if v == user1[i%len(user1)]:
            winner[0] += 1 
        if v == user2[i%len(user2)]:
            winner[1] += 1 
        if v == user3[i%len(user3)]:
            winner[2] += 1 
        
    m = max(winner)
    answer = [i+1 for i, v in enumerate(winner) if v == m]
    return answer