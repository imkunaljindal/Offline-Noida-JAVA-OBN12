package Problems;

import java.io.*;
import java.util.*;
public class RecursiveMultiplication {

    // T.C - O(m)
    // S.C - O(m)
    static int solve(int n, int m) {
        if(m==0) return 0;

        int x = solve(n,m-1);
        return n + x;
    }
    public static void multiplyRecursively(int n, int m) {
        //Write code here and print output
        int ans = solve(n,m);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        multiplyRecursively(n, m);
    }
}