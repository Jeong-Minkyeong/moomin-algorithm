import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Circle {
    int name;
    int data;
    boolean open;

    public Circle(int name, int data, boolean open){
        this.name = name;
        this.data = data;
        this.open = open;
    }
}

public class Main {
    static int N;
    static List<Circle> list;
    static Stack<Circle> stack;

    public static void main(String[] args) throws IOException {

        // M과 원 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            list.add(new Circle(i, x - r, true));
            list.add(new Circle(i, x + r, false));

        }

        // stack 초기화
        stack = new Stack<>();

        // 전체 정렬
        Collections.sort(list, (o1, o2) -> o1.data - o2.data);

        // 하나씩 꺼내면서 짝 비교
        for(Circle c : list){

            if(c.open){
                stack.push(c);
                continue;
            }

            if(c.name == stack.peek().name){
                stack.pop();
                continue;
            }

            if(c.name != stack.peek().name){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
