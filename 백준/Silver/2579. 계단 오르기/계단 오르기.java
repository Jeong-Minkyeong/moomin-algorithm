import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] memo;
    static List<Integer> ans =  new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // 계단의 수 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 계단 입력받기
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 탐색 시작 - 처음이후 한계단 밟았을때
        memo = new int[N + 1];

        memo[1] = arr[1];

        if (N >= 2) {
            memo[2] = arr[1] + arr[2];
        }

        dp();
        System.out.println(memo[N]);
        ans.add(memo[N - 1]);
    }

    public static void dp(){
        for(int i = 3; i<=N; i++){
            // 점화식을 3부터 수행함
            // memo[3] = arr[3] + (memo[1] vs memo[0] + arr[2])
            // memo[4] = arr[4] + (memo[2] vs memo[1] + arr[3])
            memo[i] = Math.max(memo[i-2], memo[i-3] + arr[i-1]) + arr[i];
        }
    }
}
