import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 투포인터

    public static void main(String[] args) throws IOException {

        // N의 범위가 매우 큼으로 O(n)의 시간복잡도를 활용해야 함
        // 연속된 자연수의 합을 투포인터를 활용하여 구간을 찾는다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sIndex = 1;
        int eIndex = 1;
        int sum = 1;
        int count = 1;

        while(eIndex != n){
            if(sum == n) {
                count++;
                eIndex++;
                sum = sum + eIndex;
            }

            else if (sum > n){
                sum = sum - sIndex;
                sIndex++;
            }

            else if(sum < n) {
                eIndex++;
                sum = sum + eIndex;
            }
        }
        System.out.println(count);
    }
}
