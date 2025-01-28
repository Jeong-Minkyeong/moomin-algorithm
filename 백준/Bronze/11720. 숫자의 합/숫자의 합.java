import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        long answer = 0;

        // 100자리 수를 받으려면 String 타입으로 입력을 받아야 함
        String num = bf.readLine();
        for(int i = 0; i<n; i++){
            answer += Character.getNumericValue(num.charAt(i));
        }
        System.out.println(answer);
    }
}
