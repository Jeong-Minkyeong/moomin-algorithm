import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] arr;
    static int white, blue;

    public static void cut(int n, int rStart, int cStart, int rEnd, int cEnd){

        // 0 또는 1로 모두 구성되어 있는지 확인
        int countZero = 0;
        int countOne = 0;
        for(int i = rStart; i<rEnd; i++){
            for(int j = cStart; j<cEnd; j++){
                if(arr[i][j] == 0) countZero++;
                if(arr[i][j] == 1) countOne++;
            }
        }

        if(countZero == n*n) {
            white++;
            return;
        }

        if(countOne == n*n){
            blue++;
            return;
        }

        // 1사분면
        cut(n/2, rStart, cStart, rEnd-n/2, cEnd-n/2);

        // 2사분면
        cut(n/2, rStart, cStart+n/2, rEnd-n/2, cEnd);

        // 3사분면
        cut(n/2, rStart+n/2, cStart, rEnd, cEnd-n/2);

        // 4사분면
        cut(n/2, rStart+n/2, cStart+n/2, rEnd, cEnd);
    }

    // 네 부분으로 나누어서 탐색
    public static void main(String[] args) throws IOException{

        // N 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 종이 입력 받기
        arr = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 정복 시작
        cut(N, 0, 0, N, N);
        System.out.println(white);
        System.out.println(blue);
    }
}
