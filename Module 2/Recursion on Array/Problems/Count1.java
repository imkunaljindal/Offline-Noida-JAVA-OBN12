package Problems;

import java.util.*;

public class Count1 {
    static int count1(int n) {
        if(n==0) return 0;

        int lastDig = n%10;
        int ans = 0;
        if(lastDig==1) {
            ans = 1;
        }
        return count1(n/10) + ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count1(n));
        sc.close();
    }


}
