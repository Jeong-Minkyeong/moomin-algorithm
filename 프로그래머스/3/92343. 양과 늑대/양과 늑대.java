import java.util.* ;

class Solution {
    static int answer = 0;
    static int wolf = 0;
    static int sheep = 0;
    // static HashMap<Integer, List<Integer>> tree = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
    static ArrayList<Integer> next = new ArrayList<>();
    
    public int solution(int[] info, int[][] edges) {
        // - 준비
        // 그래프 만들기
        for(int i = 0; i<info.length; i++){
            tree.put(i, new ArrayList());
        }
        
        for(int i = 0; i<edges.length; i++){
            int p = edges[i][0];
            int c = edges[i][1];
            tree.get(p).add(c);
        }
        
        // - 탐색
        next.add(0);
        dfs(0, info, sheep, wolf, next);
        
        // - 정답 출력
        // answer = sheep;
        return answer;
    }
    
    public void dfs(int node, int[] info, int sheep, int wolf, ArrayList<Integer> next){
        
        if(info[node] == 0) sheep++;
        if(info[node] == 1) wolf++;
        
        if(sheep <= wolf) return;
        
        answer = Math.max(answer, sheep);
        
        ArrayList<Integer> nextList = new ArrayList<>(next);
        for(int i : tree.get(node)) {
            nextList.add(i);
        }
        
        nextList.remove(Integer.valueOf(node));

        for(int n : nextList){
            dfs(n, info, sheep, wolf, nextList);
        }
    }
}

// 루트 노드에서 출발하여 각 노드를 돌아다니며 양을 모으려 한다
// 각 노드를 방문할 때마다 해당 노드에 있던 양과 늑대가 나를 따라오게 된다
// 이때, 늑대는 양을 잡아먹을 기회를 노리고 있으며, 
// 내가 모은 양의 수보다 늑대의 수가 같거나 더 많아지면 바로 모든 양을 잡아먹어 버린다
// 나는 중간에 양이 늑대에게 잡아먹히지 않도록 최대한 많은 수의 양을 모아서 다시 루트로 회귀 하려 한다
// 최대 모을 수 있는 양의 갯수

// 양이 있는 곳을 무조건 먼저 방문
// 잡아먹힐 것 같으면 무조건 빽 && 리프가 없으면 빽
// 늑대에 먹히고서도 고하는 경우는 없음
// 방문 여부는 표시해야함 -> 현재는 못가지만 양이 많아졌을때 갈 수도 있으므로
// 전체 순회를 하되 양이 잡아먹히지 않도록 조심해서 순회