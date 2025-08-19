import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        // N 입력받기 (집의 수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 색칠 비용 입력받기: red, green, blue
        arr = new int[N][3];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 최소 비용 찾기
        // 직전 앞뒤와 색이 같으면 x
        // red - green or blue, green - red or blue, blue - red or green
        dp = new int[N][3];
        for(int i = 0; i<3; i++){
            dp[0][i] = arr[0][i];
        }

        for(int i = 1; i<N; i++){
            for(int j = 0; j<3; j++){
                if(j == 0){
                    dp[i][j] = Math.min(arr[i][j] + dp[i-1][j+1], arr[i][j] + dp[i-1][j+2]);
                    continue;
                }

                if(j == 1){
                    dp[i][j] = Math.min(arr[i][j] + dp[i-1][j-1], arr[i][j] + dp[i-1][j+1]);
                    continue;
                }

                dp[i][j] = Math.min(arr[i][j] + dp[i-1][j-2], arr[i][j] + dp[i-1][j-1]);
            }
        }

        // 정답 출력
        for(int i = 0; i<3; i++){
            answer = Math.min(answer, dp[N-1][i]);
        }

        System.out.println(answer);
    }
}
