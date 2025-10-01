import java.io.*;
import java.util.*;
import static java.lang.System.exit;

public class Main {
    static int M, N;
    static int[] arr;
    static int answer = 0;
    static boolean[] visited;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        // - 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        for(int i = 0; i<N; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        // - 탐색
        for(int i = 0; i<N; i++) {
            visited[i] = true;
            dfs(0, i);
            visited[i] = false;
        }


        // - 결과 출력
        System.out.println(answer);
    }

    public static void dfs(int d, int k) {

        if(d == 4){
            answer = 1;
            System.out.println(answer);
            exit(0);
            return;
        }

        if(map.get(k).isEmpty()) return;

        for(Integer i : map.get(k)) {
            if (visited[i]) continue;

            visited[i] = true;
            //System.out.println(i);
            dfs(d + 1, i);
            visited[i] = false;
        }
    }
}
