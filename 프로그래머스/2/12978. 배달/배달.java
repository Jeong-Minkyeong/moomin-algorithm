import java.util.*;

class Node {
    int num;
    int cost;
    
    public Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    } 
}

class Solution {
    static List<Node>[] graph;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        // - 준비
        int answer = 0;

        // 그래프 생성
        graph = new List[N+1];
        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<Node>();
        }
        
        for(int[] r : road){
            int start = r[0];
            int end = r[1];
            int cost = r[2];
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }
        
        // - 탐색
        dist = new int[N+1];
        dijkstra(1);
        
        
        // - 정답 출력 
        for(int i = 1; i<=N; i++){
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
    
    public void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            
            if(temp.cost > dist[temp.num]) continue;
            
            for(Node node : graph[temp.num]){
                if(dist[node.num] > dist[temp.num] + node.cost){
                    dist[node.num] = dist[temp.num] + node.cost;
                    pq.add(new Node(node.num, dist[node.num]));
                }
            }
        }
    }
}

// road는 양방향
// 1번 마을이 루트임