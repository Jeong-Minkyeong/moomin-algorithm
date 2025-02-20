import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int sum = 0;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] count;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // N과 M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 친구관계 입력받기
        arr = new ArrayList[N+1];
        // visited = new boolean[N];

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

        // 베이컨 탐색 시작
        for(int i = 1; i<=N; i++){
            sum = 0;
            count = new int[N+1];
            visited = new boolean[N+1];
            bfs(i);
            for(int d : count){
                sum += d;
            }
            //System.out.println(sum);
            ans.add(sum);
        }
        System.out.println(ans.indexOf(Collections.min(ans))+1);
    }
    public static void bfs(int people){
        // 큐 준비
        Queue<Integer> q = new LinkedList<>();

        // 방문 처리
        visited[people] = true;
        q.add(people);

        // 친구관계 탐색
        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i = 0; i<arr[temp].size(); i++){
                if(!visited[arr[temp].get(i)]) {
                    visited[arr[temp].get(i)] = true;
                    count[arr[temp].get(i)] = count[temp] +1;
                    q.add(arr[temp].get(i));
                }
            }
        }
    }
}
