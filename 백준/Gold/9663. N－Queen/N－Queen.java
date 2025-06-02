import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력받기
        N = Integer.parseInt(br.readLine());

        // 체스판 준비
        arr = new int[N];
        visited = new boolean[N];

        // 탐색
        dfs(0);
        System.out.println(ans);

    }

    public static void dfs(int n){

        // 탈출 조건
        if(n == N){
            ans++;
            return;
        }

        // 배치 가능한지 확인
        for(int i = 0; i<N; i++){
            arr[n] = i;

            if(check(n)){
                dfs(n+1);
            }
        }
    }

    // 같은 행에 존재하지 않고, 대각선상 같은 위치에 있으면 안됨
    public static boolean check(int col){
        for(int i = 0; i<col; i++){

            // 같은 행
            if(arr[i] == arr[col]) return false;

            // 대각선
            if(col - i == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }
}