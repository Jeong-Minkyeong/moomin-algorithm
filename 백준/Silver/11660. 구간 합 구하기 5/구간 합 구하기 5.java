import java.io.*;
import java.util.*;

public class Main {
    static int N, M; // N은 크기 M은 합
    static int[][] arr;
    static int[][] dp;
    static int[] xy;
    static int[] answers;
    public static void main(String[] args) throws IOException {

        // N & M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 입력받기
        arr = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열 만들기
        dp = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                dp[i][j] = arr[i][j] + dp[i][j-1];
            }
        }

        // 탐색
        xy = new int[4];
        answers = new int[M];
        for(int i = 0; i<M; i++){
            int answer = 0;

            // xy 입력받기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<4; j++){
                xy[j] = Integer.parseInt(st.nextToken());
            }

            for(int y = xy[0]; y<=xy[2]; y++){
                answer += dp[y][xy[3]] - dp[y][xy[1]-1];
            }

            answers[i] = answer;
        }

        // 정답 출력
        for(int i = 0; i<M; i++){
            System.out.println(answers[i]);
        }
    }
}
