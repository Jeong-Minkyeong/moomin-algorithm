import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[]args) throws IOException {

        // N, S, R 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 카약 팀 선수들 받기
        int[] C = new int[N];
        for(int i = 0; i<N; i++){
            C[i] = 1;
        }

        // 카약이 손상팀 번호 받기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<S; i++){
            C[Integer.parseInt(st.nextToken())-1] -= 1;
        }

        // 카약을 더 가져온 팀 받기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++){
            C[Integer.parseInt(st.nextToken())-1] += 1;
        }

        // 카약이 손상된 팀의 -혹은 +가 있으면 출전 가능
        // 처음번은 2번한테만 빌릴 수 있고
        // 마지막번은 직전한테만 빌릴 수 있음
        // 1,5을 먼저 처리 ?
        if(C[0] == 0 & C[1] == 2){
            C[0] += 1;
            C[1] -= 1;
        }
        if(C[N-1] == 0 & C[N-2] == 2){
            C[N-1] += 1;
            C[N-2] -= 1;
        }

//        for(int c: C){
//            System.out.print(c + " ");
//        }

        int start, end;

        // 나머지 카약 처리
        for(int i = 1; i<N-1; i++){
            start = (i-1);
            end = (i+1);
            if(C[i] == 0 ) {
                if(C[start] == 2){
                    C[start] -= 1;
                    C[i] += 1;
                    continue;
                }
                if(C[end] == 2){
                    C[end] -= 1;
                    C[i] += 1;
                }
            }
        }

        // 정답 출력
        int answer = 0;
        for(int c: C){
            if(c == 0){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
