import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // N과 K입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 라이언 어피치 입력받기
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 탐색
        int start = 0;
        int end = 0;
        int sum = 0;

        while(end < N) {
            // System.out.println(start + " " + end + " " + ans);

            // 라이언이면
            if(arr[end] == 1) {
                sum++;

                // sum이 K과 같으면
                if(sum == K) {
                    ans = Math.min(ans, end - start + 1);

                    // start값 갱신
                    while (start<=end) {
                        if(arr[start] == 1 && sum != K-1) {
                            sum--;
                            start++;
                            continue;
                        }

                        if(arr[start] == 1 && sum == K-1) break;

                        start++;
                    }
                }

                // end값 갱신
                end++;
                continue;
            }
            // 어피치이면
            end++;
        }

        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }
}
