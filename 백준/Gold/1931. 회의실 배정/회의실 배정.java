import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 회의시간 배열 선언
        int[][] time = new int[N][2];

        // 회의시간 입력받기
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의 시간 정렬
        // 2차원 배열임으로 정렬 기준 설정 -> 끝나는 시간 기준으로 정렬
        Arrays.sort(time, (a, b) -> {
             if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        // 최대 회의시간 구하기
        // 회의 시간 count 변수
        int count = 1;

        // 시작타임 하나 정하기
        // 다음으로 선택할 수 있는 회의들을 선택해나가기
        int start = time[0][1];

        for (int i = 1; i < N; i++) {
            if (time[i][0] >= start) {
                start = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
