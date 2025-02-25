import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int ans;
    static List<String> clothList;
    static HashMap<String, Integer> clothMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            // Map 정의
            clothMap = new HashMap<>();

            for(int j = 0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String category = st.nextToken();
                if(!clothMap.containsKey(category)){
                    clothMap.put(category, 1);
                    continue;
                }
                clothMap.replace(category, clothMap.get(category) + 1);
            }

            // 조합 구하기
            ans = 1;
            clothList = new ArrayList<>(clothMap.keySet());
            for(int j = 0; j<clothList.size(); j++){
                ans *= clothMap.get(clothList.get(j))+1;
            }
            System.out.println(ans-1);
        }
    }
}
