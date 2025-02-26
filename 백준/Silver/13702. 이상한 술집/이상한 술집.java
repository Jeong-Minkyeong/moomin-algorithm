import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static long mid, left, right;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        left = 1;
        right = arr[N-1];

        while(left <= right){
            mid = (left+right) / 2;

            long ans = 0;
            for(int i = 0; i<N; i++){
                if(arr[i] <= 0) continue;
                ans += arr[i] / mid;
            }

            if(ans < M){
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        System.out.println(right);
    }
}
