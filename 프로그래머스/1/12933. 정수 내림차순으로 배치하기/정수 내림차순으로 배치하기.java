import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = n + "";
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        
        StringBuilder sb = new StringBuilder(new String(charArr));
        
        answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }
}