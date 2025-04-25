import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        // 통과할 수 없는 경우는? -> s가 n보다 작은 경우
        if(s < n){
            return new int[]{-1};
        }
        
        // n으로 나누어 떨어지면
        if(s % n == 0){
            for(int i = 0; i<n; i++){
                answer[i] = s / n;
            }
            return answer;
        }
        
        // n으로 나누어 떨어지지 않으면
        int temp = s % n; // 나머지 저장
        for(int i = 0; i<n; i++){
            answer[i] = s / n;
        }
        
        for(int i = 0; i<temp; i++){
            answer[i] += 1;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}