import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static long left, mid, right;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        // N 과 K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 랜선 입력받기
        arr = new int[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색 시작
        Arrays.sort(arr);
        left = 1;
        right = arr[N-1];

        while(left<=right){
            mid = (left+right) / 2;

            long count = 0;
            for(int i = 0; i<arr.length; i++){
                count += arr[i] / mid;
            }

            if(count >= K){
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        System.out.println(right);
    }
}
