import java.util.*;

class Node {
    
    int y, x, cost;
    
    public Node(int y, int x, int cost){
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
}


class Solution {
    static int N, M;
    static int[] dy = {0, 1, -1, 0};
    static int[] dx = {1, 0, 0, -1};
    static String[][] arr;
    static boolean[][] visited;
    static int[] start = new int[2];
    static int[] lever = new int[2];
    static int[] exit = new int[2];
    
    public int solution(String[] maps) {
        // - 준비
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        arr = new String[N][M];
        
        // 이차원 배열로 다시 만들기 + 시작점 찾기
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                String temp = maps[i].substring(j, j+1);
                arr[i][j] = temp;
                
                if(arr[i][j].equals("S")){
                    start[0] = i;
                    start[1] = j;
                    continue;
                }
                
                if(arr[i][j].equals("L")){
                    lever[0] = i;
                    lever[1] = j;
                    continue;
                }
                
                if(arr[i][j].equals("E")){
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        } 
        
        // - 탐색
        int leverCost = bfs(start[0], start[1], arr, lever, N, M);
        if(leverCost == 0){
            return -1;
        }
        
        // 출구 찾기
        int exitCost = bfs(lever[0], lever[1], arr, exit, N, M);
        if(exitCost == 0){
            return -1;
        }
        
        // - 정답 출력
        answer = leverCost + exitCost;
        return answer;
    }
    
    public int bfs(int y, int x, String[][] arr, int[] target, int N, int M){
        visited = new boolean[N][M];
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x, 0));
        visited[y][x] = true;
        
        while(!queue.isEmpty()){
            
            Node temp = queue.poll();
            
            if(temp.y == target[0] && temp.x == target[1]){
                return temp.cost ;
            }
            
            for(int i= 0; i<4; i++){
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= N || nx >= M|| arr[ny][nx].equals("X") || visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
                queue.add(new Node(ny, nx, temp.cost+1));
            }
        }
        return 0;
    }
}

// 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다
// 레버를 먼저 찾고 (출구도 그냥 통로)
// 출구를 찾기 (레버도 그냥 통로)
// 안전하게 BFS
// 시간초과가 안나기 위해서는 방문처리 ? 재방문하면 무조건 길어지는건가
