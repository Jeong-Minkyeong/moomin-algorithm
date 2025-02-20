import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int prompt = Integer.parseInt(st.nextToken());

            if(prompt > 0){
                pq.add(prompt);
                continue;
            }

            if(pq.isEmpty() && prompt == 0){
                sb.append(0).append('\n');
                continue;
            }
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}
