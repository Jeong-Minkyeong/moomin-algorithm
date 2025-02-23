import java.util.*;
import java.io.*;

public class Main { // DP 다이나믹 프로그래밍
    static int N;
    static int[] arr;


    public static void main(String[] args) throws IOException {

        // N 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 배열 할당
        arr = new int[N+1];

        dp(1);
        System.out.println(arr[N]);
    }

    public static void dp(int num){
        for(int i = num+1; i<=N; i++){
            arr[i] = arr[i-1]+1;
            if(i % 3 == 0){
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }

            if(i % 2 == 0){
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }
        }
    }
}
