//import java.util.*;
//
//class Solution {
//    static int maxOne(int arr[], int n,int k)
//    {
//        int ans = 0;
//        int l = 0;
//        int r = 0;
//        int zeros = 0;
//        while(r<arr.length) {
//            if(arr[r]==0) {
//                zeros++;
//            }
//            while(l<=r && zeros > k) {
//                if(arr[l]==1) {
//                    l++;
//                    continue;
//                }
//                zeros--;
//                l++;
//            }
//            ans = Math.max(ans,r-l+1);
//            r++;
//        }
//        return ans;
//    }
//
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n= sc.nextInt();
//        int k= sc.nextInt();
//        int array[] = new int[n];
//
//        for(int i=0; i<n; i++){
//            array[i]= sc.nextInt();
//        }
//        Solution Obj = new Solution();
//        System.out.println(Obj.maxOne(array,n,k));
//    }
//}