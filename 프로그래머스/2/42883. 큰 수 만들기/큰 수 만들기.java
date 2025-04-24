import java.util.*;
import java.io.*;

// 어려움,,
class Solution {
    StringBuilder ans = new StringBuilder();
    public String solution(String number, int k) {
       
        int max = 0;
        int index = 0;
        for(int i = 0; i<number.length() - k; i++){
            max = 0;
            for(int j = index; j<=k+i; j++){
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j+1;
                }   
            }
            ans.append(max);
        }
        String answer = ans.toString();
        return answer;
    }
}
 