import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String ans = n + "";
        
        for (int i = 0; i<ans.length();i++){
            answer += Character.getNumericValue(ans.charAt(i));
        }
        return answer;
    }
}