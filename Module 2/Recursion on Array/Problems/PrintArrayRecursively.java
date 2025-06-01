package Problems;

import java.util.*;


public class PrintArrayRecursively {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        PrintArray(arr, n);
    }

    public static void PrintArray(int[] arr, int n) {
        print(arr,0,n);
    }

    // O(n) -> Time and Space
    public static void print(int arr[], int i, int n) {
        if(i>=n) return;
        System.out.print(arr[i] + " ");
        print(arr,i+1,n);
    }

}