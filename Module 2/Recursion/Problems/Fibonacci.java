import java.util.*;
import static java.lang.Math.ceil;

public class Main {

    public static int fib(int n ){
        // write code here
//        if(n==1) return 0;
//        if(n==2) return 1;
//
        if(n==1 || n==2) return n-1;

        int f1 = fib(n-1);
        int f2 = fib(n-2);
        return f1+f2;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fib(n));
    }
}