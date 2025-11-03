import java.util.*;

class Solution {
    static String[] open = {"(", "{", "["};
    static String[] close = {")", "}", "]"};
    static Set<String> openSet;
    static Set<String> closeSet;
    public int solution(String s) {
        // - 준비
        int answer = 0;
        
        // - 탐색
        openSet = new HashSet<>(Arrays.asList(open));
        closeSet = new HashSet<>(Arrays.asList(close));
        for(int i = 0; i<s.length(); i++){
            String str = s.substring(i, s.length()) + s.substring(0, i);
            //System.out.println(i + " " + str);
            if(check(str)) answer++;
        }
        
        // 정답 출력
        return answer;
    }
    
    // 올바른 괄호인지 체크
    public boolean check(String s){
        ArrayDeque<String> s1 = new ArrayDeque<>();
        ArrayDeque<String> s2 = new ArrayDeque<>();
        
        for(int i = 0; i<s.length(); i++){
            s1.push(s.substring(i, i+1));
        }
        
        // 하나씩 꺼내기
        while(!s1.isEmpty()){
            String temp = s1.pop();
            
            if(closeSet.contains(temp)){
                s2.push(temp);
                continue;
            }
            
            if(openSet.contains(temp)){
                // 비어있다면
                if(s2.isEmpty()){
                    return false;
                }
                
                 // 짝꿍이 있다면
                String busket = temp + s2.peek();
                //System.out.println(busket);
                if(busket.equals("()") || busket.equals("{}") || busket.equals("[]")) {
                    s2.pop();
                    continue;
                }
                
                // 짝꿍이 없다면
                return false;
            }
        }
        
        if(!s2.isEmpty()) return false;
        
        return true;
    }
}

// 왼쪽으로 x칸만큼 회전했을때,
// s가 올바른 괄호 문자열이 되게 하는 x의 갯수
// 접근: 빡구현? 하나씩 돌려가면서 비교 
// 시간복잡도: 1000 3중 루프까지 가능
// 덱을 한번 사용해보자