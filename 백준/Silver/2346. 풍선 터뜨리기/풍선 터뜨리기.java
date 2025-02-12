import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N;
    static int[] move;
    static ArrayDeque<int[]> deque;
    static StringBuilder sb = new StringBuilder();

    public static void func(){
        // 양수일때는 앞에서 뒤로 이동하고 맨앞 삭제
        if(move[0] > 0){
            for(int i = 0; i<move[0]-1; i++){
                int[] temp = deque.pollFirst();
                deque.addLast(temp);
            }
            move = deque.pollFirst();
            sb.append(move[1]+ " ");
            return;
        }
        // 음수일때는 뒤에서 앞으로 이동하고 맨뒤 삭제
        for(int i = 0; i<Math.abs(move[0])-1; i++){
            int[] temp = deque.pollLast();
            deque.addFirst(temp);
        }
        move = deque.pollLast();
        sb.append(move[1]+ " ");
    }

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 풍선 입력받기
        deque = new ArrayDeque<>();
        //arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            deque.add(new int[]{Integer.parseInt(st.nextToken()), i+1});
            //arr.add(temp);
        }

        // 첫번째 터트리기
        move = deque.pollFirst();
        sb.append(move[1]+ " ");
        while(!deque.isEmpty()){
            func();
        }
        System.out.println(sb);
    }
}
