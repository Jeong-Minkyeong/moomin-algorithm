import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, String[]> direction =  new HashMap<>();
    static int N;
    static int[][] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        // - 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방향 정리
        direction.put("W", new String[]{"W", "D"});
        direction.put("H", new String[]{"H", "D"});
        direction.put("D", new String[]{"W", "H", "D"});

        // - 탐색
        dfs(0, 1, "W");


        // - 정답 출력
        System.out.println(answer);


    }

    public static void dfs(int y, int x, String d){

        if(y == N-1 && x == N-1) {
            answer++;
            return;
        }

        String[] temp = direction.get(d);
        for (String s : temp) {
            if (s.equals("W")) {
                if (x >= N - 1 || arr[y][x + 1] == 1) continue;
                dfs(y, x + 1, s);
                continue;
            }

            if (s.equals("H")) {
                if (y >= N - 1 || arr[y + 1][x] == 1) continue;
                dfs(y + 1, x, s);
                continue;
            }

            if (x >= N - 1 || y >= N - 1) continue;
            if (arr[y][x + 1] == 1 || arr[y + 1][x] == 1 || arr[y + 1][x + 1] == 1) continue;
            dfs(y + 1, x + 1, s);
        }
    }
}