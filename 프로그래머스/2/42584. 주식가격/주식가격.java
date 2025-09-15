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
                    // answer[i] = answer[stack1.peek()[0]] + (stack1.peek()[0] - i);
                    // stack1.push(new int[]{i, prices[i]});
                    continue;
                }
                answer[i] = stack1.peek()[0] - i;
            }
        }
        // 2. 정답 출력
        return answer;
    }
}
//
// 입력값 〉 [3, 5, 2, 6, 7, 8, 1, 10, 9]
// 기댓값 〉 [2, 1, 4, 3, 2, 1, 2, 1, 0]
//       for(int i = prices.length-1; i>=0; i--){
//             // 마지막 시점일 경우 바로 stack1
//             if(stack1.isEmpty()) {
//                 stack1.push(prices[i]);
//                 answer[i] = 0;
//                 continue;
//             };
            
//             // 바로 가격이 떨어질 경우 (stack1 최상단보다 클 경우)
//             if(stack1.peek() < prices[i]){
//                 stack1.push(prices[i]);
//                 answer[i] = 1;
//                 continue;
//             }
            
//             while(!stack1.isEmpty()) {
//                 if(stack1.peek() < prices[i]) break;
//                 stack2.push(stack1.pop());
//             }
//             answer[i] = stack2.size();
//             // System.out.print(stack2.size());
            
//             // 원복
//             while(!stack2.isEmpty()){
//                 stack1.push(stack2.pop());
//             }
//             stack1.push(prices[i]);
//         }
    
//         // 2. 정답 출력
//         return answer;

    