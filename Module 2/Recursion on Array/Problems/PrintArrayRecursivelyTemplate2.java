package Problems;

import java.util.Scanner;


public class PrintArrayRecursivelyTemplate2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        PrintArray(arr, n);
    }

    public static void PrintArray(int[] arr, int n) {
        if(n==0) return;
        PrintArray(arr,n-1);
        System.out.println(arr[n-1]);
    }

}