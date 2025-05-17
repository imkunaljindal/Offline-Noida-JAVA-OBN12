package Problems;

import java.util.*;
public class PrintNumbersInReverse {

    public static void printtillN(int N) {
        if(N==0) return;

        printtillN(N-1);
        System.out.print(N + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        printtillN(N);
        sc.close();
    }
}