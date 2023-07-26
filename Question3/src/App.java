/*Maximum Sum Subarray Problem
"Given an integer array, find a contiguous subarray within it that has the largest sum.
For example,
Input:  {-2, 1, -3, 4, -1, 2, 1, -5, 4}
Output: Subarray with the largest sum is {4, -1, 2, 1} with sum 6."
 */
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter  the size of array: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("\nSum is: "+kadanesAlgo(arr,n));
    }
    public static int kadanesAlgo(int arr[],int n){
        int currSum = arr[0];
        int overallSum = arr[0];
        int start = 0,end = 0, s = 0;
        for(int i=1;i<n;i++){
            if(currSum>=0){
                currSum = currSum + arr[i];
            }
            else{
                currSum = arr[i];
                 s = i;
            }
            if(currSum > overallSum){
                overallSum = currSum;
                start = s;
                end = i;
            }
        }
        System.out.println("Subarray is : ");
        for(int j=start;j<=end;j++){
            System.out.print(arr[j]+" ");
        }
        return overallSum;
    }
}
