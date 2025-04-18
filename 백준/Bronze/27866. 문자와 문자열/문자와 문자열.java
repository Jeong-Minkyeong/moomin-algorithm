import java.io.*;

public class Main {
    static StringBuilder sb;
    static int i;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder(br.readLine());
        i = Integer.parseInt(br.readLine());

        System.out.println(sb.substring(i-1, i));
    }
}