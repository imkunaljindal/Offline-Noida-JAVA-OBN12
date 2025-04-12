package PortalQuestions;

import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      //  int t = sc.nextInt();
       // while (t > 0) {
            // main logic
            int n = sc.nextInt();

            // upper half
        int rows = n/2;
            for(int i=1;i<=rows;i++) {
                for(int j=1;j<=(n-i);j++) {
                    System.out.print(" ");
                }
                for(int j=1;j<=(2*i-1);j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }

            // lower half
        int m = n-rows;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=(2*m-2*i+1);j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
            //t--;
        //}
    }
}
