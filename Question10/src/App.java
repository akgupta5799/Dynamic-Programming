/*Rod Cutting Problem
"Given a rod of length n and a list of rod prices of length i, where 1 <= i <= n, find the optimal way to cut the rod into smaller rods to maximize profit.

For example, consider the following rod lengths and values:

Input:
length[] = [1, 2, 3, 4, 5, 6, 7, 8]
price[] = [1, 5, 8, 9, 10, 17, 17, 20]
 
Rod length: 4  , Maximum profit = 10"
 */
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the size of length array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the rod length: ");
        int l = sc.nextInt();
        int length[] = new int[n];
        System.out.println("Enter the length value: ");
        for(int i=0;i<n;i++){
            length[i] = sc.nextInt();
        }
        int price[] = new int[n];
        System.out.println("Enter the price value: ");
        for(int j=0;j<n;j++){
            price[j] = sc.nextInt();
        }
        System.out.println("Maximum profit is: "+rodCutting(length,price,n,l));
    }
    public static int rodCutting(int length[],int price[],int n, int l){
        int dp[][] = new int[n+1][l+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<l+1;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<l+1;j++){
                if(length[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]] , dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][l];
    }
}
