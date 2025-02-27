import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long left, mid, right;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 입력받기
        N = Integer.parseInt(st.nextToken());

        // 지방 예산 입력받기
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // M 입력받기
        M = Integer.parseInt(br.readLine());

        // 탐색 시작
        Arrays.sort(arr);

        left = 1;
        right = arr[N-1];

        while(left<=right){
            mid = (left+right) / 2;

            long budget = 0;
            for(int i = 0; i<N; i++) {
                budget += arr[i] > mid ? mid : arr[i];
            }

            if(budget > M){
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        System.out.println(right);
    }
}

