import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 0. 준비
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        
        // 1. 탐색
        // 참여자 수 count
        for(String s : participant) {
            if(hash.containsKey(s)){
                hash.put(s, hash.get(s) + 1);
                continue;
            }
            hash.put(s, 1);
        }
        
        // 완주한 만큼 -1
        for(String s : completion) {
            hash.put(s, hash.get(s) - 1);
        }
        
        // 완주 못한사람 물색
        for(String key : hash.keySet()) {
            if(hash.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        // 2. 정답 출력
        return answer;
    }
}
