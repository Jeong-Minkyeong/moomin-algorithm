import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        
        // 0. 준비
        // 스택 준비
        Stack<int[]> stack1 = new Stack<>();
        
        // 답안 배열 준비
        int[] answer = new int[prices.length];
        
        // 1. 탐색
        // prices를 거꾸로 순회
        for(int i = prices.length-1; i>=0; i--){
            // 마지막일 경우 바로 push
            if(stack1.isEmpty()) {
                stack1.push(new int[]{i, prices[i]});
                answer[i] = 0;
                continue;
            }
            
            // 감소하는 경우
            if(prices[i] > prices[i+1]) {
                answer[i] = 1;
                stack1.push(new int[]{i+1, prices[i+1]});
                continue;
            }
            
            // 증가하거나 같은 경우
            if(prices[i] <= prices[i+1]){
                if(stack1.peek()[1] >= prices[i]){
                    int d =  0;
                    for(int j = stack1.size()-1; j>=0; j--){
                        if(stack1.elementAt(j)[1] < prices[i]){
                            d = j;
                            break;
                        }
                    }
                    answer[i] = stack1.elementAt(d)[0] - i;
                    continue;
                }
                answer[i] = stack1.peek()[0] - i;
            }
        }
        // 2. 정답 출력
        return answer;
    }
}
    