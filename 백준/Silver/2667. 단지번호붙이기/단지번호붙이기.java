import java.io.*;
import java.util.*;

public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int count = 1;
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 아파트 입력받기
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }

        // 아파트 탐색 시작
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                    ans.add(count);
                    count = 1;
                }
            }
        }

        System.out.println(ans.size());
        if(ans.size() == 0){
            System.out.println(0);
            return;
        }

        Collections.sort(ans);
        for(int i = 0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }

    static public void bfs(int y, int x){
        // 큐 준비
        Queue<int[]> q = new LinkedList<>();

        // 시작 아파트 방문 처리
        visited[y][x] = true;
        q.add(new int[]{y, x});

        // 인접 아파트 탐색 시작
        while(!q.isEmpty()){
            int[] yx = q.poll();

            for(int i = 0; i<4; i++){
                int ny = yx[0] + dy[i];
                int nx = yx[1] + dx[i];

                if(ny >= 0 && ny < N && nx >= 0 && nx < N && arr[ny][nx] == 1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                    count++;
                }
            }
        }
    }
}
