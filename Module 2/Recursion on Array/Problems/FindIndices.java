package Problems;

import java.io.*;
import java.util.*;

public class FindIndices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,x;
        n = sc.nextInt();
        x = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        findX(arr1, n, x);
    }

    static void findX(int arr[], int n, int x)
    {
        solve(arr,0,x);
    }

    static void solve(int arr[], int i, int x) {
        if(i>=arr.length) return;
        if(arr[i]==x) {
            System.out.print(i + " ");
        }
        solve(arr,i+1,x);
    }
}
