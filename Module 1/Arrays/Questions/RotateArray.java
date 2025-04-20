package Questions;

import java.util.Scanner;

public class RotateArray {

    static void rotate(int arr[], int n) {
        int temp = arr[n-1];
        for(int i=n-1;i>=1;i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
    public static void rotateArray(int[] nums, int k) {
        for(int i=0;i<k;i++) {
            rotate(nums, nums.length);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        rotateArray(arr, k);

        for(int num : arr){
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
