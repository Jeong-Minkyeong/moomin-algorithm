import java.util.*;

class Solution {
    static Set<Integer> left = new HashSet<>();
    static Map<Integer, Integer> right = new HashMap<>();
    
    public int solution(int[] topping) {
        // - 준비
        int answer = 0;
        
        // 경계값 정리
        if(topping.length == 1){
            return answer;
        }
        
        // 처음 세팅
        // leftSet.add(topping[0]);
        for(int i = 0; i<topping.length; i++){
            if(right.get(topping[i]) == null) {
                right.put(topping[i], 1);
                continue;
            }
            right.put(topping[i], right.get(topping[i]) + 1);
        }
        
        // 탐색
        for(int i = 0; i<topping.length; i++){
            int t = topping[i];
            
            // 왼쪽 토핑 추가
            left.add(t);
            
            // 오른쪽 토핑 삭제
            right.put(t, right.get(t) - 1);
            if(right.get(t) == 0){
                right.remove(t);
            }
            
            if(left.size() == right.size()) answer++;
        }
        
        // 정답 출력
        return answer;
    }
}

// 잘린 조각들의 크기와 올려진 토핑의 갯수에 상관없이 동일한 가짓수의 토핑이 올라가면 장땡
// 가짓수만 같으면 공평한 것
// 공평하게 자르는 방법의 수 알아보기
// 자르는 함수
// 가짓수 count 함수
// 완전 탐색은 절대 아님 -> 투포인터로 풀기?
// 가운데서 출발한다면 ? 불균형이 되는 순간 pass