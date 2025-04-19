package Questions;

import java.util.Scanner;

public class SecondLargest {

    public static void SecondLargest(int[] arr, int n) {
        int largest = arr[0];
        int maxIndex = 0;
        for(int i=1;i<n;i++) {
            if(arr[i] > largest) {
                largest = arr[i];
                maxIndex = i;
            }
        }

        int secondLargest = arr[0];
        for(int i=0;i<n;i++) {
            if(arr[i] > secondLargest && i!=maxIndex) {
                secondLargest = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        SecondLargest(arr,n);
        sc.close();

    }
}
