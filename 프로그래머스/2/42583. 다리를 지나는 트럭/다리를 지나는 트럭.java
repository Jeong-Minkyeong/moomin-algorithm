import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 0. 준비
        int answer = 1;
        int sum = 0;
        int count = 0;
        Queue<Integer> ready = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        for(Integer i : truck_weights){
            ready.add(i);
        }
        
        // 1. 탐색
        bridge.add(0);
        while(count != truck_weights.length){
            while(bridge.size() < bridge_length){
                if(ready.isEmpty()) {
                    bridge.add(0);
                    answer++;
                    continue;
                }
                if(sum+ready.peek() <= weight){
                    sum += ready.peek();
                    bridge.add(ready.poll());
                    continue;
                }
                bridge.add(0);
                answer++;
            }
            
            if(bridge.peek() != 0) {
                count++;
                answer++;
            }
            sum -= bridge.poll();
        }
    
        // 2. 정답 출력
        return answer;
    }
}

// bridge_length = 트럭 1개당 건너야 하는 다리 길이
// weight = 다리 위에 있는 최대 트럭 무게
// [7 0] [4 5] [5 0] [6 0]
// 1 1    1 1  1 1


