package Questions;

import java.util.*;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        ArrayOperations(arr, n);
    }

    public static void ArrayOperations(int[] arr, int n) {
        // 1. Sum
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum = sum + arr[i];
        }

        // avg
        int avg = sum/n;

        // largest
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(arr[i] > mx) {
                mx = arr[i];
            }
        }

        //int arr1[] = {1,2,3,4};

        System.out.print(sum + " " + avg + " " + mx);
    }
}