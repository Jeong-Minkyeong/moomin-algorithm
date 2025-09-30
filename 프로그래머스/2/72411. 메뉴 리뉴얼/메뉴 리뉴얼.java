import java.util.*;

class Solution {

		static HashMap<String, Integer> hash = new HashMap<>();
		static ArrayList<String> answerList = new ArrayList<>();
		
		public String[] solution(String[] orders, int[] course) {
				
				// 준비
				String[] answer = {};
				
				// 탐색
				// 만들고 싶은 코스요리 수에 맞는 조합을
				// 각각의 주문에서 확인
					for(int n : course) {
						for(String order : orders) {
                            char[] chars = order.toCharArray();
                            Arrays.sort(chars);

                            dfs(0, "", chars, n);
						}
						
				    // 만약 Hash가 비어있지 않다면
                    // 각 조합들의 숫자를 모아 가장 큰 숫자값을 찾고
                    // 1이 아님을 확인한 후, 해당 값을 가진 key값을 찾아내기
                    if(!hash.isEmpty()) {
                        List<Integer> countList = new ArrayList<>(hash.values());
                        int max = Collections.max(countList);

                        if(max > 1) {
                            for(String key : hash.keySet()){
                                if(hash.get(key) == max) {
                                        answerList.add(key);
                                }
                            }
                        }	
                    }		
                    hash.clear();
				}
				
				// 정답 출력
				Collections.sort(answerList);
				answer = new String[answerList.size()];
				
				for(int i = 0; i<answer.length; i++){
				    answer[i] = answerList.get(i);
				}
				return answer;
		}
		
		
		// 조합 만드는 로직
		static void dfs(int depth, String course, char[] chars, int n) {
            if(course.length() == n) {
                if(hash.containsKey(course)) {
                    hash.put(course, hash.get(course) + 1);
                    return;
                }
                hash.put(course, 1);
                return;
            }
            
            if(depth >= chars.length) {
                return;
            }

            dfs(depth + 1, course + chars[depth], chars, n);
            dfs(depth + 1, course, chars, n);
	 }
}			