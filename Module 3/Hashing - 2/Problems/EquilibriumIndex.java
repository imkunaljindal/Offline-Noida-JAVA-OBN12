package Problems;

import java.util.*;

public class EquilibriumIndex {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = Solution.findEquilibriumIndex(a);
        System.out.println(ans);
    }
}

class Solution {
    static int findEquilibriumIndex(int[] a) {
        int n = a.length;

        int prefixSum[] = new int[n];
        prefixSum[0] = a[0];
        for(int i=1;i<n;i++) {
            prefixSum[i] = prefixSum[i-1] + a[i];
        }

        int suffixSum[] = new int[n];
        suffixSum[n-1] = a[n-1];

        for(int i=n-2;i>=0;i--) {
            suffixSum[i] = suffixSum[i+1] + a[i];
        }

        for(int i=0;i<n;i++) {
            if(prefixSum[i]==suffixSum[i]) return i;
        }

        return -1;
    }
}