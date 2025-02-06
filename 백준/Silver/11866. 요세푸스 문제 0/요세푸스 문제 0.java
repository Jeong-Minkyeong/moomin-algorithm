import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // N과 K입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1~N까지의 테이블 생성
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=N; i++){
            queue.add(i);
        }

        // 정답 변수
        StringBuilder sb = new StringBuilder();

        // 3 -> (45)6 -> (71)2 -> ...
        // K번째 삭제, 삭제 반복은 K번째부터 시작
        int i = 1;
        while(!queue.isEmpty()){
            if (i++ % K == 0) {
                sb.append(queue.poll() + ", ");
                continue;
            }
            queue.offer(queue.poll());
        }

        // 정답 출력
        sb.delete(sb.length()-2, sb.length());
        System.out.println("<" + sb.toString() + ">");
    }
}
