import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static HashMap<Integer, Integer> fruits = new HashMap<>();
    static List<Integer> Tanghulu = new ArrayList<>();
    static int ans;

    public static void main(String[] args) throws IOException {

        // N (과일 갯수)입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 과일 입력받기
        st = new StringTokenizer(br.readLine());

        // 탕후루 꽂기
        for(int i = 0; i<N; i++){
            Tanghulu.add(Integer.parseInt(st.nextToken()));
        }

        // 탕후루 탐색
        // 초기값 세팅
        int start = 0;
        int end = 0;
        for(int i = 0; i<N; i++){

            // 과일이 없다면 세팅
             if(fruits.getOrDefault(Tanghulu.get(i), 0) == 0){
                fruits.put(Tanghulu.get(i), 0);
            }

            // 과일 갯수 더하기
            fruits.put(Tanghulu.get(i), fruits.get(Tanghulu.get(i)) + 1);
            end++;

            // 과일 갯수가 2개를 초과하면
            while(fruits.size() > 2){

                // 범위를 줄여가며 탐색
                fruits.put(Tanghulu.get(start), fruits.get(Tanghulu.get(start)) - 1);

                // 과일이 없으면 삭제
                if(fruits.get(Tanghulu.get(start)) == 0){
                    fruits.remove(Tanghulu.get(start));
                }
                
                start++;
            }
            ans = Math.max(ans, end - start);
        }
        System.out.println(ans);
    }
}
