/*Subset Sum Problem – Dynamic Programming Solution
"Given a set of positive integers and an integer k, check if there is any non-empty subset that sums to k.

For example,
Input:
A = { 7, 3, 2, 5, 8 }
k = 14
Output: Subset with the given sum exists"*/

import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
       System.out.println("Enter the size of array: ");
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int set[] = new int[n];
       System.out.println("Enter the elements of array: ");
       for(int i=0;i<n;i++){
        set[i] = sc.nextInt();
       }
       System.out.println("Enter the sum: ");
       int sum = sc.nextInt();
       System.out.println("Subset exist: "+isSubset(set,n,sum));

    }
    public static boolean isSubset(int set[],int n,int sum){
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(set[i-1]<=j){
                    dp[i][j] = dp[i-1][j-set[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
