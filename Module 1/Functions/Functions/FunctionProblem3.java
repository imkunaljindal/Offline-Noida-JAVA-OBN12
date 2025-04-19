package Functions;

import java.io.*;

import java.util.*;

public class FunctionProblem3 {

    static int fun(int n){
        for(int i=0;i<5;i++) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int result = fun(n);
        System.out.print(result);
    }
}