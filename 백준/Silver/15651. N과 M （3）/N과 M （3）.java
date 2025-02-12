import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M(3)
 * 출력 형태: 중복을 허용하여 M개를 고른 수열
 * 방법: 단순 백트래킹
 * 1 1
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 2
 * 2 3
 * 2 4
 * 3 1
 * 3 2
 * 3 3
 * 3 4
 * 4 1
 * 4 2
 * 4 3
 * 4 4
 */

public class Main {

    static int N, M;
    static int[] arr, ans;
    static StringBuilder sb = new StringBuilder();

    public static void print(){
        for(int i: ans){
            sb.append(i).append(" ");
        }
        sb.append('\n');
    }

    public static void func(int r){

        if(r == M){
            print();
            return;
        }

        for(int i = 0; i<N; i++){
            ans[r] = arr[i];
            func(r+1);
        }
    }

    public static void main(String[] args) throws IOException {

        // N, M 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        arr = new int[N];
        ans = new int[M];

        // 배열 만들기
        for(int i = 0; i<N; i++){
            arr[i] = i+1;
        }

        func(0);
        System.out.println(sb);
    }
}
