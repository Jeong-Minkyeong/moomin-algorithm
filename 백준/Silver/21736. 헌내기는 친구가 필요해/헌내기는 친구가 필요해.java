import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};
    static int N, M;
    static int ans;
    static String[][] arr;
    static boolean[][] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{

        // N, M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 캠퍼스 입력받기
        arr = new String[N][M];
        visited = new boolean[N][M];

        // 도연이 위치 파악
        int[] d = new int[2];
        for(int i = 0; i<N; i++){
            sb = new StringBuilder(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = sb.substring(j, j+1);
                if(arr[i][j].equals("I")){
                    d = new int[]{i, j};
                }
            }
        }
        
        // 친구 탐색 시작
        bfs(d[0], d[1]);

        // 정답 출력
        if(ans == 0){
            System.out.println("TT");
            return;
        }
        System.out.println(ans);
    }
    
    public static void bfs(int n, int m){
        Queue<int[]> q = new LinkedList<>();

        // 처음 방문 처리
        visited[n][m] = true;
        q.add(new int[]{n, m});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i = 0; i<4; i++){
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < M && !arr[ny][nx].equals("X") && !visited[ny][nx]){
                    if(arr[ny][nx].equals("P")){
                        ans++;
                    }
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
