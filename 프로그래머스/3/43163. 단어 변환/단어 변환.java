import java.io.*;
import java.util.*;

class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    boolean[] visited;
    int[] score;
    int targetNumber = -1;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // 그래프 만들기
        map.put(0, new ArrayList<>());
        match(0, begin, words);
        
        for(int i = 0; i<words.length; i++){
            if(words[i].equals(target)){
                map.put(i+1, new ArrayList<>());
                targetNumber = i+1;
                break;
            }
        }
        
        // target이 없다면 종료
        if(targetNumber == -1) {
            return 0;
        }
        
        for(int i = 0; i<words.length; i++){
            // target은 제외
            if(words[i].equals(target)) continue;
            
            map.put(i+1, new ArrayList<>());
            match(i+1, words[i], words);
        }
        
        // 탐색
        visited = new boolean[words.length+1];
        score = new int[words.length+1];
        
        bfs(0);
        
        answer = score[targetNumber]; 
        return answer;
    }
    
    // bfs 탐색
    public void bfs(int n){
        
        // Queue
        Queue<Integer> q = new LinkedList<>();
        
        // Queue에 삽입
        q.add(n);
        
        // 방문 처리
        visited[n] = true;
        
        while(!q.isEmpty()){
            int temp = q.poll();
            
            for(int i = 0; i<map.get(temp).size(); i++){
            
                // 방문 기록이 있다면
                if(visited[map.get(temp).get(i)] == true) continue;
                
                // 방문 기록이 없다면
                visited[map.get(temp).get(i)] = true;
                score[map.get(temp).get(i)] = score[temp] + 1;
                q.add(map.get(temp).get(i));
            }
        }  
    }
    
    
    // 그래프 생성
    public void match(int n, String s, String[] words){
        
        for(int i = 0; i<words.length; i++){
            int count = 0;
            for(int j = 0; j<s.length(); j++){
                // 내 자신이면 pass
                if(s.equals(words[i])) continue;
                
                if(s.charAt(j) != words[i].charAt(j)){
                    count++;
                }
            }
            
            if(count == 1){
                map.get(n).add(i+1);
            }
        }
    }
}

// 각 단어가 변환할 수 있는 단어로 그래프 만들기
// 각 단어까지의 최소 단계를 저장하는 배열 필요