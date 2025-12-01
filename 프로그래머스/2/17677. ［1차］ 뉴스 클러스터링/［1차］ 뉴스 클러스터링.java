import java.util.*;

class Solution {
    static List<String> strOne = new ArrayList<>();
    static List<String> strTwo = new ArrayList<>();
    
    static Set<String> alpha = new HashSet<>();
    static String alphaStr = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";
    
    static int union = 0;
    static int intersection = 0;
        
    public int solution(String str1, String str2) {
        // - 준비 
        double answer = 0;
        
        // 알파벳 set 만들기
        for(int i = 0; i<alphaStr.length(); i++){
            alpha.add(alphaStr.substring(i, i+1));
        }
        
        // 문자열 조각 만들기
        makeStrPiece(str1, strOne);
        makeStrPiece(str2, strTwo);
        
        // 경계값 삭제 - 둘다 공집합일 경우
        if(strOne.isEmpty() && strTwo.isEmpty()){
            answer = 1;
            return (int) Math.floor(answer * 65536);
        }
        
        // - 탐색
        // 교집합 && 합집합 구하기

        if(strOne.size() <= strTwo.size()){
            intersection = makeStrIntersection(strOne, strTwo);
            System.out.println(intersection);
            union = makeStrUnion(strTwo, strOne);
            System.out.println(union);
        }
        
        if(strOne.size() > strTwo.size()){
            intersection = makeStrIntersection(strTwo, strOne);
            System.out.println(intersection);
            union = makeStrUnion(strOne, strTwo);
            System.out.println(union);
        }

        
        // - 정답 출력
        answer = (double) intersection / union;
        return (int) Math.floor(answer * 65536);
    }
    
    // 문자열 조각 만드는 메서드
    public void makeStrPiece(String str, List<String> strSet) {
        // 모두 대문자로 변경
        str = str.toUpperCase();
        
        for(int i = 0; i<str.length()-1; i++){
            // 자르기
            String temp = str.substring(i, i+2);
            
            // 공백 및 특수문자 확인
            if(!alpha.contains(temp.substring(0, 1)) || !alpha.contains(temp.substring(1, 2))) {
                continue;
            }
            //System.out.println(temp);
            strSet.add(temp);
        }    
    }
    
    public int makeStrIntersection(List<String> l1, List<String> l2) {
        int count = 0;
        Map<String, Integer> strMap = new HashMap<>();
        
        // 사전 만들기
        for(String s : l1) {
            if(strMap.get(s) == null) {
                strMap.put(s, 1);
                continue;
            }
            
            strMap.put(s, strMap.get(s) + 1);
        }
        
        // 교집합 찾기
        for(String s : l2) {
            // 없으면 pass
            if(strMap.get(s) == null) continue;
            
            // 있는데 0이면
            if(strMap.get(s) == 1){
                count++;
                strMap.remove(s);
                continue;
            }
            
            count++;
            strMap.put(s, strMap.get(s) -1);
        }
    
        return count;
    }
    
    public int makeStrUnion(List<String> l1, List<String> l2) {
        int count = l1.size();
        Map<String, Integer> strMap = new HashMap<>();
        
        // 사전 만들기
        for(String s : l1) {
            if(strMap.get(s) == null) {
                strMap.put(s, 1);
                continue;
            }
            strMap.put(s, strMap.get(s) + 1);
        }
        
        // 합집합 찾기
        for(String s : l2) {
            // 없으면
            if(strMap.get(s) == null) {
                count++;
                continue;
            }
            
            // 있는데 0이면
            if(strMap.get(s) == 0) {
                count++;
                continue;
            }
            strMap.put(s, strMap.get(s) -1);
        }
        return count;
    }
}


// [문제 이해]
// 자카드 유사도 
// -> 두 집합 A B 사이의 J = 두 집합의 교집합 크기 / 두 집합의 합집합 크기
// 둘다 공집합일 경우는 나눗셈이 정의되지 않으니 1로 정의
// 다중집합은 교집합일때는 작은 갯수, 합집합일떄는 큰 갯수
// 문자열 유사도 계산하기
// 문자열은 두 글자씩 끊어서 다중집합 만들기
// 입력 문자열은 최대 1000 -> 이중은 1000000
// 쪼갠 조각에 특수문자 들어있으면 버리기
// 최종 유사도 출력, 곱하기 65536 후 소수점 버리기(Math.floor)
// 대소문자 취급 안함 모두 같은걸로

// [풀이 과정]
// 문자열 모두 대문자로 바꾸기
// 두글자씩 잘라서 List에 저장 -> 특수문자나 공백 들어있는지 확인 알파벳 Set으로
// 합집합 메서드
// 교집합 메서드
