import java.util.Scanner;

public class Main {

    static int[] arr, ans;
    static boolean[] visited;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        arr = new int[9];
        visited = new boolean[9];
        ans = new int[7];

        // 입력된 값들 중 7개를 중복되지 않게 뽑아 그 합을 구한다. -> 조합
        for(int i = 0; i<9; i++){
            arr[i] = sc.nextInt();
        }

        func(0, 0);
        isPrint();
    }
    
    public static void print(){
        for(int i = 0; i<7; i++){
            System.out.println(ans[i]);
        }
        System.out.println();
    }

    public static void isPrint(){
        int sum = 0;

        for (int i = 0; i<7; i++){
            sum += ans[i];
        }
        if(sum == 100){
            print();
        }
    }

    public static void func(int r, int d){

        if(r== 7) {
            //print();
            isPrint();
            return;
        }

        for(int i = d; i<9; i++){
            if(visited[i]) continue;
            ans[r] = arr[i];
            visited[i] = true;
            func(r+1, i);
            visited[i] = false;
        }
    }
}
