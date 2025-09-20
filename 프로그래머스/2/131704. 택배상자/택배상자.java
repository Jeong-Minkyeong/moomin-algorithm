import java.util.*;

class Solution {
    public int solution(int[] order) {
        // 0. 준비
        Queue<Integer> con = new LinkedList<>();
        Queue<Integer> orders = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();
        int answer = 0;
        
        for(int i = 1; i<=order.length; i++){
            con.add(i);
            orders.add(order[i-1]);
        }
        
        // 1. 탐색
        while(!orders.isEmpty()) {
            // 같다면
            if(!con.isEmpty() && orders.peek().equals(con.peek())){
                orders.poll();
                con.poll();
                answer++;
                continue;
            }
            
            // 다른데
            // 보조 컨테이너가 비어있지 않고, 같다면
            if(!sub.isEmpty() && orders.peek().equals(sub.peek())){
                orders.poll();
                sub.pop();
                answer++;
                continue;
            }
            
            // 다른데 현재 상자가 주문보다 더 작다면
            if(!con.isEmpty() && con.peek() < orders.peek()) {
                sub.push(con.poll());
                continue;
            }
            
            // 다른데 현재 상자가 주문보다 더 크다면
            if(con.isEmpty() || con.peek() > orders.peek()) break;
        }
    
        // 2. 정답 출력
        return answer;
    }
}

// 택배 기사님이 미리 알려준 순서에 맞게 영재가 택배상자를 실어야 함
// 보조 컨테이너 벨트는 앞 뒤로만 이동이 가능 -> 스택
// 보조 컨테이너 벨트를 이용해도 기사님이 원하는 순서대로 상자를 못실으면 더 이상 상자를 싣지 않음

// [1, 2, 3, 4, 5]
// [4, 3, 1, 2, 5]  [2, 1]
// 1 2 3 4 5
// 5 4 3 2 1 [4 3 2 1]
