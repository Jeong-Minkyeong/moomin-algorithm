import java.io.*;
import java.util.*;

public class Main {

    static int N, M; // 크레인 수, 박스 수
    static int count = 0;
    static int maxBox = 0;
    static LinkedList<Integer> crane =  new LinkedList<>();
    static LinkedList<Integer> box = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 크레인 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        // M 입력받기
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        // 박스 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int b = Integer.parseInt(st.nextToken());
            box.add(b);
            maxBox = Math.max(maxBox, b);
        }

        // 크레인 정렬 - 내림차순
        Collections.sort(crane, (o1, o2) -> o2 - o1);
        Collections.sort(box, (o1, o2) -> o2 - o1);

        // 만약 모든 박스를 배로 옮길 수 없으면 -1을 출력
        // 크레인 무게보다 박스의 무게가 클 경우
        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        // 1분마다 크레인이 옮겨야 할 세트 만들어주자
       while(!box.isEmpty()){
            count++;
            for(int i = 0; i<N; i++){
                if(box.isEmpty()){
                    System.out.println(count);
                    return;
                }

                if(box.get(0) > crane.get(i)){
                    if(box.getLast() > crane.get(i)) continue;

                    if(box.getLast() == crane.get(i)){
                        box.remove(box.size()-1);
                        continue;
                    }

                    for(int j = 0; j<box.size(); j++){
                        if(box.get(j) < crane.get(i)){
                            box.remove(j);
                            break;
                        }
                    }
                    continue;
                }
                box.remove(0);
            }
        }
        System.out.println(count);
    }
}
