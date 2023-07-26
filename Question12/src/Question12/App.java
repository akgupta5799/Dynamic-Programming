package Question12;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static class Pair{
        int x;
        int y;
        int dis;
        Pair(int X, int Y,int z){
            this.x = X;
            this.y = Y;
            this.dis = z;
        }
    }

    public static Queue<Pair> q = new LinkedList<>();
    public static int[][] dir = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
    public static int[][] visited = new int[8][8];

    public static boolean isSafe(Pair p){
        if(p.x >= 0 && p.y >= 0 && p.x < 8 && p.y < 8){
            return true;
        }
        return false;
    }
    public static void countMoves(Pair start, Pair end, int moves){
        q.add(start);
        visited[start.x][start.y] = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.x == end.x && p.y == end.y){
                System.out.println("Minimum move to reach Destination point is : "+ p.dis);
            }
            for(int i = 0; i < 8; i++){
                Pair newP = new Pair(p.x + dir[i][0], p.y + dir[i][1], p.dis +1 );
                if(isSafe(newP) && visited[newP.x][newP.y] == 0){
                    visited[newP.x][newP.y] = 1;
                    q.add(newP);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting point :");
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("Enter the ending point :");
        int endX = sc.nextInt(x);
        int endY = sc.nextInt();
        Pair start = new Pair(x,y,0);
        Pair end = new Pair(endX,endY,-1);
        if(end.x < 0 || end.y < 0 || end.x >= 8 || end.y >= 8){
            System.out.println("Enter the correct end point");
            System.exit(0);
        }
        countMoves(start,end,0);
        //System.out.println("Number of moves neede is res");
    }
}