import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr, ans;
    public static boolean[] visited;
    public static int N, M;

    public static void func(int r, int d){

        if(r == M){
            // 정답 출력
            print();
            return;
        }

        for(int i = d; i<N; i++){
            if(visited[i]) continue;
            ans[r] = arr[i];
            visited[i] = true;
            func(r + 1, i);
            visited[i] = false;
        }
    }

    public static void print(){
        for(int i = 0; i<M; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        ans = new int[M];

        for(int i = 0; i<N; i++){
            arr[i] = i+1;
        }

        func(0, 0);

    }

}
