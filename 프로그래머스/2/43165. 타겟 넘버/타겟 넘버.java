import java.io.*;
import java.util.*;

class Solution {
    int[] x = {1, -1};
    int sum;
    int ans = 0;
    public int solution(int[] numbers, int target) {
        
        // 탐색
        dfs(0, target, numbers);
        
        return ans;
    }
    
    public void dfs(int count, int target, int[] numbers){
        if(count == numbers.length) {
            //System.out.print(count + " ");
            if(sum == target) {
                //System.out.print(sum + " ");
                ans++;
            }
            return;
        }
        
        for(int i = 0; i<x.length; i++) {
            sum += numbers[count] * x[i];
            //System.out.print(count + " " + sum + " ");
            dfs(count+1, target, numbers);
            sum -= numbers[count] * x[i];
        }
    }
}