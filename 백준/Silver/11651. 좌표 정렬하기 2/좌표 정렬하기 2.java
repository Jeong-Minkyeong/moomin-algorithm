import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // N 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 좌표 입력받기
        int[][] arr = new int[N][2];
        for(int i =0; i<N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for(int i =0; i<N; i++){

            System.out.print(arr[i][0] + " " + arr[i][1]);
            System.out.println();
        }
    }
}
