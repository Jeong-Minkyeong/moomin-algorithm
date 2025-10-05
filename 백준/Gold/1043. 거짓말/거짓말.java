import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static int fact;
    static int[] facts;

    static HashMap<Integer, ArrayList<Integer>> partyAndPeople = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> peopleAndParty = new HashMap<>();

    static boolean[] visited;
    static int party = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        // - 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 아는 사람 입력 받기
        st = new StringTokenizer(br.readLine());
        fact = Integer.parseInt(st.nextToken());
        facts = new int[fact];
        for(int i = 0; i<fact; i++){
            facts[i] = Integer.parseInt(st.nextToken());
        }

        // 사람별 파티 집계와 파티별 사람 집계
        for(int i = 1; i<=N; i++){
            peopleAndParty.put(i, new ArrayList<>());
        }

        for(int i = 1; i<=M; i++){
            partyAndPeople.put(i, new ArrayList<>());
        }

        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int j = 1; j<=n; j++){
                int p = Integer.parseInt(st.nextToken());
                partyAndPeople.get(i).add(p);
                peopleAndParty.get(p).add(i);
            }
        }

        // - 탐색
        visited = new boolean[M+1];
        for(int i : facts){
            dfs(i,peopleAndParty.get(i));
        }


        // - 정답 출력
        int c = 1;
        for(boolean b : visited){
            //System.out.println(c++ + " 여기야");
            if(b) {
               // System.out.println(c++);
                answer++;
            }
        }
        System.out.println(M - answer);
    }

    public static void dfs(int people, ArrayList<Integer> party) {
        for(int p : party){
            if(visited[p]) continue;
            visited[p] = true;
            ArrayList<Integer> peoples = partyAndPeople.get(p);
            for(Integer i : peoples){
                if(i == people) continue;
                dfs(i, peopleAndParty.get(i));
            }
        }
    }
}
