import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static boolean[] visited;
    static int ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        N = Integer.parseInt(br.readLine());

        // key 설정
        for(int i = 1; i<=N; i++){
            map.put(i, 0);
        }

        // 둘째줄 입력받기
        for(int i = 1; i<=N; i++){
            map.put(i, Integer.parseInt(br.readLine()));
        }

        // 탐색
        visited = new boolean[N+1];
        for(int i = 1; i<=N; i++) {
            search(i, i, 1);
        }

        System.out.println(ans);
        System.out.println(sb.toString().trim());
    }

    public static void search(int start, int cur, int depth){

        if(depth > N || visited[cur] == true){
            return;
        }

        if(start == map.get(cur)){
            ans += 1;
            sb.append(start).append("\n");
            return;
        }
        visited[cur] = true;
        search(start, map.get(cur), depth+1);
        visited[cur] = false;
    }
}
