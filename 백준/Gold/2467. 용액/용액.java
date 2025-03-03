import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int start, end;
    static long[] arr;
    static long[] ans;
    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 용액 입력 받기
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 용액 탐색 시작
        ans = new long[]{Long.MAX_VALUE, 0};
        start = 0;
        end = N-1;
        while(start != end){

            // 용액 특성값 비교
            if(Math.abs(arr[start] + arr[end]) <= Math.abs(ans[0] + ans[1])){
                ans[0] = arr[start];
                ans[1] = arr[end];
            }

            if(Math.abs(arr[start]) > Math.abs(arr[end])) {
                start += 1;
                continue;
            }

            if(Math.abs(arr[start]) < Math.abs(arr[end])) {
                end -= 1;
                continue;
            }

            start += 1;
            end -= 1;
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
