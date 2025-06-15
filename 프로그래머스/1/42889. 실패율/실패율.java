import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double [][] failpersent = new double [N][2];
        int count = stages.length;
        
        for(int i = 1; i<=N; i++){
            int temp = 0;
            for(int j = 0; j<stages.length; j++){
                // N번째 스테이지 실패한 사용자
                if(stages[j] == i) temp++;
            }
        
            failpersent[i-1][0] = i;
            if(temp == 0) {
                failpersent[i-1][1] = 0;
                continue;
            }
            
            failpersent[i-1][1] = (double) temp/count;
            
            count -= temp;
        }
    
        Arrays.sort(failpersent, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return Double.compare(o1[0], o2[0]);
            }
            return Double.compare(o2[1], o1[1]);
        });
        
        for(int i = 0; i<N; i++){
            System.out.println(failpersent[i][1]);
            answer[i] = (int) failpersent[i][0];
        }
        
        return answer;
    }
}