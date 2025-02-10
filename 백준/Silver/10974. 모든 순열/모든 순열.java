import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] visited;
    static int[] arr, ans;
    static int N;

    public static void dfs(int n, int d){

        // 끝까지 갔으면
        if(d == N){
            // 숫자 출력
            print();
            return;
        }

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                ans[d] = arr[i];
                dfs(n, d+1);
                visited[i] = false;
            }
        }
    }

    public static void print(){
        for(int i = 0; i<N; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N];
        ans = new int[N];

        for(int i = 1; i<=N; i++){
            arr[i-1] = i;
        }
        dfs(N, 0);
    }
}
