import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static HashSet<String> name1;
    static HashSet<String> name2;
    public static void main(String[] args) throws IOException {

        // N과 M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        name1 = new HashSet<>();
        name2 = new HashSet<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            name1.add(st.nextToken());
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            name2.add(st.nextToken());
        }

        name1.retainAll(name2);
        String[] ans = name1.toArray(new String[0]);

        Arrays.sort(ans);

        System.out.println(ans.length);
        for(String s : ans){
            System.out.println(s);
        }
    }
}
