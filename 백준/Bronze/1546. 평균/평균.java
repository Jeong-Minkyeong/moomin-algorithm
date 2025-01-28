import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        String score = bf.readLine();

        st = new StringTokenizer(score, " ");
        int sum = 0;
        int max = 0;

        // 모든 과목 수를 더하고 100만큼 곱하고 과목 수(n) 만큼 나누기
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if (max <= num) {
                max = num;
            }
            sum += num;
        }
        System.out.println(sum * 100.0 / max / n);
    }
}
