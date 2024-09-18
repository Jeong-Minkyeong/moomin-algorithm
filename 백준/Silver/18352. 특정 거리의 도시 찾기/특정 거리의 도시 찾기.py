import heapq

# 최단 경로 알고리즘 구현

def dijkstra(graph, start):

    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    queue = []
    heapq.heappush(queue, [distances[start], start])

    while queue:
        current_distance, current_node = heapq.heappop(queue)

        if distances[current_node] < current_distance:
            continue

        for adjacent, weight in graph[current_node].items():
            distance = current_distance + weight

            if distance < distances[adjacent]:
                distances[adjacent] = distance
                heapq.heappush(queue, [distance, adjacent])

    return distances


# 입력
n, m, k, x = map(int, input().split())
mygraph = {}
answer = -1

# 도로 정보 그래프 생성
for i in range(n):
    mygraph[i+1] = {}

for i in range(m):
    a, b = map(int, input().split())
    mygraph[a][b] = 1


# 경로가 k인 도시를 오름차순으로 출력

city = dijkstra(mygraph, x)
for i, v in city.items():
    if v == k:
        answer += 1
        print(i)

if answer == -1:
    print(answer)