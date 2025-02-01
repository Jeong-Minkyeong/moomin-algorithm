import java.util.Scanner;

public class Main { // 완전 탐색

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char A[][] = new char[N][M];
        char W[][] = {{'W','B','W','B','W','B','W','B'},
                      {'B','W','B','W','B','W','B','W'},
                      {'W','B','W','B','W','B','W','B'},
                      {'B','W','B','W','B','W','B','W'},
                      {'W','B','W','B','W','B','W','B'},
                      {'B','W','B','W','B','W','B','W'},
                      {'W','B','W','B','W','B','W','B'},
                      {'B','W','B','W','B','W','B','W'}};

        char B[][] = {{'B','W','B','W','B','W','B','W'},
                      {'W','B','W','B','W','B','W','B'},
                      {'B','W','B','W','B','W','B','W'},
                      {'W','B','W','B','W','B','W','B'},
                      {'B','W','B','W','B','W','B','W'},
                      {'W','B','W','B','W','B','W','B'},
                      {'B','W','B','W','B','W','B','W'},
                      {'W','B','W','B','W','B','W','B'}};

        int min = 2500;

        for(int i = 0; i<N; i++){
            String t = sc.next();
            for(int j = 0; j<M; j++){
                A[i][j] = t.charAt(j);
            }
        }

        for(int i = 0; i<N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                int wCount = 0;
                int bCount = 0;

                for (int a = 0; a < 8; a++) {
                    for (int b = 0; b < 8; b++) {
                        if (A[a+i][b+j] != W[a][b]) {
                            wCount++;
                        }
                    }
                }

                for (int a = 0; a < 8; a++) {
                    for (int b = 0; b < 8; b++) {
                        if (A[a+i][b+j] != B[a][b]) {
                            bCount++;
                        }
                    }
                }
                int temp = wCount > bCount ? bCount : wCount;
                if (min > temp){
                    min = temp;
                }
            }
        }
        System.out.println(min);
    }
}
