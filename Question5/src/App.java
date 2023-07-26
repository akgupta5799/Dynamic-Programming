/*0–1 Knapsack Problem
"In the 0–1 Knapsack problem, we are given a set of items, each with a weight and a value, and we need to determine the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible.

Please note that the items are indivisible; we can either take an item or not (0-1 property). For example,

Input:

weight = [ 1, 2, 3, 8, 7, 4 ]
value = [ 20, 5, 10, 40, 15, 25 ]
int W = 10
Output: Knapsack value is 60" */

import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the size for weight and value array (Both arrays size must be same): ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the capacity of (Knapsack)bag: ");
        int W = sc.nextInt();
        int wt[] = new int[n];
        int value[] = new int[n];
        System.out.println("Enter the elements for weight array: ");
        for(int i=0;i<n;i++){
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter the elements for value array: ");
        for(int i=0;i<n;i++){
            value[i] = sc.nextInt();
        }
        System.out.println("Maximum profit is: "+knapsack(wt,value,n,W));

    }

    public static int knapsack(int wt[],int value[],int n,int W){
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(value[i-1]+dp[i-1][j-wt[i-1]] , dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
}
