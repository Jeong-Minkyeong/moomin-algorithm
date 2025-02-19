import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {-1, 0, 1, 0};
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        // (N, M) 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 입력받기
        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder(st.nextToken());
            for(int j = 1; j<=M; j++){
                arr[i][j] = Integer.parseInt(sb.substring(j-1, j));
            }
        }

        // 탐색 시작
        bfs(1, 1);

        // 정답
        System.out.println(arr[N][M]);
    }

    public static void bfs(int y, int x){

        // Q 준비
        Queue<int[]> q = new LinkedList<>();

        // 시작 노드 방문처리 및 queue에 삽입
        visited[y][x] = true;
        q.add(new int[]{y, x});

        // 인접 구간 확인하기
        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i = 0; i<4; i++){
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];

                if(ny > 0 && ny <= N && nx > 0 && nx <= M && arr[ny][nx] == 1 && !visited[ny][nx]){
                    arr[ny][nx] = arr[temp[0]][temp[1]] + 1;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
