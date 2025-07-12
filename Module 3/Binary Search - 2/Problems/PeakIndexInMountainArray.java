import java.io.*;
import java.util.*;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int n = A.length;
        if(A[0]>A[1]) return 0;
        if(A[n-1]>A[n-2]) return n-1;

        int s = 1;
        int e = n-2;
        while(s<=e) {
            int mid = s + (e-s)/2;
            if ((A[mid] > A[mid-1]) && (A[mid]>A[mid+1])) {
                return mid;
            }
            if(A[mid]>A[mid-1]) s = mid+1;
            else e = mid-1;
        }

        return -1;
    }
}

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}