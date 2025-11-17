import java.util.*;
// 11:35

class Solution {
    
    static List<int[]> passwords = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        // - 준비
        answer = 0;
        
        // 방문 배열 및 후보 숫자 배열 준비
        arr = new int[n];
        visited = new boolean[n];
        for(int i = 1; i<=n; i++){
            arr[i-1] = i;
        }
    
        // - 탐색
        int[] pw = new int[5];
        makePassword(0, pw, 0, n, q, ans);
        
        // - 정답 출력
        return answer;
    }
    
    public void makePassword(int start, int[] pw, int count, int size, int[][] q, int[] ans){
        
        if(count == 5){
            if(findpassword(pw, q, ans)){
                answer++;
            }
            return;
        }
        
        for(int i = start; i<size; i++){
            
            // 이미 방문했다면 pass
            if(visited[i]) continue;
            
            visited[i] = true;
            pw[count] = arr[i];
            makePassword(i+1, pw, count+1, size, q, ans);
            visited[i] = false;   
        }
    }
    
    public boolean findpassword(int[] pw, int[][] q, int[] ans){
        for(int i = 0; i<q.length; i++){
            int count = 0;
            for(int j = 0; j<5; j++){
                for(int a = 0; a<5; a++){
                    if(q[i][a] == pw[j]){
                        count++;
                    }
                }
            }
            if(ans[i] != count) return false;
        }
        return true;
    }
}

// 비밀코드 1부터 n까지의 서로 다른 정수 5개가 오름차순
// 암호분석도구는 m번의 시도를 할 수 있음
// 시도마다 입력하면 몇개가 포함되어있는지 알 수 있음
// m번의 시도 후, 비밀 코드로 가능한 정수 조합의 갯수를 알고 싶음
// 1부터 n까지(최대 30) / q의 길이는 m / ans는 맞는 갯수

// 조합을 먼저 생성 한 후 갯수를 비교하는게 빠를듯? -> 잘하면 시간초과 날수도
// 최대 조합의 갯수는 30C5 = 142506
// 30 29 
