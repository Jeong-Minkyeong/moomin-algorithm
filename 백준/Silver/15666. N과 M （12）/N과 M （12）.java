import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 숫자 입력받기
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 탐색
        ans = new int[M];
        dfs(0, 0);

        // 출력
        System.out.println(sb.toString().trim());
    }

    // 나보다 작은것 x
    // 중복되는 것 x
    public static void dfs(int s, int m){

        // 종료 조건
        if(m == M){
            print();
            return;
        }

        int before = 0;
        for(int i = s; i<N; i++){

            if(before == arr[i]) continue;

            before = arr[i];
            ans[m] = arr[i];
            dfs(i, m+1);
        }
    }

    public static void print() {
        for(int i : ans){
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }
}
