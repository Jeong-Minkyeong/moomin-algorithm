import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] arr;
    static int[] memo;

    public static void main(String[] args) throws IOException {

        // N, K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 가치 입력받기
        arr = new int[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색 시작
        // 0은 1, 만들 수 없으면 -1, Min(memo[현재 값 - 비교값]이 유효하면 + 1)
        memo = new int[K+1];

        // 모두 최댓값으로 set
        for(int i = 1; i<=K; i++){
            memo[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i<=K; i++){
            for(int j = 0; j<N; j++){
                if(i - arr[j] < 0) continue;

                if(memo[i - arr[j]] == Integer.MAX_VALUE) continue;

                memo[i] = Math.min(memo[i], memo[i - arr[j]]+1);
            }
        }
        // 정답
        if(memo[K]+1 < 0){
            System.out.println(-1);
            return;
        }
        System.out.println(memo[K]);
    }
}
