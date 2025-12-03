import java.util.*;

class Solution {
    static String alpha = "AEIOU";
    static String[] arr;
    static boolean[] visited;
    static int count = 0;
    static int answer;
    
    public int solution(String word) {
        // - 준비
        answer = 0;
        
        arr = new String[alpha.length()];
        visited = new boolean[alpha.length()];
        for(int i = 0; i<alpha.length(); i++){
            arr[i] = alpha.substring(i, i+1);
        }
        
    
        
        // - 탐색
        findWord("", word, alpha.length());
        
        // - 정답 출력
        //answer = count;
        return answer;
    }
    
    public void findWord(String target, String word, int size) {
        
        if(target.length() == size) {
            return;
        }
        
        for(int i = 0; i<size; i++){
            count++;
            String temp = target + arr[i];
            // System.out.println(temp);
            
            if(temp.equals(word)) {
                answer = count;
            }
            findWord(temp, word, size);
        }
    }
}

// [문제 이해]
// 알파벳 모음으로만 사용해서 만들 수 있는 5 이하의 단어
// 시작은 A, 마지막은 UUUUU
// 단어 하나 word가 매개변수로 주어질 때
// 이 단어가 몇 번째 단어인지 알아내기

// [문제 풀이]
// 조합인데 DFS로 풀 수 있지 않을까 ?
// 