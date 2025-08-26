import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] x = {-1, 1, 2};
    static int[] visited;
    public static void main(String[] args) throws IOException {

        // N, K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 탐색
        // 1. 수빈 >= 동생 이라면 무조건 작아져야 함
        if(N >= K){
            System.out.println(N-K);
            return;
        }

        // 2. 수빈 < 동생
        System.out.println(bfs(N));
    }

    public static int bfs(int n) {
        // 큐 준비
        visited = new int[100001];
        Queue<int[]> q = new LinkedList<>();

        // 큐에 값 삽입
        q.add(new int[]{n, 0});

        // 탐색
        while(!q.isEmpty()) {
            // 값 꺼내기
            int[] nx = q.poll();
            for(int i = 0; i<x.length; i++){
                int temp;
                if(i < 2) {
                    temp = nx[0] + x[i];
                    if (temp == K) {
                        return nx[1]+1;
                    }

                    if(temp < 0 || temp >= 100001 || (visited[temp] != 0 && visited[temp] < nx[1])) continue;
                    q.add(new int[]{temp, nx[1]+1});
                    visited[temp] = nx[1];
                    continue;
                }

                temp = nx[0] * x[i];
                if(temp == K) {
                    return nx[1]+1;
                }

                if(temp >= 100001 || (visited[temp] != 0 && visited[temp] < nx[1])) continue;
                q.add(new int[]{temp, nx[1]+1});
                visited[temp] = nx[1];
            }
        }
        return -1;
    }
}
