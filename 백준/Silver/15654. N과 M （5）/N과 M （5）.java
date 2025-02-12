import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * N과 M(3)
 * 출력 형태: 중복을 허용하지 않는 수열 + 입력이 뒤죽박죽
 * 방법: 먼저 sorting 후 중복을 허용하지 않는 수열 생성
 * 주의점: StringBuilder 사용
 * 1 7
 * 1 8
 * 1 9
 * 7 1
 * 7 8
 * 7 9
 * 8 1
 * 8 7
 * 8 9
 * 9 1
 * 9 7
 * 9 8
 */

public class Main {

    static int N, M;
    static ArrayList<Integer> arr;
    static int[] ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void makeString() {
        for(int i: ans){
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }

    public static void func(int r){

        // back 조건
        if(r == M){
            makeString();
            return;
        }

        for(int i = 0; i<N; i++){
            if(visited[i]) continue;
            ans[r] = arr.get(i);
            visited[i] = true;
            func(r+1);
            visited[i] = false;
        }


    }
    public static void main(String[] args) throws IOException {

        // N과 M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        arr = new ArrayList<>();
        ans = new int[M];
        visited = new boolean[N];

        // 배열 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // 배열 sorting
        Collections.sort(arr);

        func(0);
        System.out.println(sb);

    }
}
