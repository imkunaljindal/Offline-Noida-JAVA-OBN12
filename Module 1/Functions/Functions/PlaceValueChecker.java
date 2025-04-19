package Functions;

import java.util.Scanner;

public class PlaceValueChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        boolean res = determineSecondLastDigit(n);
        if (res)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean determineSecondLastDigit(int n) {
        n = n/10;
        int secondLast = n%10;
        if(secondLast==0) {
            return true;
        }

        return false;
    }
}
