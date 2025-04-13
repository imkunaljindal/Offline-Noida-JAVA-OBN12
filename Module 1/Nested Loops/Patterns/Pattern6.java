package Patterns;

import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        //    4
        //   43
        //  432
        // 4321

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=(n-i);j++) {
                System.out.print(" ");
            }
            for(int j=n;j>=(n-i+1);j--) {
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
