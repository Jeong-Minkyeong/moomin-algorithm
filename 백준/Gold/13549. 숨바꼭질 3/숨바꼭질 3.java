import java.io.*;
import java.util.*;

class Move {
    int x; // 현재위치
    int w; // 이동 가중합

    public Move(int x, int w) {
        this.x = x;
        this.w = w;
    }
}
public class Main {
    static int N, K;
    static boolean[] visited;
    static int[] moving = {2, -1, 1};

    public static void main(String[] args) throws IOException {

        // 수빈, 동생 위치 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 탐색
        if(N == K){
            System.out.println(0);
            return;
        }
        잡았다요놈(N);
    }

    public static void 잡았다요놈(int n) {

        // Q세팅
        Queue<Move> q = new LinkedList<>();

        visited = new boolean[100001];

        // 큐에 넣기
        q.add(new Move(n, 0));

        // 방문처리
        visited[n] = true;

        while (!q.isEmpty()) {
            Move move = q.poll();

            for (int i = 0; i < moving.length; i++) {
                int m;
                if (i == 0) {
                    m = move.x * moving[i];

                    if (m == K) {
                        System.out.println(move.w);
                        return;
                    }

                    if (m < 0 || m > 100000 || visited[m] == true) {
                        continue;
                    }

                    // System.out.println(m);

                    //queue 저장
                    q.add(new Move(m, move.w));

                    // 방문 처리
                    visited[m] = true;

                    continue;
                }
                m = move.x + moving[i];

                if (m == K) {
                    System.out.println(move.w + 1);
                    return;
                }

                if (m < 0 || m > 100000 || visited[m] == true) {
                    continue;
                }

                // System.out.println(m);

                //queue 저장
                q.add(new Move(m, move.w+1));

                // 방문 처리
                visited[m] = true;
            }
        }
    }
}

