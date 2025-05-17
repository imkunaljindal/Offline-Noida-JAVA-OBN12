package Problems;

import java.io.*;
import java.util.*;

class PrintThePattern
{
    // TC - O(n^2)
    // SC - O(n)
    public static void solve(int n)
    {
        // Your code here
        if(n==0) return;

        solve(n-1);
        for(int i=0;i<n;i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        solve(n);

    }
}