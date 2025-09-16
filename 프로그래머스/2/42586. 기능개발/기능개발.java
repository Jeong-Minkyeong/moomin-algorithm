import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        // 0. 준비
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> pq = new LinkedList<>();
        Queue<Integer> tq = new LinkedList<>();
        
        for(int i = 0; i<progresses.length; i++){
            pq.add(progresses[i]);
            tq.add(speeds[i]);
        }
        
    
        // 1. 탐색
        while(!pq.isEmpty()) {
            int progress = pq.poll();
            double time = tq.poll();
            
            // 남은 작업량 계산
            int job = (int) Math.ceil((100 - progress) / time);
            //System.out.println(Math.ceil(0.01));
            // 배포 가능한 기능 계산
            int count = 1;
            while(!pq.isEmpty()){
                //System.out.println((int) Math.ceil((100 - pq.peek()) / tq.peek()));
                if(job < (int) Math.ceil((double)(100 - pq.peek()) / tq.peek())) {
                    break;
                }
                pq.poll();
                tq.poll();
                count++;
            }
            answer.add(count);
        }
            
        // 2. 정답 출력
        return answer;
    }
}
