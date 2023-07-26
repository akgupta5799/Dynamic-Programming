/*Longest Palindromic Subsequence using Dynamic Programming
"The Longest Palindromic Subsequence (LPS) problem is finding the longest subsequences of a string that is also a palindrome.

The problem differs from the problem of finding the longest palindromic substring. Unlike substrings, subsequences are not required to occupy consecutive positions within the original string.
 
For example, consider the sequence ABBDCACB.
The length of the longest palindromic subsequence is 5
The longest palindromic subsequence is BCACB"
 */
package Question7;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the string: ");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s = "";
        for(int i=s1.length()-1;i>=0;i--){
            s = s + s1.charAt(i);
        }
        int m = s1.length();
        int n = s.length();
        int dp[][] = new int[m+1][n+1];
        System.out.println("The length of the longest palindromic subsequence is: "+LPS(s1,s,m,n,dp));
        System.out.println("The longest palindromic subsequence is: "+LPSubseq(s1,s,m,n,dp));
    }

    public static int LPS(String s1,String s,int m,int n,int dp[][]){
       
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[m][n];
    }
    public static String LPSubseq(String s1,String s,int m,int n,int dp[][]){
        StringBuilder sb = new StringBuilder();
        int i = m;  int j = n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i][j-1]>dp[i-1][j]){
                j--;
            }
            else{
                i--;
            }
        }
        return sb.reverse().toString();

    }
}
