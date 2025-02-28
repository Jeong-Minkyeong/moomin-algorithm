import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long left, mid, right;
    static long[] center;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 심사대 입력 받기
        center = new long[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            center[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(center);
        left = 1;
        right = M * center[0];


        // 탐색 시작
        while(left<=right){
            mid = (left+right) / 2;

            long friend = 0;
            for(int i = 0; i<center.length; i++){
                friend += mid / center[i];
            }

            //System.out.println(left + " " + right);

            if(friend >= M){
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        System.out.println(left);
    }
}
