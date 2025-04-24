import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans = 1;
    public static void main(String[] args) throws IOException {

        // N 입력받기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 1부터 하나씩 증가
        int start = 1;
        while(start<N){
            for(int i = 0; i<6*ans; i++){
                start++;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
