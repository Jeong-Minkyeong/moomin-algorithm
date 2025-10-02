import java.util.*;
import java.io.*;

import static java.lang.System.exit;

public class Main {
    static int N;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static String[][] arr;
    static List<int[]> teacher = new ArrayList<>();
    static List<int[]> student = new ArrayList<>();
    static Set<int[]> obstacleSet = new HashSet<>();
    static List<int[]> obstacle = new ArrayList<>();
    static String answer = "NO";

    public static void main(String[] args) throws IOException {

        // - 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new String[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = st.nextToken();
                if(arr[i][j].equals("T")){
                    teacher.add(new int[]{i, j});
                    continue;
                }

                if(arr[i][j].equals("S")){
                    student.add(new int[]{i, j});
                }
            }
        }

        // - 탐색
        // 장애물 설치 지역 탐색
        for(int[] d: student) {
            for (int i = 0; i < 4; i++) {
                int ny = d[0] + dy[i];
                int nx = d[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                    continue;
                }

                if (arr[ny][nx].equals("T")) {
                    System.out.println(answer);
                    return;
                }

                if (arr[ny][nx].equals("S")) continue;

                obstacleSet.add(new int[]{ny, nx});
            }
        }

        // 리스트로 변경
        obstacle = new ArrayList<>(obstacleSet);

        // 장애물 3개 설치
        for(int i = 0; i<obstacle.size(); i++) {
            dfs(i, 0);
        }

        // - 정답 출력
        System.out.println(answer);
    }

    public static void dfs(int d, int n) {
        if(d == 3){
            // 탐색
            if(isAvoid()){
                answer = "YES";
                System.out.println(answer);
                exit(0);
            }
            return;
        }

        for(int i = n; i<obstacle.size(); i++){
            int[] temp = obstacle.get(i);
            arr[temp[0]][temp[1]] = "O";
            dfs(d+1, i+1);
            arr[temp[0]][temp[1]] = "X";
        }
    }

    public static boolean isAvoid(){

        for(int[] t: teacher){
            for(int i = 0; i<4; i++){
                int c = 0;
                while(true) {
                    c++;
                    int ny = t[0] + (dy[i] * c);
                    int nx = t[1] + (dx[i] * c);

                    if(ny < 0 || nx < 0 || ny >= N || nx >= N || arr[ny][nx].equals("O")) break;

                    if(arr[ny][nx].equals("S")) return false;
                }
            }
        }
        return true;
    }
}
