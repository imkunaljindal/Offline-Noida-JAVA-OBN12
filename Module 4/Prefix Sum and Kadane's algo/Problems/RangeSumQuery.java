import java.util.*;

class Solution {
    public int[] sumQuery(int[] arr, int[][] ranges) {
        int n = arr.length;
        int q = ranges.length;

        // prepare prefix sum array
        int prefix[] = new int[n];
        for(int i=0;i<n;i++) {
            if(i==0) prefix[i] = arr[i];
            else prefix[i] = prefix[i-1] + arr[i];
        }

        int[] ans = new int[q];
        for(int i=0;i<q;i++) {
            int l = ranges[i][0];
            int r = ranges[i][1];

            if(l==0) ans[i] = prefix[r];
            else ans[i] = prefix[r] - prefix[l-1];
        }

        return ans;


    }
}

public class RangeSumQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}