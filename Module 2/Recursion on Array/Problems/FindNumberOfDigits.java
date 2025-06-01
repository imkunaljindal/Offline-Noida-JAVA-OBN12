package Problems;

import java.util.*;

public class FindNumberOfDigits {
    static int numOfDigi(int n) {
        if(n>=1 && n<=9) return 1;
        int x = numOfDigi(n/10);
        return 1+x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int result = numOfDigi(n);
        System.out.println(result);
        sc.close();
    }
}