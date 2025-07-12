package Problems;

import java.util.*;
import java.lang.*;
import java.io.*;

class SquareRoot {
    public static void sqrt(int A) {

         long s = 1;
        long e = A;
        while(s<=e) {
            long mid = (s+e)/2;
            if(mid*mid==A) {
                System.out.println(mid);
                return;
            };
            if(mid*mid > A) e = mid-1;
            else s = mid+1;
        }

        System.out.println(e);
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();

        sqrt(A);

    }
}