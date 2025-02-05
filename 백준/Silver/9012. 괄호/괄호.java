import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){

        // N 입력 받기
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();

        // 괄호 입력 받기
        String[] arr = new String[N];
        for(int i = 0; i<N; i++){
            arr[i] = sc.next();
        }

        // 괄호를 스택에 담고 비교하기 (())())
        for(int i = 0; i<N; i++){
            System.out.println(vps(arr[i]));
        }
    }

    private static String vps(String a){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<a.length();i++){
            if(a.charAt(i) == ')' & stack.empty()){
                return "NO";
            }

            if(a.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack.peek() == '(' & !stack.empty()){
                    stack.pop();
                }
            }
        }
        return stack.empty() ? "YES" : "NO";
    }
}
