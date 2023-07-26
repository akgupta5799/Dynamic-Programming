/*Longest Common Substring Problem
"The longest common substring problem is the problem of finding the longest string (or strings) that is a substring (or are substrings) of two strings.

The problem differs from the problem of finding the Longest Common Subsequence (LCS). Unlike subsequences, substrings are required to occupy consecutive positions within the original string.

For example, the longest common substring of strings ABABC, BABCA is the string BABC having length 4. Other common substrings are ABC, A, AB, B, BA, BC, and C."
 */
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
        System.out.println("Length of longest common substring is : "+LCSub(s1,s2,m,n));
    }
    public static int LCSub(String s1,String s2,int m,int n){
        int row=0,col=0;
        int res = 0;
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(res<dp[i][j]){
                        res = dp[i][j];
                        row = i;
                        col = j;
                   }
                }   
                   else{
                    dp[i][j] = 0;
                   }
            }
        }
        int x = res;
        StringBuilder sb = new StringBuilder();
        while(x>0){
            sb.append(s1.charAt(row-1));
            row--;
            // col--;
            x--;
        }
        System.out.println(sb.reverse().toString());
        // for printing the dp table
        // for(int i=0;i<m+1;i++){
        //     for(int j=0;j<n+1;j++){
              
        //        System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return res;
    }
}
