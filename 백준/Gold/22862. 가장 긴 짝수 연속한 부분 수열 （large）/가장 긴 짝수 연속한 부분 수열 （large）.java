import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int even;
    static int odd;
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws IOException {

        // N, K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 수열 입력받기
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색
        int start = 0;
        int end = 0;
        while(end < N) {
            // System.out.println(ans + ": " + start + " " + end);
            // System.out.println(even + " " + odd);

            // 짝수일때
            if(arr[end] % 2 == 0){
                even++;
                ans = Math.max(ans, even);
                end++;
                continue;
            }

            // 홀수일때
            if(arr[end] % 2 != 0) {
                ans = Math.max(ans, even);
                odd++;
            }

            // 홀수의 갯수가 K 이상일때
            if(odd > K){
                while(odd > K){
                    if(arr[start] % 2 == 0){
                        even--;
                        start++;
                        continue;
                    }
                    odd--;
                    start++;
                }
            }
            end++;
        }
        System.out.println(ans);
    }
}