import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 준비
        HashMap<String, Integer> hash = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i<want.length; i++){
            hash.put(want[i], number[i]);
        }
        
        // 탐색
        int count = 0;
        HashMap<String, Integer> bucket = new HashMap<>(hash);
        
        // 10개씩 끊어서 탐색
        for(int i = 0; i<discount.length; i++) {
            
            // want에 없는 상품이라면
            if(bucket.get(discount[i]) == null){
                bucket = new HashMap<>(hash);
                count = 0;
                continue;
            }
            
            count++;
            
            // count가 10개째 이상이면
            if(count >= 10) {
                System.out.println(count);
                // 잘 샀는지 비교
                bucket.put(discount[i], bucket.get(discount[i]) - 1);
                
                if(isEquals(bucket)) answer++;
                
                // 맨 뒤의 값 제외
                bucket.put(discount[i-9], bucket.get(discount[i-9]) + 1);
                continue;
            }
            
            // count가 10 이하이면
            bucket.put(discount[i], bucket.get(discount[i]) - 1);
        }
    
        // 정답 출력
        return answer;
    }
    
    public boolean isEquals(HashMap<String, Integer> bucket) {
        for(String s : bucket.keySet()) {
            if(bucket.get(s) != 0){
                return false;
            }
        }
        return true;
    }
}



// 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입
// 배열은 한번만 탐색이 가능 (시간복잡도)
// 원하는 제품을 다 살 수 있을 때까지 
// 수량은 무조건 10개 
// hash에 무엇을 보관할 것인가
// 해당 제품이 없음 -> 해당 제품 앞으로 jump
// 수량이 마이너스(다 살 수 없다면 무조건 마이너스임) 되면 Pass
// 있으면 구매
// 10일 연속이면 count
