package Patterns;

import java.util.Scanner;

public class Pattern5 {

    public static void main(String[] args) {
        //    1
        //   12
        //  123
        // 1234

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=(n-i);j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
