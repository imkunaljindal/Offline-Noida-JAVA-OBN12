package Problems;

import java.util.*;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();

        System.out.println(isPalindrome(arr, n));
    }

    public static boolean isPalindrome(int[] arr, int n) {
        return solve(arr,0,n-1);
    }

    static boolean solve(int arr[], int s, int e) {
        if(s>=e) return true;
        if(arr[s]!=arr[e]) return false;
        return solve(arr,s+1,e-1);
    }

}