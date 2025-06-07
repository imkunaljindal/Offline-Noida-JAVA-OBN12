import java.util.*;
import java.io.*;

class Solution {
    static void merge(int arr[], int l, int mid, int r) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = l;
        int j = mid+1;

        while(i<=mid && j<=r) {
            if(arr[i] >= arr[j]) {
                ans.add(arr[i]);
                i++;
            }
            else {
                ans.add(arr[j]);
                j++;
            }
        }

        while(i<=mid) {
            ans.add(arr[i]);
            i++;
        }

        while(j<=r) {
            ans.add(arr[j]);
            j++;
        }

        // original array mein copy
        for(int k=l;k<=r;k++) {
            arr[k] = ans.get(k-l);
        }
    }

    static void mergeSort(int[] arr,int l,int r){
        if(l>=r) return;

        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
}
public class MergeSort {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[n];
        for(int i= 0; i < n; i++)
            a[i] = input.nextInt();
        Solution Obj = new Solution();
        Obj.mergeSort(a,0,n-1);
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}