import java.io.*;
import java.util.*;

public class Main {

    static int N, d, k, c;
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException {

        // N, d, k, c 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 초밥 입력 받기
        arr = new int[N+k-1];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], 0);
        }


        for(int i = 0; i<k-1; i++){
            arr[N+i] = arr[i];
        }

        int start = 0;
        int end = k-1;
        int count = 0;
        int coupon;

        // 처음 탐색
        for(int i = 0; i<k; i++){
            if(map.get(arr[i]) == 0){
                count++;
            }
            map.put(arr[i], map.get(arr[i])+1);
        }

        // 최댓값 갱신
        coupon = map.getOrDefault(c, 0) == 0 ? 1 : 0;
        ans = Math.max(ans, count + coupon);

        while(start < N-1){

            // 갯수 계산
            end++;
            map.put(arr[end], map.get(arr[end])+1);
            if(map.get(arr[end]) == 1) count++;

            map.put(arr[start], map.get(arr[start])-1);
            if(map.get(arr[start]) == 0) count--;
            start++;

            // 최댓값 갱신
            coupon = map.getOrDefault(c, 0) == 0 ? 1 : 0;
            ans = Math.max(ans, count + coupon);
        }
        System.out.println(ans);
    }
}
