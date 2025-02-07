import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // N, M 입력 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(bf.readLine());

        // 바구니 크기 설정
        int start = 1;
        int end = M;

        // 사과 떨어지는 위치
        int apple;

        // 움직임 수
        int count = 0;

        // 사과 떨어지는 위치 받기
        for(int i = 0; i<J; i++){
            apple = Integer.parseInt(bf.readLine());

            if(apple < start){
                end -= (start - apple);
                count += (start - apple);
                start = apple;
                continue;
            }

            if(apple > end) {
                start += (apple - end);
                count += (apple - end);
                end = apple;
            }
        }
        System.out.println(count);
    }
}
