import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K;
    static int count;
    static int[][] arr;
    static boolean[][] visited;
    static final int[] dx = {-1, 0, 1, 0}; //방향 벡터
    static final int[] dy = {0, 1, 0, -1}; //방향 벡터
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // T, M, N, K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        // T만큼 반복
        for(int t = 0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 배열 초기화
            arr = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                arr[n][m] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void dfs(int y, int x){

        // 시작노드 방문 처리
        visited[y][x] = true;

        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < M && ny >=0 && ny < N && !visited[ny][nx] && arr[ny][nx] == 1){
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }
}
