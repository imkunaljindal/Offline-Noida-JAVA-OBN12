import java.util.Scanner;

public class Pattern3 {

    public static void main(String[] args) {
        /** n=3
         * 3
         * 32
         * 321
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++) {
            for(int j=n;j>=(n-i+1);j--) {
                System.out.print(j);
            }
            System.out.println();
        }


    }
}
