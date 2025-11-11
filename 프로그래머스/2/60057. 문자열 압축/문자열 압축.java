import java.util.*;

class Solution {
    static String[] arr;
    public int solution(String s) {
        // - 준비
        int answer = 1000;
        arr = new String[s.length()/2];
        
        // 경계값 제거
        if(s.length() == 1){
            answer = 1;
            return answer;
        }
        
        // - 탐색
        for(int i = 1; i<=s.length()/2; i++){
            // 압축하기
            String temp = compact(s, i);
            //System.out.println(temp);
            answer = Math.min(answer, temp.length());
        }
    
        // - 정답 출력
        return answer;
    }
    
    public String compact(String s, int size){
        int start = 0;
        int end = size;
        int count = 1;
        String ans = "";
        while(true) {
            // 현재
            String now = s.substring(start, end);
            
            // 남은 길이가 단위보다 작다면
            if(s.length()-end < size) {
                if(count == 1){
                    ans += s.substring(start, s.length());
                    break;
                }
                ans += count + s.substring(start, s.length());
                break;
            }
                
            // 다음
            String next = s.substring(end, end+size);
            
            start += size;
            end += size;
            
            // 같다면
            if(now.equals(next)){
                count++;
                continue;
            }
            
            // 다르다면
            if(count == 1){
                ans += now;
                count = 1;
                continue;
            }
            ans += count + now;
            count = 1;
        }
        
        // 남은 길이 붙이기
        // System.out.println(count); 
        // ans += s.substring(start, s.length());
        
        return ans;
    }
}

// 방법은 여러가지가 있겠으나
// 앞에서부터 하나씩 증가시켜가면서 자르기 -> 시간초과

// 2중 반복 까지는 괜찮음
// 단어의 길이의 절반이 넘어가면 자를 수가 없음, 반복은 절반의 길이까지
// 자르다 남는건 그대로 붙이기

// 방법 1 - 단어장을 만들어 잘라서 보관(단어 : 숫자) -> 나중에 어떻게 합칠꺼
// 방법 2 - 앞에서부터 잘라가면서 이전조각과 현재 조각이 같으면 압축 -> 압축안되도 그대로 유지
// "aab bac cc"  >  2a2ba3c
// now = aa next == bb now == next count++;
// now != next string+now now = next count = 0
// 1-3 / 3-6 / 6-9