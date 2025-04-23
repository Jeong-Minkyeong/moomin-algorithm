import java.io.*;
import java.util.*;

class Solution {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(visited[i] == true) continue;
            bfs(i, computers);
            answer++;
        }
        return answer;
    }
    
    public void bfs(int start, int[][] computers){
        // Queue
        Queue<int[]> q = new LinkedList<>();
        
        // Queue에 넣기
        q.add(computers[start]);
        
        // 방문
        visited[start] = true;
        
        // 탐색
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            for(int i = 0; i<temp.length; i++){
                if(temp[i] == 0 || visited[i] == true) continue;
                visited[i] = true;
                q.add(computers[i]);
            }
        }
    }
}

// 네트워크의 갯수 = 탐색 횟수