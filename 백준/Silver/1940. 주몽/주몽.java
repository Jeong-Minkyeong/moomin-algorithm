import java.util.Arrays;
import java.util.Scanner;

public class Main { // 투포인터

    public static void main(String[] args){

        // 1 2 3 4 5 7 로 9를 몇 개?
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        int sIndex = 0;
        int eIndex = n-1;
        int count = 0;
        int sum;

        Arrays.sort(arr); // 정렬의 시간 복잡도는 O(nlogn)

        while(sIndex < eIndex){
            sum = arr[sIndex] + arr[eIndex];
            if(sum == M) {
                count++;
                sIndex++;
                eIndex--;
            } else if (sum < M) {
                sIndex++;

            } else if (sum > M){
                eIndex--;
            }
        }
        System.out.println(count);
    }
}
