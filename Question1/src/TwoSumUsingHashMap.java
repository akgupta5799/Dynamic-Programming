import java.util.*;
public class TwoSumUsingHashMap {
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

        //Creating a HashMap
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i],i); // array element and its index
        }
        System.out.println("Pair is : ");
        System.out.println(res[0]+ " "+res[1]);

    }
}
