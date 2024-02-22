def solution(players, callings):
    answer = []
    score = {}
    
    for i, v in enumerate(players):
        score[v] = i
    
    for i in callings:
        idx = score[i]
        score[i] -= 1
        score[players[idx-1]] += 1
        players[idx], players[idx-1] = players[idx-1], players[idx]
    return players
        
