import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int ans;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {

        // N과 K 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 동전의 가치 입력받기
        list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 가장 큰 것부터 확인할 수 있도록 정렬
        Collections.sort(list, Collections.reverseOrder());

        // 동전 세기
        ans = 0;
        for(int i = 0; i<N; i++){
            while(true){
                if(K - list.get(i) < 0) {
                   break;
                }
                K -= list.get(i);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
