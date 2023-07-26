/*Partition Problem using Dynamic Programming
"Given a set of positive integers, check if it can be divided into two subsets with equal sum.

For example,

Consider S = {3, 1, 1, 2, 2, 1}
Yes
 
We can partition S into two partitions, each having a sum of 5.
 
S1 = {1, 1, 1, 2}
S2 = {2, 3}"
 */
package Question13;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the size of array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
       System.out.println("Partition exist: "+equalSumPartition(arr,n));
        
    }
    public static boolean equalSumPartition(int arr[],int n){
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum + arr[i];
        }
        if(sum % 2 !=0){
            return false;
        }

        boolean dp[][] = new  boolean [n+1][sum/2 + 1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum/2 +1;j++){
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum/2 +1;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum/2];
    }  
}
