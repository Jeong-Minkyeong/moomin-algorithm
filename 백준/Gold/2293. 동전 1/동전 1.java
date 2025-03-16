import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int arr[];
    static int memo[];

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
        
        Arrays.sort(arr);

        // 탐색 시작
        memo = new int[K+1];

        // 초기값 설정
        memo[0] = 1;
        for(int i = 0; i<N; i++){
            for(int j = i; j<=K; j++){
                if(j - arr[i] < 0) continue;
                memo[j] += memo[j - arr[i]];
            }
        }
        System.out.println(memo[K]);
    }
}
