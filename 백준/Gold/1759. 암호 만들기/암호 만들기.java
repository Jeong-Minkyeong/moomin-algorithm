import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static String vowel = "aeiou";
    static char[] arr;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {

        // - 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<C; i++){
            sb.append(st.nextToken());
        }

        // - 탐색

        // 정렬
        String temp = sb.toString();
        char[] arr = temp.toCharArray();
        Arrays.sort(arr);

        // 암호 조합 만들기
        answer = new StringBuilder();
        dfs(0, "", arr);

        // - 정답 출력
        System.out.println(answer.toString().trim());
    }

    public static void dfs(int d, String pw, char[] arr) {
        // 만약 현재 pw 길이가 l과 같다면
        if(pw.length() == L) {
            // password 검증
            if(hasVowelAndConsonant(pw)) {
                answer.append(pw).append('\n');
            }
            return;
        }

        // 만약 깊이가 주어진 문자열 끝이라면
        if(d >= arr.length) return;

        dfs(d + 1, pw+arr[d], arr);
        dfs(d + 1, pw, arr);
    }

    private static boolean hasVowelAndConsonant(String password) {
        int vCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (vowel.contains(password.substring(i, i + 1))) vCount++;
        }

        return vCount >= 1 && password.length() - vCount >= 2;
    }
}
