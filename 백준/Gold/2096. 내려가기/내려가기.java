import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp1;
    static int[][] dp2;
    static int highScore = 0;
    static int lowScore = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // - 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dp1 = new int[2][3];
        dp2 = new int[2][3];

        // - 탐색
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            // dp 갱신
            if(i != 0) {
                for (int k = 0; k<3; k++) {
                    dp1[0][k] = dp1[1][k];
                    dp2[0][k] = dp2[1][k];
                }
            }

            for(int j = 0; j<3; j++){
                int n = Integer.parseInt(st.nextToken());

                // 시작점 준비
                if(i == 0) {
                    dp1[1][j] = n;
                    dp2[1][j] = n;
                    continue;
                }

                // 가장 왼쪽
                if(j == 0){
                    dp1[1][j] = n + Math.max(dp1[0][j+1], dp1[0][j]);
                    dp2[1][j] = n + Math.min(dp2[0][j+1], dp2[0][j]);
                    continue;
                }

                // 가장 오른쪽
                if(j == 2) {
                    dp1[1][j] = n + Math.max(dp1[0][j-1], dp1[0][j]);
                    dp2[1][j] = n + Math.min(dp2[0][j-1], dp2[0][j]);
                    continue;
                }

                dp1[1][j] = n + Math.max(Math.max(dp1[0][j-1], dp1[0][j]), dp1[0][j+1]);
                dp2[1][j] = n + Math.min(Math.min(dp2[0][j-1], dp2[0][j]), dp2[0][j+1]);

            }
        }

        // - 정답 출력
        for(int i = 0; i<3; i++){
            highScore = Math.max(highScore, dp1[1][i]);
            lowScore = Math.min(lowScore, dp2[1][i]);
        }
        System.out.println(highScore + " " + lowScore);
    }
}
