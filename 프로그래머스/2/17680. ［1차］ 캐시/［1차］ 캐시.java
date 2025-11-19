import java.util.*;

class Solution {
    static ArrayDeque<String> deque = new ArrayDeque<>();
    static Map<String, Integer> cache = new HashMap<>();
    
    public int solution(int cacheSize, String[] cities) {
        // - 준비
        int answer = 0;
        
        // 경계값 미리 제거
        // if(cacheSize == 0){
        //     return cities.length * 5;
        // }
        
        // - 탐색
        for(String s : cities) {
            // 소문자 변환
            String city = s.toUpperCase();
            
            // Deque 사이즈가 cacheSize 보다 작을 경우
            if(deque.size() < cacheSize) {
                // miss
                if(cache.get(city) == null){
                    cache.put(city, 1);
                    deque.add(city);
                    answer += 5;
                    continue;
                }
            
                // hit
                answer += 1;
                deque.remove(city);
                deque.add(city);
                continue;
            }
            
            // cacheSize 보다 같거나 클 경우
            // miss
            if(cache.get(city) == null) {
                answer += 5;
                cache.put(city, 1);
                deque.add(city);
                cache.remove(deque.poll());
                continue;
            }
            
            // hit
            answer += 1;
            deque.remove(city);
            deque.add(city);
            continue;
        }
        
        
        // - 정답 출력
        return answer;
    }
}

// [문제 이해]
// DB 캐시를 적용할 때 캐시 크기에 따른 실행 시간 측정 프로그램을 작성해라
// 캐시 크기(최대 30)와 도시이름 배열이 주어짐
// 영문자로 구성 및 대소문자 구분 하지 않음
// 입력된 도시이름 배열을 순처대로 처리할 때, 총 실행시간 출력
// 캐시 교체 알고리즘은 LRU -> 가장 오랫동안 안쓴거 교체
// hit일 경우 실행시간 1
// miss일 경우 실행시간 5

// [풀이]
// 탐색할때는 모두 소문자 or 대문자로
// 주어진 캐시 크기에 맞춰서 어떻게 보관을 하면 좋을까? 
// Set (x, 가장 마지막이 뭐였는지 모름) / ArrayDeque (회전으로 찾아볼까)
// 조건을 잘 나누어야 할 것 같음
// Deque 사이즈가 cacheSize 보다 작다면
// 안에 있으면 hit 후 삽입
// 안에 없으면 miss 후 삽입
//  ""       보다 크다면
// Deque에 있다면, hit 으로 계산
// Deque에 없다면, miss 로 계산 후 가장 뒤에 있는 원소 삭제
// 탐색시간 100000 * 30 이어서 시간초과 걱정은 놉
// Map으로 관리해줘도 괜찮겠다