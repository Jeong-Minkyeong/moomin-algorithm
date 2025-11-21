import java.util.*;

class Solution {
    List<Integer> ans = new ArrayList<>();
    Set<Integer> numSet = new HashSet<>();
    Map<Integer, ArrayList<Integer>> numMap = new HashMap<>();

    public int[] solution(String s) {
        // - 준비
        int[] answer = {};
        StringTokenizer st = new StringTokenizer(s, "}{");
        
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if(token.equals(",")) continue;
            
            ArrayList<Integer> tempList = new ArrayList<>();
            
            for(String t : token.split(",")){
                tempList.add(Integer.parseInt(t));
            }
            numMap.put(tempList.size(), tempList);
        }
        
        // - 탐색
        for(Integer i : numMap.keySet()){
            for(Integer num : numMap.get(i)) {
                if(numSet.contains(num)) continue;
                
                ans.add(num);
                numSet.add(num);
            }
        }
        
        // - 정답 출력
        answer = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}

// [문제 이해]
// 셀 수 있는 수량의 순서있는 열거, n-튜플을 만들려고 한다
// 중복된 원소 있을 수 있음
// 원소마다 정해진 순서가 있음, 순서 다르면 다른거임
// 원소의 갯수는 유한함
// 특정 튜플 집합 문자열이 주어졌을때, 원본 가져와라

// 문자열 조작부터 하자
// s의 길이는 5 이상 1,000,000 이하 -> 반복분 한번에 처리
// '{', '}', ',' 를 잘 거르기 -> 대괄호 먼저 걸러볼까?
// 길이가 1인 튜플이 시작임
// (1, 2, 3) (2, 1) (1, 2, 4, 3)
// 각각을 List로 만들어 저장 -> 각 길이만큼을 Map에 저장
// 길이가 1번부터 Set에 저장하면서 있으면 pass 없으면 정답 배열과 Set에 추가
