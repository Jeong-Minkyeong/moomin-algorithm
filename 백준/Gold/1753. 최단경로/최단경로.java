import java.util.*;
import java.io.*;


class QNode {
    int next;
    int cost;

    public QNode(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
}

public class Main {

    static int V, E, K;
    static ArrayList<QNode>[] graph;
    static int[] dist;
    static int answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        // - 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        // 그래프 생성
        graph = new ArrayList[V+1];
        for(int i = 1; i<=V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new QNode(v, w));
        }

        // - 탐색 & 정답 출력
        dist = new int[V+1];
        dijkstra(K);

        // - 정답 출력
        sb = new StringBuilder();
        for(int i = 1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<QNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new QNode(start, dist[start]));

        while(!pq.isEmpty()) {
            QNode temp = pq.poll();

            if(temp.cost > dist[temp.next]) continue;

            for(QNode node : graph[temp.next]) {
                // 갱신
                if(dist[node.next] > temp.cost + node.cost) {
                    dist[node.next] = temp.cost + node.cost;
                    pq.add(new QNode(node.next, dist[node.next]));
                }
            }
        }
    }
}