import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // N 입력받기
        int N = Integer.parseInt(bf.readLine());

        // N만큼 카드 입력받기
        // 카드를 해시맵에 숫자와 함께 저장
        HashMap<Integer, Integer> hm = new HashMap<>();
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i<N; i++){
            int c = Integer.parseInt(st.nextToken());
            if(hm.containsKey(c)){
                hm.replace(c, hm.get(c) + 1);
                // hm.put(c, hm.getOrDefault(c, 0) + 1);
                continue;
            }
            hm.put(c, 1);
        }

        // M 입력받기
        int M = Integer.parseInt(bf.readLine());
        
        // M만큼 숫자 입력받기
        st = new StringTokenizer(bf.readLine());

        // M에 쓰인 카드의 수를 해시맵에서 찾기
        for(int i = 0; i<M; i++){
            int n = Integer.parseInt(st.nextToken());
            if(hm.containsKey(n)){
                sb.append(hm.get(n)).append(" ");
                continue;
            }
            sb.append(0).append(" ");
        }

        // 정답 배열 출력
        System.out.println(sb.toString());
    }
}
