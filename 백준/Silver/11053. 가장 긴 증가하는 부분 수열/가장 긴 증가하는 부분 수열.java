import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] memo;
    static int ans;
    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 수열 입력받기
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색 시작
        memo = new int[N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 0; j<i; j++){
                if (arr[i] <= arr[j]) continue;

                memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }
        // 최댓값 찾기
        for(int m : memo){
            ans = Math.max(ans, m);
        }
        System.out.println(ans);
    }
}
