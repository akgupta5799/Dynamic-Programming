import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static class Pair{
        int v;
        int dis;
        Pair(int x, int y){
            this.v = x;
            this.dis = y;
        }
    }
    public static int getMinimumMoves(int[] board, int n){
        Queue<Pair> q = new LinkedList<>();
        int[] visited = new int[n+1];
        Pair currPos = new Pair(0,0);
        q.add(currPos);
        while(!q.isEmpty()){
            currPos = q.poll();
            int v = currPos.v;
            if(v == n-1){
                break;
            }
            for(int i = v+1; i <= v+6 && i < n; i++){
                if(visited[i] == 0){
                    Pair newPos = new Pair(i, currPos.dis+1);
                    if(board[i] == -1 ){
                        newPos.v = i;
                    }else{
                        newPos.v = board[i];
                    }
                    q.add(newPos);
                    visited[i] = 1;
                }
            }
        }
        return currPos.dis;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of board :");
        // System.out.println("Enter number of horizontal blocks :");
        // int m = sc.nextInt();
        // System.out.println("Enter the number of vertical blocks :");
        int n = sc.nextInt();
        int[] board = new int[n];
        //enter the values of board as -1 if no snake or ladder else its destination point;
        System.out.println("Enter the values of board as -1 if no snake or ladder else its destination point :");
        for(int i = 0; i < n; i++){
            board[i] = sc.nextInt();
        }
        int res = getMinimumMoves(board, n);
        System.out.println("Minimum moves required is : "+ res);
    }
}