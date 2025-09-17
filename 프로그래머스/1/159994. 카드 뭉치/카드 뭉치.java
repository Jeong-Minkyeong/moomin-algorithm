import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        // 0. 준비
        String answer = "";
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        for(String s : cards1){
            q1.add(s);
        }
        
         for(String s : cards2){
            q2.add(s);
        }

         // 1. 탐색
        for(String s : goal) {
            
            if(!q1.isEmpty() && q1.peek().equals(s)) {
                q1.poll();
                continue;
            }

            if(!q2.isEmpty() && q2.peek().equals(s)) {
                q2.poll();
                continue;
            }
            answer = "No";
            return answer;
        }
        answer = "Yes";
        return answer;
    }
}