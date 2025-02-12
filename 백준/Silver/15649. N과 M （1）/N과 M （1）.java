import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M(1)
 * 출력 형태: 자기 자신만 제외한 모든 조합
 * 방법: DFS를 활용한 백트래킹, 앞서 나온 값들을 확인해야 함으로..
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 4
 * 3 1
 * 3 2
 * 3 4
 * 4 1
 * 4 2
 * 4 3
 */

public class Main {

    static int N, M;
    static int[] arr, ans;
    static boolean[] visited;

    public static void print(){
        for(int i = 0; i<M; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void func(int r){

        if(r == M){
            // 출력
            print();
            return;
        }

        /**
         * 탐색하는 수를 모두 방문처리 해가면서 탐색
         * 빠져나오면서 방문 해제
         */
        for(int i = 0; i<N; i++){
            if(visited[i]) continue;
            ans[r] = arr[i];
            visited[i] = true;
            func(r+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N과 M 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // arr 만들기
        arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = i+1;
        }

        // ans과 visited 초기화
        ans = new int[M];
        visited = new boolean[N];

        func(0);

    }
}
