//import java.io.*;
//import java.util.*;
//
//class Solution {
//
//    static int[] getLeftMax(int arr[], int n) {
//        int leftMax[] = new int[n];
//        leftMax[0] = -1;
//        for(int i=1;i<n;i++) {
//            leftMax[i] = Math.max(leftMax[i-1],arr[i-1]);
//        }
//
//        return leftMax;
//    }
//
//    static int[] getRightMax(int arr[], int n) {
//        int rightMax[] = new int[n];
//        rightMax[n-1] = -1;
//        for(int i=n-2;i>=0;i--) {
//            rightMax[i] = Math.max(rightMax[i+1],arr[i+1]);
//        }
//
//        return rightMax;
//    }
//
//    public void TappingWater(int[] arr, int n) {
//        int leftMax[] = getLeftMax(arr,n);
//        int rightMax[] = getRightMax(arr,n);
//
//        int totalWater = 0;
//        for(int i=0;i<n;i++) {
//            int water = Math.min(leftMax[i],rightMax[i])-arr[i];
//            if(water > 0) totalWater += water;
//        }
//
//        System.out.println(totalWater);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n= sc.nextInt();
//        int[] arr= new int[n];
//
//        for(int i=0;i<n;i++)
//            arr[i]=sc.nextInt();
//
//
//        Solution Obj = new Solution();
//        Obj.TappingWater(arr, n);
//
//
//        sc.close();
//
//    }
//}