def func(dungeons, k, visited, count):
    max_count = count
    
    for i in range(len(dungeons)):
        if k >= dungeons[i][0] and visited[i] == 0:
            visited[i] = 1
            max_count = max(max_count, func(dungeons, k-dungeons[i][1], visited, count+1))
            
            visited[i] = 0
    return max_count
            
def solution(k, dungeons):
    visited = [0] * len(dungeons)
    answer = func(dungeons, k, visited, 0)
    return answer
        