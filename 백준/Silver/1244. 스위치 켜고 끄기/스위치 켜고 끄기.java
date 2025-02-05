import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        // 스위치 번호 N 받기
        int N = sc.nextInt();

        // 스위치 on/off 받기
        int[] arr = new int[N+1];
        for(int i = 1; i<N+1; i++){
            arr[i] = sc.nextInt();
        }

        // 학생 수 받기
        int studentN = sc.nextInt();

        // 학생 성별과 스위치 번호 받기
        // 성별에 따른 동작
        for(int i = 0; i<studentN; i++){
            int student = sc.nextInt();
            int switchNum = sc.nextInt();

            if(student ==  1){
                // 남자 동작
                for(int j = switchNum; j<arr.length; j++){
                    if(j % switchNum == 0) {
                        arr[j] = 1 - arr[j];
                    }
                }
                continue;
            }
            // 여자동작
            arr[switchNum] = 1 - arr[switchNum];
            for(int j = 1; j<arr.length; j++){
                int start = switchNum - j;
                int end = switchNum + j;
                if(start == 0 | end == arr.length){
                    break;
                }

                if(arr[start] == arr[end]) {
                    arr[start] = 1 - arr[start];
                    arr[end] = 1 - arr[end];
                    continue;
                }
                break;
            }
        }

        // 마지막 상태 출력, 20개씩
        for(int i = 1; i<=N; i++){
            System.out.print(arr[i] + " ");
            if(i % 20 == 0){
                System.out.println();
            }
        }
    } // main 
}
