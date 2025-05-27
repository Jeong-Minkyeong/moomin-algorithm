import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
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

        // 탐색시작
        ans = new int[M];
        visited = new boolean[N];

        dfs(0);

        System.out.println(sb.toString().trim());
    }

    public static void dfs(int m) {

        if(m == M){
            print();
            return;
        }

        int before = 0; // 중복 방지
        for(int i = 0; i < arr.length; i++) {
            if (visited[i] || before == arr[i]) continue;

            ans[m] = arr[i];
            visited[i] = true;
            before = arr[i];
            dfs(m + 1);
            visited[i] = false;
        }
    }

    public static void print() {
        for(int i = 0; i<M; i++){
            sb.append(ans[i]).append(" ");
        }
        sb.append("\n");
    }
}
