import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 준비
        int[] answer = new int[id_list.length];
        List<String> names = new ArrayList<>();
        HashMap<String, HashSet<String>> reports = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();
        HashMap<String, Integer> mailCount = new HashMap<>();
        
        for(String s : id_list){
            reports.put(s, new HashSet<String>());
            reportCount.put(s, 0);
            mailCount.put(s, 0);
        }
        
        StringTokenizer st;
        
        // 탐색
        // 1. report 명단 정리
        for(String s : report){
            st = new StringTokenizer(s);
            String reporter = st.nextToken();
            String reported = st.nextToken();
            
            HashSet<String> updateName = reports.get(reported);
            updateName.add(reporter);
            reports.replace(reported, updateName);
            reportCount.put(reported, reports.get(reported).size());
        }
        
        // 2. k번 이상 신고당한 사람 색출
        for(String s : reportCount.keySet()){
            if(reportCount.get(s) >= k){
                names.add(s);
            }
        }
        
        // 3. 메일링 대상자 구하기
        for(String s1 : names){
            for(String s2 : reports.get(s1)){
                mailCount.put(s2, mailCount.get(s2) + 1);
            }
        }
        
        // 정답 출력
        for(int i = 0; i<id_list.length; i++){
            answer[i] = mailCount.get(id_list[i]);
        }
        return answer;
    }
}

// hash 1 - key를 신고한 사람
// 프로도 : 무지, 어피치
// 네오 : 무지, 어피치 
// 무지 : 어피치

// hash 2 - 신고당한 횟수
// 무지 : 1
// 어피치 : 0
// 프로도 : 2
// 네오 : 2

// hash 3 - 신고자 메일링
// 무지 : 2
// 어치피 : 1
// 프로도 : 1
// 네오 : 0


