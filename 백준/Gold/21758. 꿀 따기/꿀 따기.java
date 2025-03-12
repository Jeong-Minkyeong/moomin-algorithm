import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long bee = 0;
    static long maxHoney;
    static long sumHoney;
    static int[] honey;
    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 꿀 입력받기
        honey = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            honey[i] = Integer.parseInt(st.nextToken());
            sumHoney += honey[i];
        }

        // 자리 탐색하기
        long h;
        // 꿀통이 move
        for(int i = 1; i<N-1; i++){
            // System.out.println(sumHoney + " " + maxHoney);

            h = (sumHoney - (honey[0] + honey[N-1])) + honey[i];
            maxHoney = Math.max(h, maxHoney);
        }

        // 꿀통이 오른쪽 끝, 꿀벌 한마리 move
        bee = 0;
        for(int i = 1; i<N-1; i++){
            //System.out.println(sumHoney + " " + maxHoney);

            h = (sumHoney - (honey[0] + honey[i])) * 2 - bee;
            maxHoney = Math.max(h, maxHoney);
            bee += honey[i];
        }

        // 꿀통이 왼쪽 끝, 꿀벌 한마리 move
        bee = 0;
        for(int i = N-2; i>0; i--){
            //System.out.println(sumHoney + " " + maxHoney);

            h = (sumHoney - (honey[N-1]+honey[i])) * 2 - bee;
            maxHoney = Math.max(h, maxHoney);
            bee += honey[i];
        }
        System.out.println(maxHoney);
    }
}
