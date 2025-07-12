package Problems;

import java.io.*;
import java.util.*;
public class SearchInBitonicArray {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();

        int target=sc.nextInt();

        Accio ob = new Accio();
        int ans= ob.findElement(arr, N,target);

        System.out.println(ans);

    }
}


class Accio {

    static int findPeak(int a[], int n) {
        if(a[0]>a[1]) return 0;
        if(a[n-1]>a[n-2]) return n-1;

        int s = 1;
        int e = n-2;

        while(s<=e) {
            int mid = s + (e-s)/2;
            if((a[mid]>a[mid-1]) && (a[mid]>a[mid+1])) return mid;
            if(a[mid]>a[mid-1]) s = mid+1;
            else e = mid-1;
        }
        return -1;
    }

    static int incrBinarySearch(int a[], int s, int e, int target) {
        while(s<=e) {
            int mid = s + (e-s)/2;
            if(a[mid]==target) return mid;
            if(a[mid]>target) e = mid-1;
            else s = mid+1;
        }

        return -1;
    }

    static int decBinarySearch(int a[], int s, int e, int target) {
        while(s<=e) {
            int mid = s + (e-s)/2;
            if(a[mid]==target) return mid;
            if(a[mid] > target) s = mid+1;
            else e = mid-1;
        }
        return -1;
    }

    static int findElement(int arr[], int n,int target)
    {
        int peakIdx = findPeak(arr,n);

        int firstHalfAns = incrBinarySearch(arr,0,peakIdx,target);
        if(firstHalfAns!=-1) return firstHalfAns;

        int secondHalfAns = decBinarySearch(arr,peakIdx+1,n-1,target);
        return secondHalfAns;

    }
}