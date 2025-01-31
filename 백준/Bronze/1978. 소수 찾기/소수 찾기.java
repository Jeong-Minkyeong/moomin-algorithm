import java.util.Scanner;

public class Main { // 소수 찾기

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        int count = N;

        for(int i = 0; i<N; i++){
            A[i] = sc.nextInt();
        }

        for(int i = 0; i<N; i++){
            if(A[i] == 1){
                count--;
                continue;
            }
            for(int j = 2; j<A[i]; j++){
                if (A[i] % j == 0){
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
