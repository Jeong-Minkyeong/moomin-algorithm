import java.util.*;

class Solution {
//     static Set<Integer> phoneSize = new HashSet<>();
//     static HashMap<Integer, List<String>> phoneMap = new HashMap<>();
//     static ArrayList<String> phoneList = new ArrayList<>();
    
     public boolean solution(String[] phone_book) {
//         // - 준비
//         boolean answer = true;
        
//         // 전화번호 길이 수집
//         //ArrayList<Integer> temp = new ArrayList<>();
        
//         for(String s : phone_book){
//             //phoneSize.add(s.length());
//             phoneMap.put(s.length(), new ArrayList());
//         }
        
//         for(String s : phone_book){
//             phoneMap.get(s.length()).add(s);
//         }
        
//         // - 탐색
//         // 전화번호 길이만큼 접두사 구하기
        
//         for(String s : phone_book){
//             for(int i = 1; i<s.length(); i++) {
//                 String sub = s.substring(0, i);
                
//                 if(phoneMap.get(i) == null) continue;
            
//                 if(phoneMap.get(i).contains(sub)){
//                     answer = false;
//                     return answer;
//                 }
//             }
//         }
    
//         // - 정답 출력
//         return answer;
    Set<String> set = new HashSet<>();

        // 모든 전화번호를 HashSet에 저장
        Arrays.stream(phone_book).forEach(set::add);

        // 각 번호의 접두어(1 ~ length - 1)를 검사하여
        // 다른 번호가 접두어로 존재하는 경우 false 반환
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) return false;
            }
        }

        // 접두어가 존재하지 않으면 true 반환
        return true;
    }
}

// 주어진 번호가 다른 번호의 앞에 포함되있는지를 물어보는 것
// 같은 전화번호는 없음
// 각 길이에 따라서 분류
// 길이가 짧을 수록 유리
// 완전탐색은 시간복잡도에서 탈락
// 히든 테케가 뭘까? : 
// 1. set는 순서보장이 되지 않음 -> 이문제는 아니었음
// 2. 두개의 접두어가 같을 수도 있음 -> 이문제였음!!