import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int count;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void dfs(int num){

        visited[num] = true;

        for(int i = 0; i<arr[num].size(); i++){
            if(!visited[arr[num].get(i)]) {
                visited[arr[num].get(i)] = true;
                count++;
                dfs(arr[num].get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 입력받기
        N = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        // 인접 리스트 생성
        for(int i = 1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        // M 입력받기
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        // 입력받기
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }

        dfs(1);

        System.out.println(count);
    }
}
