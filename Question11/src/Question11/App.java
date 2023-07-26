/*Word Break Problem – Dynamic Programming
"Word Break Problem: Given a string and a dictionary of words, determine if the string can be segmented into a space-separated sequence of one or more dictionary words.

For example,

Input: 
dict[] = { this, th, is, famous, Word, break, b, r, e, a, k, br, bre, brea, ak, problem };

word = Wordbreakproblem"

*/
package Question11;
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the number of words you want to insert in dictionary: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String dictionary[] = new String[n];
        System.out.println("Enter the words: ");
        for(int i=0;i<n;i++){
            dictionary[i] = sc.next();
        }
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!set.contains(dictionary[i])){
                set.add(dictionary[i]);                
            }
        }
        // for(String s: set){
        //     System.out.println(s);
        // }
        System.out.println("Enter a string: ");
        String s = sc.next();
        
        if(wordBreak(s,set)) System.out.println("Yes");
        else System.out.println("No");
    }
    public static boolean wordBreak(String s,HashSet<String> set){
        //creating dp table of the size+1 of the given string
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;//dp[0] is true because an empty string can always be segmented.

        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

