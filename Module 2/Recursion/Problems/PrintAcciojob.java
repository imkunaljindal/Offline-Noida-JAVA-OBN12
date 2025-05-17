package Problems;

import java.io.*;
import java.util.*;

class PrintAcciojob
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        solve(n);

    }

    public static void solve(int n)
    {
        // Your code here
        if(n==0) return;

        System.out.println("ACCIOJOB");
        solve(n-1);

    }
}