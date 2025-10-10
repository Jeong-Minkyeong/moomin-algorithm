import java.util.*;
import java.io.*;


class Node implements Comparable<Node> {
    int next, cost;

    public Node(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

public class Main {
    static int N, E;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int v1, v2;
    static int INF = 200000000;
    static int v1First = 0;
    static int v2First = 0;
    static int answer;
    public static void main(String[] args) throws IOException {

        // - 준비
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 그래프
            graph[s].add(new Node(n, c));
            graph[n].add(new Node(s, c));
        }

        // 반드시 지나가야 하는 정점
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());


        // - 탐색
        dist = new int[N+1];

        // 1 - v1 - v2 - N 최단경로
        v1First += dijkstra(1, v1);
        v1First += dijkstra(v1, v2);
        v1First += dijkstra(v2, N);

        // 1 - v2 - v1 - N 최단경로
        v2First += dijkstra(1, v2);
        v2First += dijkstra(v2, v1);
        v2First += dijkstra(v1, N);
        
        
        // - 정답 출력
        answer = (v1First >= INF && v2First >= INF) ? -1 : Math.min(v1First, v2First);
        System.out.println(answer);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, dist[start]));

        while(!pq.isEmpty()) {
            Node temp = pq.poll();

            for(Node node : graph[temp.next]) {
                if(dist[node.next] > temp.cost + node.cost) {
                    // 최단 거리 갱신
                    dist[node.next] = temp.cost + node.cost;
                    pq.add(new Node(node.next, dist[node.next]));
                }
            }
        }
        return dist[end];
    }
}