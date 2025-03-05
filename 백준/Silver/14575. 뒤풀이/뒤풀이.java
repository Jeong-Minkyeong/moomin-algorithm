import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static long L = 0;
    static long R = 0;
    static long[][] arr;
    static long rSum = 0;
    static long lSum = 0;

    public static void main(String[] args) throws IOException {

        // N(사람 수)과 T(총액) 입력받기
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // 사람, L, R 값 입력받기
        arr = new long[N][2];
        // 탐색 범위는 L에서 가장 작은 값에서 ~ R에서 가장 큰 값
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            arr[i] = new long[]{l, r};
            rSum += r;
            lSum += l;
        }

        if(lSum > T || rSum < T){
            System.out.println(-1);
            return;
        }

        // 탐색 범위 설정
        L = 0;
        R = T;

        while(L<=R){
            // 중앙값
            long mid = (L + R) / 2;

            long S = 0;
            for(int i = 0; i<N; i++){
                if(mid < arr[i][0]){
                    S = 0;
                    break;
                }
                S += Math.min(arr[i][1], mid);
            }
            if(S >= T){
                R = mid - 1;
                continue;
            }
            L = mid + 1;
        }
        System.out.println(L);
    }
}
