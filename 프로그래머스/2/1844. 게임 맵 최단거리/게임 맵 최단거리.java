import java.util.*;

class Solution {
    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};
    int n;
    int m;
    int ans = Integer.MAX_VALUE;
    boolean[][] visited;
    int[][] score;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        // map의 크기
        n = maps.length;
        m = maps[0].length;
        
        // 탐색
        visited = new boolean[n][m];
        score = new int[n][m];
        bfs(0, 0, maps);
        
        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        
        return ans;
    }
    
    public void bfs(int y, int x, int[][] maps) {
        
        // Queue 준비
        Queue<int[]> q = new LinkedList<>();
        
        // Queue에 삽입
        q.add(new int[]{y, x});
        
        // 방문 처리
        visited[y][x] = true;
        score[y][x] = 1;
        
        // 반복
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            for(int i = 0; i<4; i++){
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || maps[ny][nx] == 0 || visited[ny][nx] == true) continue;
                
                if(ny == n-1 && nx == m-1){
                    ans = Math.min(ans, score[temp[0]][temp[1]]+1);
                    continue;
                }
                
                visited[ny][nx] = true;
                score[ny][nx] = score[temp[0]][temp[1]] + 1;
                
                q.add(new int[]{ny, nx});
            }
        } 
    }
}

// 둘다 가능하다면 웬만하면 bfs
// 가는 길이 막혀있는걸 어떻게 알지? 탐색이 끝났는데 최단거리가 최대정수라면