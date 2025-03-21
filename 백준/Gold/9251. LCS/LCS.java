import java.io.*;

public class Main {
    static String[] a;
    static String[] b;
    static int[][] memo;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        // 두 문자열 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder(br.readLine());

        a = new String[sb.length()+1];
        for(int i = 1; i<a.length; i++){
            a[i] = sb.substring(i-1, i);
        }

        sb = new StringBuilder(br.readLine());

        b = new String[sb.length()+1];
        for(int i = 1; i<b.length; i++){
            b[i] = sb.substring(i-1, i);
        }

        // 탐색 시작
        memo = new int[a.length][b.length];
        for(int i = 1; i<a.length; i++) {
            int count = 0;
            for (int j = 1; j < b.length; j++) {
                if (a[i].equals(b[j])) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    count = memo[i][j];
                    continue;
                }
                memo[i][j] = Math.max(memo[i-1][j], count);
            }
        }
        System.out.println(memo[a.length-1][b.length-1]);
    }
}