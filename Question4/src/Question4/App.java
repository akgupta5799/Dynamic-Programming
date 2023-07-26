/*Coin Change Problem
"Given an unlimited supply of coins of given denominations, find the total number of distinct ways to get the desired change.
For example,
Input: S = { 1, 3, 5, 7 }, target = 8
The total number of ways is 6"*/
package Question4;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
       System.out.println("Enter the size of array: ");
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int coins[] = new int[n];
       System.out.println("Enter the elements of array: ");
       for(int i=0;i<n;i++){
        coins[i] = sc.nextInt();
       }
       System.out.println("Enter the target: ");
       int target = sc.nextInt();
       System.out.println("Maximum number of ways: "+countWays(coins,n,target));

    }
    public static int countWays(int coins[],int n,int target){
        int dp[][] = new int[n+1][target+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}



