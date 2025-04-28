import java.io.*;
import java.util.*;

class Node {
    int y;
    int x;
    String d;

    public Node(int y, int x, String d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}

public class Main {
    static int N, M;
    static ArrayList<int[]> air = new ArrayList<>();
    static boolean[][] visited;
    static int[][] arr;
    static int ny, nx;
    static int ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 연구실 자리 입력받기
        arr = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                    air.add(new int[]{i, j});
                }
            }
        }

        // 탐색
        visited = new boolean[N][M];
        for(int i = 0; i<air.size(); i++) {
            // System.out.println(air.get(i)[0] + " " + air.get(i)[1]);
            search(air.get(i)[0], air.get(i)[1]);
        }

        // 자리 갯수
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(visited[i][j] == true){
                    ans++;
                }
            }
        }
        
        System.out.println(ans);
    }

    public static void search(int y, int x){

        // Queue 준비
        Queue<Node> q = new LinkedList<>();

        // 방문처리
        visited[y][x] = true;

        // Queue에 동서남북 삽입
        q.add(new Node(y-1, x, "N"));
        q.add(new Node(y+1, x, "S"));
        q.add(new Node(y, x+1, "E"));
        q.add(new Node(y, x-1, "W"));

        // 탐색
        while(!q.isEmpty()){
            Node temp = q.poll();

            // 범위를 넘는다면
            if(temp.y < 0 || temp.x < 0|| temp.y >= N || temp.x >= M || (temp.y == y && temp.x == x)){
                continue;
            }

            // 방문 처리
            visited[temp.y][temp.x] = true;

            switch (temp.d){
                case "N":
                    if(arr[temp.y][temp.x] == 0 || arr[temp.y][temp.x] == 1) q.add(new Node(temp.y-1, temp.x, temp.d));
                    if(arr[temp.y][temp.x] == 3) q.add(new Node(temp.y, temp.x+1, "E"));
                    if(arr[temp.y][temp.x] == 4) q.add(new Node(temp.y, temp.x-1, "W"));
                    break;

                case "S":
                    if(arr[temp.y][temp.x] == 0 || arr[temp.y][temp.x] == 1) q.add(new Node(temp.y+1, temp.x, temp.d));
                    if(arr[temp.y][temp.x] == 3) q.add(new Node(temp.y, temp.x-1, "W"));
                    if(arr[temp.y][temp.x] == 4) q.add(new Node(temp.y, temp.x+1, "E"));
                    break;

                case "W":
                    if(arr[temp.y][temp.x] == 0 || arr[temp.y][temp.x] == 2) q.add(new Node(temp.y, temp.x-1, temp.d));
                    if(arr[temp.y][temp.x] == 3) q.add(new Node(temp.y+1, temp.x, "S"));
                    if(arr[temp.y][temp.x] == 4) q.add(new Node(temp.y-1, temp.x, "N"));
                    break;

                case "E":
                    if(arr[temp.y][temp.x] == 0 || arr[temp.y][temp.x] == 2) q.add(new Node(temp.y, temp.x+1, temp.d));
                    if(arr[temp.y][temp.x] == 3) q.add(new Node(temp.y-1, temp.x, "N"));
                    if(arr[temp.y][temp.x] == 4) q.add(new Node(temp.y+1, temp.x, "S"));
                    break;
            }
        }
    }
}
