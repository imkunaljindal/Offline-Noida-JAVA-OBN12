import java.io.*;
import java.util.*;
class Solution {
    public void solve(Scanner sc) {
        long N = sc.nextLong();

        long sq = N * N;
        while (N > 0) {
            if (N % 10 != sq % 10) {
                System.out.println("Not an Automorphic Number");
                return;
            }
            N /= 10;
            sq /= 10;
        }
        System.out.println("Automorphic Number");
    }
}
public class AutomorphicNumberOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        solution.solve(sc);
    }
}
