import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static int[][] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 배열 입력받기
        arr = new int[N][N];
        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색 시작
        dp = new int[N][N];
        dp[0][0] = arr[0][0];
        for(int i = 1; i<N; i++){
            for(int j = 0; j<=i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                    // System.out.println(dp[i][j]);
                    continue;
                }

                if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                    // System.out.println(dp[i][j]);
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j-1] + arr[i][j], dp[i-1][j] + arr[i][j]);
                // System.out.println(dp[i][j]);
            }
        }

        // 정답 도출
        for(int i = 0; i<N; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }

        System.out.println(answer);
    }
}
