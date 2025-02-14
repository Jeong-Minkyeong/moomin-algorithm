import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int count = 0;
    static ArrayList<Integer>[] arr; // 배열이고 안에 원소의 타입이 ArrayList<Integer>
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        // N과 M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        // 인접 리스트 생성
        for(int i = 1; i<N+1; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i = 1; i<N+1; i++){
            if(visited[i]) continue;
            count++;
            dfs(i);
        }

        System.out.println(count);
    }

    public static void dfs(int n){
        // 방문 처리
        visited[n] = true;

        // 방문한 노드에 인접한 노드 찾기
        for(int i = 0; i<arr[n].size(); i++){
            if(!visited[arr[n].get(i)]){
                dfs(arr[n].get(i));
            }
        }
    }
}
