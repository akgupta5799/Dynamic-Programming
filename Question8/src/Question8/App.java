/*Matrix Chain Multiplication using Dynamic Programming
"Matrix chain multiplication problem: Determine the optimal parenthesization of a product of n matrices.

Matrix chain multiplication (or Matrix Chain Ordering Problem, MCOP) is an optimization problem that to find the most efficient way to multiply a given sequence of matrices. The problem is not actually to perform the multiplications but merely to decide the sequence of the matrix multiplications involved.
 
The matrix multiplication is associative as no matter how the product is parenthesized, the result obtained will remain the same. For example, for four matrices A, B, C, and D, we would have:

((AB)C)D = ((A(BC))D) = (AB)(CD) = A((BC)D) = A(B(CD))

However, the order in which the product is parenthesized affects the number of simple arithmetic operations needed to compute the product. For example, if A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix, then computing (AB)C needs (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations while computing A(BC) needs (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations. Clearly, the first method is more efficient."
 */
package Question8;
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
        System.out.println("Minimum number of multiplication is : "+ MCM(arr,1,n-1)); //i=1,j=n-1
    }

    public static int MCM(int arr[],int i,int j){
        if(i>=j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempAns = MCM(arr,i,k) + MCM(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
            if(tempAns < min){
                min = tempAns;
            }
        }
        return min;
    }
}
