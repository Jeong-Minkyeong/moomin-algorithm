import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        // start, end 세팅
        long start = times[0];
        long end = (long) n*times[0];
        
        // 탐색
        while(start <= end) {
            long mid = (start + end) / 2;
            
            // 조건
            long count = 0;
            for(int i = 0; i<times.length; i++){
                count += mid / times[i];
            }
            
            // start, end값 조절
            if(n <= count) {
                // count가 더 크다면 end값 조절
                end = mid - 1;
                continue;
            }
            start = mid + 1; 
        }
        
        // 정답
        answer = start;
        return answer;
    }
}

// 심사대 시간계산을 어떻게?
// 시간은 0초부터 42초까지
