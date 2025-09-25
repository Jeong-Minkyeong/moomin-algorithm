import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record) {
        
        // 준비
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> motions = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> nicknames = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        StringTokenizer st;
        for(int i = 0; i<record.length; i++){
            st = new StringTokenizer(record[i]);
            
            if(st.countTokens() == 2) {
                motions.add(st.nextToken());
                ids.add(st.nextToken());
                continue;
            }
            String motion = st.nextToken();
            String id = st.nextToken();
            String nickname = st.nextToken();
            
            motions.add(motion);
            ids.add(id);
            nicknames.add(nickname);
            map.put(ids.get(i), nickname);
        }
        
        // 탐색
        for(int i = 0; i<record.length; i++){
            // 메세지 확인
            if(motions.get(i).equals("Enter")){
                answer.add(map.get(ids.get(i)) + "님이 들어왔습니다.");
                continue;
            }
            
            if(motions.get(i).equals("Leave")){
                answer.add(map.get(ids.get(i)) + "님이 나갔습니다.");
            }
        }
        
        // 정답 출력
        return answer;
    }
}
// 채팅방을 나간 후 새로운 닉네임으로 접속
// 채팅방에서 닉네임을 변경
// 중복 닉네임 허용
// 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지
// recode[i] -> 동작 / ID / 닉네임으로 구분