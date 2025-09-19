import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 0. 준비
        int answer = 0;
        Queue<int[]> q1 = new LinkedList<>();
        Stack<Integer> s1 = new Stack<>();
        
        
        for(int i = 0; i<priorities.length; i++){
            q1.add(new int[]{i, priorities[i]});
        }
        
        // 1. 탐색
        Arrays.sort(priorities);
        for(int i : priorities) {
            s1.push(i);
        }
        
        while(!q1.isEmpty()){
            if(s1.peek() == q1.peek()[1]){
                answer++;
                if(location == q1.peek()[0]) return answer;
                
                q1.poll();
                s1.pop();
                continue;
            }
            q1.add(q1.poll());
        }
        return answer;
    }
}


// 숫자가 클수록 우선순위가 높다!