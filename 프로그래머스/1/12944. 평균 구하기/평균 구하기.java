class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double sum = 0;
        for (int e : arr) {
            sum += e;
        }
        answer = sum / arr.length;
        return answer;
    }
}