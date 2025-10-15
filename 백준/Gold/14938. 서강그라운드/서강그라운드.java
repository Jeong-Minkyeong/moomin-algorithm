import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int data;
        int cost;

        public Node(int data, int cost) {
            this.data = data;
            this.cost = cost;
        }
    }

    static int N, M, R;
    static ArrayList<Node>[] graph;
    static int[] items;
    static int[] dist;
    static int answer;

    public static void main(String[] args) throws IOException {

        // - 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 아이템 받기
        items = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        // 그래프 만들기 (양방향 그래프)
        graph = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i<=R; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(d, w));
            graph[d].add(new Node(s, w));
        }

        // - 탐색
        dist = new int[N+1];
        for(int i = 1; i<=N; i++){
            // 최단 거리 구하기
            dijkstra(i);

            // 아이템 수집이 가능한지 구하기
            int item = 0;
            for(int j = 1; j<=N; j++){
                if(dist[j] > M) continue;
                item += items[j];
            }
            answer = Math.max(answer, item);
        }

        // - 출력
        System.out.println(answer);

    }

    public static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, dist[start]));

        while(!pq.isEmpty()){
            Node temp = pq.poll();
            
            if(temp.cost > dist[temp.data]) continue;

            for(Node node : graph[temp.data]) {
                if(dist[node.data] > temp.cost + node.cost){
                    dist[node.data] = temp.cost + node.cost;
                    pq.add(new Node(node.data, dist[node.data]));
                }
            }
        }
    }
}