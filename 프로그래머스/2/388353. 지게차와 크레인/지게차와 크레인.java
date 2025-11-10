import java.util.*;

class Solution {
    static int N, M;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean[][] visited;
    static String[][] arr;
    static int cnt = 0;
    
    public int solution(String[] storage, String[] requests) {
        // - 준비
        int answer = 0;
        N = storage.length;
        M = storage[0].length();
        visited = new boolean[N][M];
        arr = new String[N][M];
        
        // 창고 만들기
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                arr[i][j] = storage[i].substring(j, j+1);
            }
        }
        
        // - 탐색
        for(String s : requests) {
            // 지게차로 접근해야 한다면
            if(s.length() == 1){
                takeForklift(s);
                continue;
            }
            
            // 크레인으로 접근해야 한다면
            takeCrane(s.substring(0, 1));
        }
        
        
        // - 정답 출력
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(!visited[i][j]) answer++;
            }
        }

        return answer;
    }
    
    // 지게차 사용
    public void takeForklift(String s) {
            boolean[][] tempVisited = new boolean[N][M];
            ArrayList<int[]> container = new ArrayList<>();
            Queue<int[]> queue = new LinkedList<>();

            // 1️⃣ 외부 전체에서 BFS 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
                        if (!tempVisited[i][j]) {
                            queue.add(new int[]{i, j});
                            tempVisited[i][j] = true;
                        }
                    }
                }
            }

            // 2️⃣ BFS 탐색
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int y = cur[0];
                int x = cur[1];

                // 3️⃣ 꺼낼 수 있는 컨테이너면 기록
                if (arr[y][x].equals(s) && !visited[y][x]) {
                    container.add(new int[]{y, x});
                }

                // 4️⃣ 사방 탐색
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                    if (tempVisited[ny][nx]) continue;

                    // 5️⃣ 빈 공간(꺼낸 자리)만 통과 가능
                    if (visited[y][x]) {
                        queue.add(new int[]{ny, nx});
                        tempVisited[ny][nx] = true;
                    }
                }
            }

            // 6️⃣ 실제 컨테이너 꺼내기
            for (int[] c : container) {
                visited[c[0]][c[1]] = true;
            }
        }

     
    // 크레인 사용
    public void takeCrane(String s) {
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(arr[i][j].equals(s)){
                    visited[i][j] = true;
                }
            }
        }
    }
}

// 세로 n / 가로 m -> 가로와 세로는 다를 수 있음
// 길이 50이어서 완전탐색도 사실상 나쁘지 않음 (?)
// 4면중 적어도 1면이 창고 외부와 연결된 컨테이너
// 크레인을 사용하면 요청된 종류의 모든 컨테이너를 꺼냄
// 알파벳이 하나일경우 접근 가능한 컨테이너만 꺼낸ㅁ
// 알파벳이 두개 이상일 경우 모든 종류의 컨테이너를 꺼냄
// 모든 요청을 순서대로 완료한 후 남은 컨테이너 수를 return
// 하나일 경우 어떻게 접근하면 좋을까? 
// -> 테두리만 접근해야함 (사방면 중 한면이라도 초과하거나 방문배열일 경우)
// 두개일 경우 어떻게 접근하면 좋을까? -> 완전 탐색 혹은 BFS로
// temp가 false일경우 사방면이 false일 경우
