import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] arr;
    static String[][] state;
    static int ans;

    public static void main(String[] args) throws IOException {

        // N, M, R 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 도미노 입력받기
        arr = new int[N+1][M+1];
        state = new String[N+1][M+1];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                state[i][j] = "S";
            }
        }

        // 게임 실행
        while(R-->0) {
            // 공격 입력받기
            st = new StringTokenizer(br.readLine());
            int ay = Integer.parseInt(st.nextToken());
            int ax = Integer.parseInt(st.nextToken());
            String ad = st.nextToken();
            if(ad.equals("E")) attack(ay, ax, 0);
            if(ad.equals("W")) attack(ay, ax, 2);
            if(ad.equals("S")) attack(ay, ax, 1);
            if(ad.equals("N")) attack(ay, ax, 3);

            // 수비 입력받기
            st = new StringTokenizer(br.readLine());
            defence(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 도미노 상태 출력
        System.out.println(ans++);
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 공격: 도미노 판 쓰러뜨리기
    // bfs
    public static void attack(int y, int x, int d) {
        // Queue 준비
        Queue<int[]> q = new LinkedList<>();

        // Queue 삽입
        q.add(new int[]{y, x});

        // 도미노 넘어짐
        state[y][x] = "F";
        ans++;

        // 탐색
        while(!q.isEmpty()){
            int[] temp = q.poll();

            int ny = temp[0];
            int nx = temp[1];
            // 자기 자신을 포함한 높이만큼 쓰러짐
            for(int i = 1; i<arr[temp[0]][temp[1]]; i++) {

                ny += dy[d];
                nx += dx[d];

                if (ny < 1 || nx < 1 || ny > N || nx > M) {
                    continue;
                }

                if (state[ny][nx].equals("F")) continue;

                ans++;
                state[ny][nx] = "F";
                q.add(new int[]{ny, nx});
            }
        }
    }

    // 수비: 도미노 하나 세우기
    public static void defence(int y, int x){
        state[y][x] = "S";
    }
}
