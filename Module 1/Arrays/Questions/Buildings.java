package Questions;

import java.util.Scanner;

public class Buildings {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        buildings(arr, n);
    }

    public static void buildings(int[] arr, int n) {
        int maxHeight = 0;
        for(int i=0;i<n;i++) {
            maxHeight = Math.max(maxHeight,arr[i]);
        }

        for(int row=maxHeight;row>=1;row--) {
            for(int i=0;i<n;i++) {
                if(arr[i]>=row) {
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
