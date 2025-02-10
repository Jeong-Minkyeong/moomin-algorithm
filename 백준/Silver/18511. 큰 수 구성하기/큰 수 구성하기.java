import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int N, K, max;

    public static void func(int cnt, int num){
        if(cnt == 8){
            return;
        }

        num *= 10;

        // 종료 조건 num이 N보다 클 경우 return
        if(num > N){
            return;
        }

        // 500(max) -> 100 -> 570(max) -> 550 -> 510 -> 577(max) -> 575 -> 571 => max: 577
        for(int i = 0; i<K; i++) {
            int temp = num + arr[i];
            if (temp > N) continue;
            if (temp > max) max = temp;
            func(cnt+1, temp);
        }
    }

    public static void main(String[] args) throws IOException {

        // N과 K받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 원소 입력받기
        arr = new int[K];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0,0);
        System.out.println(max);
    }
}
