import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 슬라이딩 윈도우

    static int checkArr[] = new int[4];
    static int myArr[] = new int[4];
    static int checkSecret = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int count = 0;

        char[] dnaArr = new char[s];
        dnaArr = bf.readLine().toCharArray();

        // 입력받기
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        // 초기값
        for (int i = 0; i < p; i++) {
            addCheckSecret(dnaArr[i]);
        }

        if (checkSecret == 4) count++;

        // 슬라이딩 윈도우
        for (int i = p; i<s; i++){
            int j = i-p;
            addCheckSecret(dnaArr[i]);
            removeCheckSecret(dnaArr[j]);
            if (checkSecret == 4) count++;
        }
        System.out.println(count);
    }

    private static void removeCheckSecret(int j) {
        switch (j) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
            default:
                break;
        }
    }

    private static void addCheckSecret(int i) {
        switch (i) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
            default:
                break;
        }
    }
}
