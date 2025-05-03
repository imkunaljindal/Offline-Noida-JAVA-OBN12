package Questions;// Java program to print largest contiguous array sum
import java.util.*;

public class MaximumSumSubarray {

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        sc.close();
        System.out.println(maxSubArraySum(arr));
    }

    // Function Call
    // KADANE's Algorithm
    static int maxSubArraySum(int a[]) {
        int ans = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0;i<a.length;i++) {
            currSum += a[i];
            ans = Math.max(ans,currSum);
            if(currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println(ans);
    }
}