import java.util.*;

class Solution {
    static int count;
    static List<int[]>[] arr;
    static int[][] visited;
    
    static Set<Integer> time = new HashSet<>();
    static HashMap<Integer, List<int[]>> moveMap = new HashMap<>();
    
    public int solution(int[][] points, int[][] routes) {
        // - 준비
        arr = new ArrayList[routes.length];
        for(int i = 0; i<routes.length; i++){
            arr[i] = new ArrayList<>(); 
        }
    
        int answer = 0;
        
        // - 탐색
        for(int i = 0; i<routes.length; i++){
            count = 0;
            for(int j = 0; j<routes[i].length-1; j++){
                // 시작
                if(j == 0){
                arr[i].add(new int[]{points[routes[i][j]-1][0], points[routes[i][j]-1][1]});}
                System.out.println(points[routes[i][j]-1][0] + " " + points[routes[i][j]-1][1]);
                move(points[routes[i][j]-1], points[routes[i][j+1]-1], i);
            }
            // 끝
            //arr[i].add(new int[]{points[routes[i][routes[i].length-1]-1][0], points[routes[i][routes[i].length-1]-1][1]});
            // System.out.println(points[routes[i][routes[i].length-1]-1][0] + " " + points[routes[i][routes[i].length-1]-1][1]);
        }
        
        // 가장 긴 초 찾기
        int maxTime = 0;
        for(List<int[]> a : arr){
            maxTime = Math.max(a.size(), maxTime);
        }
        
        // 초별로 충돌 위치 찾기
        for(int i = 0; i<maxTime; i++){
            visited = new int[101][101];
            for(List<int[]> a : arr){
                if(a.size() <= i) continue;
                
                if(visited[a.get(i)[0]][a.get(i)[1]] > 1) continue;
                
                if(visited[a.get(i)[0]][a.get(i)[1]] == 1) {
                    answer++;
                    //System.out.println("충돌: " + a.get(i)[0] + " " + a.get(i)[1]);
                }
                visited[a.get(i)[0]][a.get(i)[1]] += 1;
            }
        }
        
        System.out.println(maxTime);
        
        // - 정답 출력
        return answer;
    }
    
    // 로봇 지나가는 경로 계산
    public void move(int[] startPoint, int[] endPoint, int num) {
        
        // 세로 계산
        // 남쪽이동
        if(startPoint[0] < endPoint[0]){
            for(int i = startPoint[0]+1; i<=endPoint[0]; i++){
                arr[num].add(new int[]{i, startPoint[1]});
                //System.out.println(i + " " + startPoint[1]);
            }
        }
        
        // 북쪽이동
        if(startPoint[0] > endPoint[0]){
            for(int i = startPoint[0]-1; i>=endPoint[0]; i--){
                arr[num].add(new int[]{i, startPoint[1]});
                //System.out.println(i + " " + startPoint[1]);
            }
        }
        
        // 가로 계산
        // 동쪽이동
        if(startPoint[1] < endPoint[1]){
            for(int i = startPoint[1]+1; i<=endPoint[1]; i++){
                arr[num].add(new int[]{endPoint[0], i});
                //System.out.println(endPoint[0] + " " + i);
            }
        }
        
        // 서쪽이동
        if(startPoint[1] > endPoint[1]){
            for(int i = startPoint[1]-1; i>=endPoint[1]; i--){
                arr[num].add(new int[]{endPoint[0], i});
               // System.out.println(endPoint[0] + " " + i);
            }
        }
    }
}

// 
// 물류센터는 2차원 좌표
// n개의 포인트 존재
// 로봇마다 정해진 운송 경로 존재
// 운송 경로는 m개의 포인트로 구성 -> 순서대로 방문
// 로봇은 상하좌우로만 움직임
// 항상 최단 경로로 이동하며 여러가지일때는 항상 세로로 먼저 이동
// 충돌하는 상황이 위험상황
// 위험상황이 총 몇번 ?
// 포인트는 [세로, 가로] 임
// 경로는 [시작 포인트, 도착 포인트]
// 충돌은 초랑 위치가 모두 동일해야함 
// - 2차원 배열로 위치 저장 후
// - 초당 위치 좌표로 비교 



