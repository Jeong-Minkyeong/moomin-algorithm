import java.util.Arrays;
import java.util.Scanner;

public class Main { // 선택정렬

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String N = sc.next();

        int[] A = new int[N.length()];
        for(int i = 0; i<N.length(); i++){
            A[i] = Integer.parseInt(N.substring(i,i+1));
        }

        Arrays.sort(A);

        for(int i = N.length()-1; i>= 0; i--){
            System.out.print(A[i]);
        }
    }
}
