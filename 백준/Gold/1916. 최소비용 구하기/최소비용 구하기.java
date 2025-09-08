import java.io.*;
import java.util.*;

public class Main {

    static class City implements Comparable<City> {
        int number;
        int cost;

        public City(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(City c) {
            return Integer.compare(this.cost, c.cost);
        }

    }
    static int N, M;
    static List<City>[] bus;
    static int start, end;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        // N, M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        // BUS 입력받기
        bus = new List[N + 1];
        for(int i = 1; i<N+1; i++){
            bus[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bus[a].add(new City(b, c));
        }

        // start, end 입력받기
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 탐색
        int[] arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[start] = 0;
        visited = new boolean[N + 1];

        PriorityQueue<City> queue = new PriorityQueue<>();
        queue.add(new City(start, 0));

        while (!queue.isEmpty()) {
            City c = queue.poll();

            if (!visited[c.number]) {
                visited[c.number] = true;
                for (City next : bus[c.number]) { // bus의 원소가 list이기 때문
                    if (!visited[next.number] && arr[next.number] > c.cost + next.cost) {
                        arr[next.number] = c.cost + next.cost;
                        queue.add(new City(next.number, arr[next.number]));
                    }
                }
            }
        }

        // 정답 출력
        System.out.println(arr[end]);
    }
}
