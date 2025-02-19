import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // N, M, V 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 그래프 만들기
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }

        // 정렬
        for(int i = 1; i<=N; i++){
            if(arr[i] != null){
                Collections.sort(arr[i]);
            }
        }

        dfs(V);

        sb.append('\n');
        visited = new boolean[N+1];

        bfs(V);

        System.out.println(sb.toString().trim());
    }

    static public void dfs(int n){

        visited[n] = true;
        sb.append(n).append(" ");

        for(int i = 0; i<arr[n].size(); i++) {
            if (!visited[arr[n].get(i)]) {
                visited[arr[n].get(i)] = true;
                dfs(arr[n].get(i));
            }
        }
    }

    static public void bfs(int n){

        Queue<Integer> q = new LinkedList<>();

        visited[n] = true;
        sb.append(n).append(" ");

        q.add(n);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i<arr[node].size(); i++){
                if(!visited[arr[node].get(i)]){
                    visited[arr[node].get(i)] = true;
                    q.add(arr[node].get(i));
                    sb.append(arr[node].get(i)).append(" ");
                }
            }
        }
    }
}
