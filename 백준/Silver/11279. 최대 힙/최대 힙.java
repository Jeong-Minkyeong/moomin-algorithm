import java.io.*;
import java.util.*;

public class Main {

    static int N;
    
    // 내림차순 정렬
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 반복해서 수 입력받기
        for(int i =0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num > 0){
                priorityQueue.add(num);
                continue;
            }

            if(priorityQueue.isEmpty() && num == 0 ){
                sb.append(0).append('\n');
                continue;
            }

            sb.append(priorityQueue.poll()).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}
