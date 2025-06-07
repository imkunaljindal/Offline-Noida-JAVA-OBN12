package Problems;

import java.io.*;
import java.util.*;
class TowerOfHanoi {
    static void toh(int n, int source, int auxiliary, int destination) {
        if(n==0) return;
        toh(n-1,source,destination,auxiliary);
        System.out.println("move disk "+n+" from rod "+source+" to rod "+destination);
        toh(n-1,auxiliary,source,destination);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;

        N = sc.nextInt();

        toh(N, 1, 2, 3);

        sc.close();
    }
}

