/*Find a pair with the given sum in an array
"Given an unsorted integer array, find a pair with the given sum in it.
For example,
Input:
nums = [8, 7, 2, 5, 3, 1]
target = 10"*/
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the size of array: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int nums[] = new int[size];
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<size;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the target value: ");
        int target = sc.nextInt();

        // for storing the result
        int res[] = new int[2];

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        System.out.println("Pair is: ");
        // for(int x=0;x<2;x++){
        //     System.out.println(res[x]+" ");
        // }
         System.out.println(res[0]+" "+res[1]);

    }
}
