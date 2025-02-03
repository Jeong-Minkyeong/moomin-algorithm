import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // N 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 키, 몸무게 입력받기
        int[][] xy = new int[N][2];
        for (int i = 0; i<N; i++){
            xy[i][0] = sc.nextInt();
            xy[i][1] = sc.nextInt();
        }

        // 정답 배열 생성
        int[] answer = new int[N];

        // 순회하기
        for(int i = 0; i<N; i++){
            answer[i]++;
            for(int j = 0; j<N; j++){
                if(xy[i][0] < xy[j][0] & xy[i][1] < xy[j][1]){
                    answer[i]++;
                }
            }
        }

        for(int i = 0; i<N; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
