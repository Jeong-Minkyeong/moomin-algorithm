import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static HashMap<String, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // N, M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 포켓몬 입력받기
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            map.put(String.valueOf(i), temp);
            map.put(temp, String.valueOf(i));
        }

        // 명령 입력받기
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(map.get(st.nextToken())).append('\n');
        }

        System.out.println(sb.toString().trim());
    }
}
