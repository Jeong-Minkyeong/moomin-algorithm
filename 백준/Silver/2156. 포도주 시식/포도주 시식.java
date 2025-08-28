import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static int ans = 0;

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 포도주 입력받기
        arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 탐색
        if(N == 1) {
            System.out.println(arr[0]);
            return;
        }

        if(N == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }

        if(N == 3) {
            System.out.println(Math.max(arr[0] + arr[2], Math.max(arr[1] + arr[2], arr[0] + arr[1])));
            return;
        }

        if(N == 4){
            System.out.println(Math.max(arr[0] + arr[1] + arr[3], arr[0] + arr[2] + arr[3]));
            return;
        }

        // 현재 위치: 한다리 건너온 값 vs 직전 값
        dp = new int[N];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0] + arr[2], Math.max(arr[1] + arr[2], arr[0] + arr[1]));
        dp[3] = Math.max(arr[0] + arr[1] + arr[3], arr[0] + arr[2] + arr[3]);

        for(int i = 4; i<N; i++){
            // 점화식 정리하기
            dp[i] = arr[i] + Math.max(Math.max(dp[i-2], dp[i-3] + arr[i-1]), dp[i-4] + arr[i-1]);
        }

        // 정답 출력
        for(int i = 0; i<N; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
