from heapq import heappush, heappop

def solution(n, k, enemy):
    answer = 0
    heap = []
    
    for i, e in enumerate(enemy):
        heappush(heap, e)
        if len(heap) > k:
            n -= heappop(heap)
        if n < 0:
            return i
        
    answer = len(enemy)
    return answer