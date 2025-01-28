import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 구간 합

    public static void main(String[] args) throws IOException {

        // 항상 최악의 경우 생각하기 - 입력값은 100000까지
        // 자바에서 1억번 연산이면 1초

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sArr = new long[n+1];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i<= n; i++){
            sArr[i] = sArr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int a = 1; a <= m; a++){
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(sArr[j] - sArr[i-1]);
        }
    }
}
