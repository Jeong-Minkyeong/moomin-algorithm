import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] city;
    static List<int[]> home;
    static boolean[][] visited;
    static int[][] load;
    static int[] distance;
    static int answer = Integer.MAX_VALUE;


    public static void minLoad(){
        distance = new int[home.size()];
//        for(int i = 0; i<M; i++){
//            System.out.print(load[i][0] + " " + load[i][1]);
//            System.out.println();
//        }

        for(int i = 0; i<M; i++){
            int[] chicken = load[i];
            for(int j = 0; j< home.size(); j++){
                int dist = Math.abs(chicken[0] - home.get(j)[0]) + Math.abs(chicken[1] - home.get(j)[1]);
                if(distance[j] > dist || distance[j] == 0) {
                    distance[j] = dist;
                }
                //System.out.print(distance[j] + " ");
            }
            //System.out.println();

            int sum = 0;
            for(int k = 0; k<distance.length; k++){
                sum += distance[k];
            }
            //System.out.println(sum);

            if(sum < answer){
                answer = sum;
            }
        }
    }

    public static void func(int r, int n, int m){

        if(r == M){
            // load 계산
            minLoad();
            return;
        }

        for(int i = n; i<N; i++){
            for(int j = (i == n ? m : 0); j<N; j++){
                if(city[i][j] == 2 && !visited[i][j]){
                    load[r] = new int[]{i, j};
                    visited[i][j] = true;
                    func(r+1, i, j+1);
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // N,M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 도시 입력받기
        city = new int[N][N];
        load = new int[M][2];
        home = new ArrayList<>();
        visited = new boolean[N][N];

        int homeCount = 0;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1){
                    homeCount++;
                }
            }
        }

        // 집 위치 세기
        int h = 0;
        for(int i = 0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 1) {
                    home.add(new int[]{i, j});
                }
            }
        }

        func(0, 0, 0);

        System.out.println(answer);
    }
}
