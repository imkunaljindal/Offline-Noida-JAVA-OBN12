
import java.util.*;

class Solution {
    public static void coinChange(int[] coins, int amt){
        int n = coins.length;
        boolean vis[] = new boolean[n];
        helper(coins,0,amt,"",vis);
    }

    static void helper(int[] coins, int idx, int amt,
                       String coinSet, boolean vis[]) {

        if(amt==0) {
            System.out.println(coinSet);
            return;
        }

        if(amt<0 || idx>=coins.length) {
            return;
        }

        // include
        if(vis[idx]==false) {
            vis[idx] = true;
            helper(coins,0,amt-coins[idx],coinSet+coins[idx] + " ",vis);
            vis[idx] = false;
        }

        //exclude
        helper(coins,idx+1,amt,coinSet,vis);

    }
}

public class CoinPermutations1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        Solution Obj = new Solution();
        Obj.coinChange(coins, amt);
    }
}