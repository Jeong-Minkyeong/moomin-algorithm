import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static HashMap<String, String> password;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        // N, M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 비밀번호 맵 만들기
        password = new HashMap<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            password.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(password.get(st.nextToken())).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}
