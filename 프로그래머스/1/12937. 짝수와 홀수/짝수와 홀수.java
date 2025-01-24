class Solution {
    public String solution(int num) {
        String Odd = "Odd";
        String Even = "Even";
            
            if (num % 2 == 0) {
                return Even;
            }
            return Odd;
    }
}