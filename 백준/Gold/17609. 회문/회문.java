import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        // N 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 문자열 입력받기
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            isPalindrome(s);
        }
        System.out.println(sb.toString().trim());
    }

    public static void isPalindrome(String s){

        // 투포인터 준비
        int start = 0;
        int end = s.length()-1;

        // 없애야 하는 글자 수
        int count = 0;

        // 탐색
        while(start<=end){

            // 같을때
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
                continue;
            }

            // 다른데 마지막일때!
            if(s.charAt(start) != s.charAt(end) && (end - start == 1)){
                count++;
                break;
            }

            // 회문이어서 다를때
            // 신중할 필요가 있음 - 어차피 한문자가 차이가 발생함, 그 사이에 있는 값이 무조건 회문이어야 함

            // 오른쪽을 당긴다면
            int left = start;
            int right = end-1;
            int notP = 0;

            while(left<=right){
                if(s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }
                notP = 1;
                break;
            }
            
            if(notP == 0){
                count = 1;
                break;
            }

            // 왼쪽을 당긴다면
            left = start+1;
            right = end;
            notP = 0;
            while(left<right){
                if(s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }
                notP = 1;
                break;
            }
            if(notP == 0){
                count = 1;
                break;
            }
            count = 2;
            break;
        }

        // 회문일때
        if(count == 0){
            sb.append(0).append('\n');
            return;
        }

        // 유사 회문일 때
        if(count == 1) {
            sb.append(1).append('\n');
            return;
        }

        // 모두 아닐때
        sb.append(2).append('\n');
    }
}
