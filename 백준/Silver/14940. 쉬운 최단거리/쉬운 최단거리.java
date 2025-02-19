import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int[][] arr;
    static int[] goal = new int[2];
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        // N과 M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 지도 입력받기
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    goal[0] = i;
                    goal[1] = j;
                    arr[i][j] = 0;
                }
            }
        }
        // 탐색 시작
        bfs(goal[0], goal[1]);

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    arr[i][j] = -1;
                }
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int y, int x){

        Queue<int[]> q = new LinkedList<>();

        visited[y][x] = true;
        q.add(new int[]{y, x});

        while(!q.isEmpty()) {
            int[] xy = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = xy[0] + dy[i];
                int nx = xy[1] + dx[i];

                if(ny < N && 0 <= ny && nx < M && 0 <= nx && arr[ny][nx] == 1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    arr[ny][nx] = arr[xy[0]][xy[1]] + 1;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
