import java.util.*;

class Solution {
    int[] dy = new int[]{-1, 0, 1, 0};
    int[] dx = new int[]{0, -1, 0, 1};
    public int solution(String dirs) {
        
        int answer = 0;
        // 방문기록 (상하좌우)
        // [[[false, false, false, false]]]
        //      U      D      L      R     
        boolean[][][] visited = new boolean[11][11][4];
        
        // 현재 위치 (실제로는 0, 0)
        int[] location = new int[]{5, 5}; 
        
        // 방문 탐색
        String s = "";
        int d = 0;
        for(int i = 0; i<dirs.length(); i++){
            // 어디로 갈까요
            s = dirs.substring(i, i+1);
            
            // 방향
            if(s.equals("U")) d = 0; 
            if(s.equals("L")) d = 1;
            if(s.equals("D")) d = 2;
            if(s.equals("R")) d = 3;
            
            // 캐릭터 이동
            int ny = location[0] + dy[d];
            int nx = location[1] + dx[d];
            
            if(ny < 0 || nx < 0 || ny > 10 || nx > 10) continue;
            
            if(visited[ny][nx][d] == true) {
                location[0] = ny;
                location[1] = nx;
                continue;
            }
            
            visited[ny][nx][d] = true;
            visited[location[0]][location[1]][(d+2)%4] = true;  // 반대 반향도 방문처리
            
            location[0] = ny;
            location[1] = nx;
            answer++;
        }
        return answer;
    }
}