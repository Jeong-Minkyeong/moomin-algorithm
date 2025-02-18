import java.io.*;
import java.util.*;

public class Main {

    static String tree;
    static int size = 0;
    static HashMap<String, Integer> treeMap = new HashMap<>();
    static List<String> treeName;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        // 나무 입력받기
        while((tree = br.readLine()) != null){

            if(!treeMap.containsKey(tree)) {
                treeMap.put(tree, 1);
                size++;
                continue;
            }

            treeMap.put(tree, treeMap.get(tree)+1);
            size++;
        }

        // 오름차순 정렬
        treeName = new ArrayList<>(treeMap.keySet());
        Collections.sort(treeName);

        // 백분율 계산
        for(int i = 0; i<treeName.size(); i++){
            String t = treeName.get(i);
            double percent = (double) treeMap.get(t) / size * 100;
            sb.append(t).append(" ").append(String.format("%.4f", percent)).append('\n');
        }

        // 정답 출력
        System.out.println(sb.toString().trim());
    }
}
