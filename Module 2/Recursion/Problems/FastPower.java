package Problems;

import java.io.*;
import java.util.*;

class FastPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X,N;
        X = sc.nextInt();
        N = sc.nextInt();

        System.out.println(power(X,N));
    }

    public static long power(int x, int y)
    {
        if(y==0) return 1;

        long halfPower = power(x,y/2);
        long ans = halfPower*halfPower;
        if(y%2==1) ans = ans*x;

        return ans;
    }
}
