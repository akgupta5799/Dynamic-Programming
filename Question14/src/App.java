/*3–Partition Problem
"3-partition problem: Given a set S of positive integers, determine if it can be partitioned into three disjoint subsets that all have the same sum, and they cover S.

The 3–partition problem is a special case of the Partition Problem, which is related to the Subset Sum Problem (which itself is a special case of the Knapsack Problem). The goal is to partition S into two subsets with an equal sum in the partition problem. In the 3–partition problem, the goal is to partition S into 3 subsets with an equal sum.

 
For example,

S = { 7, 3, 2, 1, 5, 4, 8 }

We can partition S into three partitions, each having a sum of 10.

S1 = { 7, 3 }
S2 = { 5, 4, 1 }
S3 = { 8, 2 }"
 */
// import java.util.*;
// public class App {
//     public static void main(String[] args) throws Exception {
//         System.out.println("Enter the size of array: ");
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr[] = new int[n];
//         System.out.println("Enter the elements of array: ");
//         for(int i=0;i<n;i++){
//             arr[i] = sc.nextInt();
//         }

//         System.out.println("Three partition with equal sum exist: "+threePartition(arr,n));
//     }
//     public static boolean threePartition(int arr[],int n){
//         int sum = 0;
//         for(int i=0;i<n;i++){
//             sum = sum + arr[i];
//         }
//         if(sum % 3 != 0){
//             return false;
//         }

//         boolean dp[][] = new boolean[n+1][sum/3 +1];
//         for(int i=0;i<n+1;i++){
//             for(int j=0;j<sum/3+1;j++){
//                 if(i==0) dp[i][j] = false;
//                 if(j==0) dp[i][j] = true;
//             }
//         }
//         for(int i=1;i<n+1;i++){
//             for(int j=1;j<sum/3 +1;j++){
//                 if(arr[i-1] <= j){
//                     dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
//                 }
//                 else{
//                     dp[i][j] = dp[i-1][j];
//                 }
//             }
//         }
//         return dp[n][sum/3];

//     }
// }
import java.util.Arrays;

class App
{
	// Helper function for solving 3 partition problem.
	// It returns true if there exist three subsets with the given sum
	public static boolean subsetSum(int[] S, int n, int a, int b, int c)
	{
		// return true if the subset is found
		if (a == 0 && b == 0 && c == 0) {
			return true;
		}

		// base case: no items left
		if (n < 0) {
			return false;
		}

		// Case 1. The current item becomes part of the first subset
		boolean A = false;
		if (a - S[n] >= 0) {
			A = subsetSum(S, n - 1, a - S[n], b, c);
		}

		// Case 2. The current item becomes part of the second subset
		boolean B = false;
		if (!A && (b - S[n] >= 0)) {
			B = subsetSum(S, n - 1, a, b - S[n], c);
		}

		// Case 3. The current item becomes part of the third subset
		boolean C = false;
		if ((!A && !B) && (c - S[n] >= 0)) {
			C = subsetSum(S, n - 1, a, b, c - S[n]);
		}

		// return true if we get a solution
		return A || B || C;
	}

	// Function for solving the 3–partition problem. It returns true if the given
	// set `S[0…n-1]` can be divided into three subsets with an equal sum.
	public static boolean partition(int[] S)
	{
		if (S.length < 3) {
			return false;
		}

		// get the sum of all elements in the set
		int sum = Arrays.stream(S).sum();

		// return true if the sum is divisible by 3 and the set `S` can
		// be divided into three subsets with an equal sum
		return (sum % 3) == 0 && subsetSum(S, S.length - 1, sum/3, sum/3, sum/3);
	}

	public static void main(String[] args)
	{
		// Input: a set of integers
		int[] S = { 7, 3, 2, 1, 5, 4, 8 };

		if (partition(S)) {
			System.out.println("Set can be partitioned");
		}
		else {
			System.out.println("Set cannot be partitioned");
		}
	}
}
