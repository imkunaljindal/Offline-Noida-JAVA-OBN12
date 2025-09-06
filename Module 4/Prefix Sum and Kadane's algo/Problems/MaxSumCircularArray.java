import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {

        int currSum = 0;
        int totalSum = 0;
        int maxKadanes = Integer.MIN_VALUE;

        //Case 1: Max kadanes for linear subarray
        for(int i=0;i<n;i++) {
            currSum += arr[i];
            maxKadanes = Math.max(currSum,maxKadanes);
            if(currSum<0) currSum = 0;
            totalSum += arr[i];
        }

        //Case 2: Min Kadanes - for calculation max circular subarray sum
        int minKadanes = Integer.MAX_VALUE;
        currSum = 0;
        for(int i=0;i<n;i++) {
            currSum += arr[i];
            minKadanes = Math.min(minKadanes,currSum);
            if(currSum > 0) currSum = 0;
        }

        return Math.max(maxKadanes,totalSum-minKadanes);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}