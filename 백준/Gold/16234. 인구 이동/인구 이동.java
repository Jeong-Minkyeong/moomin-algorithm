import java.io.*;
import java.util.*;

public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = { 0, -1, 0, 1};

    static int N, L, R;
    static int[][] arr;
    static int[][] visited;
    static int sum;
    static int count;
    static int location;
    static int flag;
    static int ans;

    public static void main(String[] args) throws IOException {

        // N, L, R 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 인구 수 입력받기
        arr = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색
        // bfs 반복 -> 국경개방하는 국가가 하나도 없을때까지
        while(true){
            flag = 0;
            search();

            if(flag == 0) {
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }

    public static void search(){
        // 국경 개방 여부 확인
        visited = new int[N][N];
        location = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
//                for(int k = 0; k<N; k++){
//                    for(int g = 0; g<N; g++){
//                        System.out.print(visited[k][g] + " ");
//                    }
//                    System.out.println();
//                }

                if(visited[i][j] != 0) continue;

                sum = 0;
                count = 0;
                location++;

                isOpen(i, j, location);

                if(count == 1) continue;

                flag = 1;
                open(location);
            }
        }
    }

    // 개방 국가 방문 처리
    public static void isOpen(int y, int x, int l){
        // Queue
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        // 인구수
        sum += arr[y][x];
        count++;

        // 방문
        visited[y][x] = l;

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];

                if (ny >= N || nx >= N || ny < 0 || nx < 0 || visited[ny][nx] != 0) continue;

                int diff = Math.abs(arr[temp[0]][temp[1]] - arr[ny][nx]);
                if (diff < L || diff > R) continue;

                sum += arr[ny][nx];
                count++;
                visited[ny][nx] = l;
                q.add(new int[]{ny, nx});
            }
        }
    }

    // 개방 국가 인구 수정
    public static void open(int l){
        int people = sum / count;

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(visited[i][j] == l){
                    arr[i][j] = people;
                }
            }
        }
    }
}
