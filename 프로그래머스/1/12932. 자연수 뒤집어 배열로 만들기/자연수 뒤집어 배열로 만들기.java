import java.util.ArrayList;

class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        StringBuilder sb = new StringBuilder(s).reverse();
        
        int[] answer = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            answer[i] = sb.charAt(i) - '0';
        }
        
        return answer;
    }
}