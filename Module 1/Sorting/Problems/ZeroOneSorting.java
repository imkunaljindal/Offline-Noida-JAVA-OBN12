package Problems;

import java.util.*;

public class ZeroOneSorting {
    static int[] Sorting01(int n,int[] arr){
//        int count0 = 0;
//        int count1 = 0;
//
//        for(int x: arr) {
//            if(x==0) {
//                count0++;
//            }
//            else count1++;
//        }
//
//        for(int i=0;i<count0;i++) {
//            arr[i] = 0;
//        }
//
//        for(int i=count0;i<n;i++) {
//            arr[i] = 1;
//        }

        int start = 0;
        int end = n-1;

        while (start < end) {
            while (start<end && arr[start] == 0) {
                start++;
            }
            while (start<end && arr[end] == 1) {
                end--;
            }

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

        }
        return arr;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        int[] ans=Sorting01(n,arr);
        for(int i=0;i<n;++i){
            System.out.print(ans[i] + " ");
        }
    }
}