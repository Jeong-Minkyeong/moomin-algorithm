import java.util.PriorityQueue;
import java.util.Scanner;

public class Main { // 우선순위 큐

    public static void main(String[] args){

        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 우선순위 큐 절댓값 기준으로 정렬되도록 설정하기
        // 절댓값이 같으면 음수 우선 설정하기
        PriorityQueue<Integer> pQ = new PriorityQueue<>((o1,o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if(first_abs == second_abs){   // 절댓값이 같은 경우 음수 우선
                return o1 > o2 ? 1 : -1; // 양수 음수
            }
            return first_abs - second_abs; // 절댓값 작은 데이터 우선
        });


        // 입력이 0인경우와 아닌경우
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();

            if (num == 0) {
                // 배열이 비었을 경우
                if(pQ.isEmpty()){
                    System.out.println("0");
                } else {
                    // 배열에서 가장 절댓값이 작은 값을 출력
                    System.out.println(pQ.poll());
                }
            } else {
                // 배열에 값을 삽입
                pQ.add(num);
            }
        }
    }
}
