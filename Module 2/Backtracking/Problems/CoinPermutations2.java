
import java.util.*;

class Solution {
    public static void coinChange2(int[] coins, int amt){
        helper(coins,0,amt,"");
    }

    static void helper(int []coins, int idx, int amt, String ans) {

        if(amt==0) {
            System.out.println(ans);
            return;
        }
        if(amt<0 || idx>=coins.length) return;

        //include
        helper(coins,0,amt-coins[idx],ans+coins[idx]+" ");
        //exclude
        helper(coins,idx+1,amt,ans);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        Solution Obj = new Solution();
        Obj.coinChange2(coins, amt);
    }
}