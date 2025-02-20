import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] arr;
    static int[][] visited;

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 인접행렬 입력받기
        arr = new ArrayList[N+1];
        visited = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                if (Integer.parseInt(st.nextToken()) == 1){
                    arr[i].add(j);
                    //arr[j].add(i);
                }
            }
        }

        // 탐색 시작
        for(int i = 1; i<=N; i++){
            bfs(i);
        }

        // 정답 출력
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int s) {
        // 큐 준비
        Queue<Integer> q = new LinkedList<>();

        q.add(s);

        while(!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < arr[temp].size(); i++) {
                if (visited[s][arr[temp].get(i)] == 0) {
                    visited[s][arr[temp].get(i)] = 1;
                    q.add(arr[temp].get(i));
                }
            }
        }
    }
}
