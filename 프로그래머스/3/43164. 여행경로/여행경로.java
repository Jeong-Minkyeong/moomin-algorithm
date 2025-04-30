import java.util.*;
import java.io.*;

class Solution {
    boolean[] visited;
    boolean isFinished;
    ArrayList<String> answer = new ArrayList<>();
    
    public ArrayList<String> solution(String[][] tickets) {
        
        // 항공권 정렬
        Arrays.sort(tickets, (a, b) -> {
            return a[1].compareTo(b[1]);
        });
        
        // 탐색
        visited = new boolean[tickets.length];
        answer.add("ICN");
        dfs("ICN", tickets, 0);
        
        return answer;
    }
    
    // 탐색
    public void dfs(String s, String[][] tickets, int count){
        
        if (isFinished) return;

         // 길이가 전체 항공권이랑 같다면?
        if(count == tickets.length){
            isFinished = true; // 가장 빠른 경로 찾았으면 종료
            return;
        }
        
        for(int i = 0; i<tickets.length; i++){
            if(visited[i] == true) continue;
            
            if(s.equals(tickets[i][0])){
                visited[i] = true;
                answer.add(tickets[i][1]);
                
                dfs(tickets[i][1], tickets, count+1);
                if (isFinished) return;
    
                answer.remove(answer.size()-1);
                visited[i] = false;
            }
        }
    } 
}
