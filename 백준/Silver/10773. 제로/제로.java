import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // N 입력받기
        int N = sc.nextInt();

        // 쓴 수 입력받기
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<N; i++){
            int temp = sc.nextInt();
            if(temp == 0){
                stack.pop();
                continue;
            }
            stack.push(temp);
        }

        // 합계 구하기
        int sum = 0;
        while(!stack.empty()){
            sum += stack.pop();
        }

        // 출력
        System.out.println(sum);
    }
}
