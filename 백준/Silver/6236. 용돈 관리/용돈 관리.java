import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long start, end, mid, max;
    static long[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 M 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 이용할 금액 입력받기
        arr = new long[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        // 탐색 범위 세팅
        start = 1;
        end = max*N;

        // 탐색 시작
        while(start<=end){
            mid = (start + end) / 2;

            long cash = mid;
            int count = 1;
            for(int i =0; i<N; i++){
                if(cash - arr[i] < 0){
                    if(arr[i] > mid){
                        count = Integer.MAX_VALUE;
                        break;
                    }
                    count++;
                    cash = mid - arr[i];
                    continue;
                }
                cash -= arr[i];
            }

           // System.out.println(mid + " " +start + " " + end);

            if(count <= M){
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }
        System.out.println(start);
    }
}
