package Questions;

import java.util.Scanner;

public class ReverseAnArray {

    public static void reverseArray(int arr[])
    {
        int i = 0;
        int j = arr.length -1;

        int temp;
        while(i<=j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();

        reverseArray(arr1);

        for (int i = 0; i < n; i++)
            System.out.print(arr1[i] + " ");
        System.out.println('\n');
    }
}
