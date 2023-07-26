/*Longest Common Subsequence Problem
// "The Longest Common Subsequence (LCS) problem is finding the longest subsequence present in given two sequences in the same order, i.e., find the longest sequence which can be obtained from the first original sequence by deleting some items and from the second original sequence by deleting other items.
// For example, consider the two following sequences, X and Y:
// X: ABCBDAB
// Y: BDCABA

// The length of the LCS is 4
// LCS are BDAB, BCAB, and BCBA"*/
package Question2;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception { 
        System.out.println("Enter the first string: ");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        System.out.println("Enter the second string: ");
        String s2 = sc.nextLine();
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];

        System.out.println("The length of LCS is : "+LCS(s1,s2,m,n,dp));
        System.out.println("LCS : "+subseq(s1,s2,m,n,dp));


    }
    public static int LCS(String s1,String s2,int m, int n,int dp[][]){
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
               if(i==0||j==0){
                dp[i][j] = 0;
               }
              
               
             else  if(s1.charAt(i-1) == s2.charAt(j-1)){
                dp[i][j] = 1 + dp[i-1][j-1];
            }
            else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                
            }
            System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
       
        return dp[m][n];
    }
    public static String subseq(String s1, String s2, int m, int n, int dp[][]){
        
        StringBuilder sb = new StringBuilder();
        int i = m,j = n;
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i][j-1]>dp[i-1][j]){
                j--;
            }
            else i--;
            
        }
        return sb.reverse().toString();
    }

}
