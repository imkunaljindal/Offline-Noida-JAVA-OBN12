import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
    public int maxLen(int arr[])
    {
        // <prefixSum, index>
        Map<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxSubarrayLength = 0;
        map.put(0,-1); // 0->i edge case
        for(int i=0;i<arr.length;i++) {
            prefixSum += arr[i];
            if(map.containsKey(prefixSum)) {
                maxSubarrayLength = Math.max(maxSubarrayLength,i-map.get(prefixSum));
            }
            else {
                map.put(prefixSum,i);
            }
        }
        return maxSubarrayLength;
    }
}

class Main {

    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxLen(nums));
    }
}
