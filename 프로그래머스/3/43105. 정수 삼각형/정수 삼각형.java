import java.io.*;
import java.util.*;

class Solution {
    int[][] memo;
    int[][] arr;
    int n;
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 배열 준비
        n = triangle.length;
        arr = new int[n][n*2+1];
        
        for(int i = 0; i<n; i++){
            int index = n-i;
            for(int j = 0; j<triangle[i].length; j++){
                arr[i][index+j*2] = triangle[i][j];
            }
        }
        
        // 메모 초기값 넣어놓기
        memo = new int[n][n*2+1];
        for(int i = 0; i<n*2; i++){
            memo[0][i] = arr[0][i];
        }
        
        // 탐색
        for(int i = 1; i<n; i++){
            for(int j = 1; j<n*2; j++) {
                memo[i][j] = Math.max(arr[i][j] + memo[i-1][j-1], arr[i][j] + memo[i-1][j+1]);
            }
        }
        
        
        for(int i = 1; i<n*2; i++){
            answer = Math.max(answer, memo[n-1][i]);
        }
    
        return answer;
    }
    
}

// 현재 = 이전에서 더해질 수 있는 가장 큰 값