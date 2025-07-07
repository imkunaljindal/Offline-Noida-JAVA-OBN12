//import java.util.*;
//
//class Solution {
//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int n = nums.length;
//        int prod = 1;
//        if(k==0) return 0;
//
//        int l = 0;
//        int r = 0;
//        int count = 0;
//        while(r<n) {
//            prod *= nums[r];
//
//            while(l<=r && prod >= k) {
//                prod = prod/nums[l];
//                l++;
//            }
//            count += (r-l+1);
//            r++;
//        }
//
//        return count;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n;
//        n = sc.nextInt();
//        int arr[] = new int[n];
//        for (int i = 0; i < n; i++)
//            arr[i] = sc.nextInt();
//        int k;
//        k = sc.nextInt();
//        Solution Obj = new Solution();
//        int result = Obj.numSubarrayProductLessThanK(arr, k);
//        System.out.println(result);
//        sc.close();
//    }
//}