import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        // N과 M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 나무 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            tree.add(Integer.parseInt(st.nextToken()));
        }

        tree.add(0);
        Collections.sort(tree, Collections.reverseOrder());

        // 구간별로 계산하기
        int height = 0;
        for(int i = 1; i<=N; i++){
            for(int s = tree.get(i-1)-1; s >= tree.get(i); s--){
                height += i;
                if(height >= M){
                    System.out.println(s);
                    return;
                }
            }
        }
    }
}
