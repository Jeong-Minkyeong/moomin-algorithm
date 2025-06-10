import java.io.*;
import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int N = arr1.length;
        int M = arr2[0].length;
        int K = arr1[0].length;
        int[][] answer = new int[N][M];
        
        // arr1가로줄 x arr2세로줄이 한 for문
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                int sum = 0;
                for(int k = 0; k<K; k++){
                    sum += (arr1[i][k] * arr2[k][j]);
                }
                
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}
