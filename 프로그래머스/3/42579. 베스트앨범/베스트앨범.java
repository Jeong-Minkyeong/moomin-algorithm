import java.util.*;

class Album {
    
    String genre;
    int num;
    int count;
    
    public Album(String genre, int num, int count){
        this.genre = genre;
        this.num = num;
        this.count = count;
    }
}

class Score {
    String genre;
    int sum;
    
    public Score(String genre, int sum){
        this.genre = genre;
        this.sum = sum;
    }
}

class Solution {
    
    public List<Integer> solution(String[] genres, int[] plays) {
        // - 준비
        List<Integer> answer = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        HashMap<String, List<Album>> genreByAlbum = new HashMap<>();
        HashMap<String, Integer> mapByGenre = new HashMap<>();
        
        for(int i = 0; i<plays.length; i++){
            if(mapByGenre.get(genres[i]) == null) {
                mapByGenre.put(genres[i], plays[i]);
                genreByAlbum.put(genres[i], new ArrayList<>());
                continue;
            }
            mapByGenre.put(genres[i], mapByGenre.get(genres[i]) + plays[i]);
        }
        
        // 앨범 객체 생성 후 정렬
        for(int i = 0; i<plays.length; i++){
            albums.add(new Album(genres[i], i, plays[i]));
        }
        
        Collections.sort(albums, (a, b) -> {
                         if (a.count == b.count){
                             return a.num - b.num;
                         }
                         return b.count - a.count; });
        
    
        // - 탐색
        // 장르별 스밍 기록 정리
        for(Album a : albums) {
            genreByAlbum.get(a.genre).add(a);
        }
        
        // 예외상황 처리
        // 장르가 하나라면
//         if(mapByGenre.size() == 1){
//             // 곡도 하나라면
//             if(plays.length == 1) {
//                 answer.add(0);
//                 return answer;
//             }
            
//             for(int i = 0; i<2; i++){
//                 answer.add(genreByAlbum.get(genres[0]).get(i).num);
//             }
//             return answer;
//         }
        
        
        // 최대 스밍 장르 정렬
        ArrayList<Score> genreScore = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : mapByGenre.entrySet()){
            genreScore.add(new Score(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(genreScore, (a, b) -> b.sum - a.sum);
        
        
        // 베스트 앨범 제작
        for(int i = 0; i<genreScore.size(); i++){
            for(int j = 0; j<2; j++){
                answer.add(genreByAlbum.get(genreScore.get(i).genre).get(j).num);
                if(genreByAlbum.get(genreScore.get(i).genre).size() == 1) break;
            }
        }
        
        // - 정답 출력
        return answer;
    }
}

// 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시
// 각 장르별 총 재생 횟수 합산 구하기
// 장르별 재생 횟수 오름차순으로 구하기
// 어떻게 관리할 것인가
// 장르가 하나이면? -> 거기에서 노래 두개 혹은 하나 pick
// 노래가 하나이면 -> 그냥 하나 pick