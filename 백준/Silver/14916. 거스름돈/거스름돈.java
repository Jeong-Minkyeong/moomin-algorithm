import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N == 1 || N == 3){
            System.out.println(-1);
            return;
        }

        while(N > 0){
            if(N % 5 == 0){
                count += N / 5;
                N = N % 5;
                continue;
            }
            count++;
            N = N - 2;
        }
        System.out.println(count);
    }
}
