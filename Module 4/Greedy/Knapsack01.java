//{ Driver Code Starts
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public
    static void main(String args[]) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String xx[] = read.readLine().trim().split("\\s+");
        int n = Integer.parseInt(xx[0]);
        int w = Integer.parseInt(xx[1]);
        int val[] = new int[n];
        int wt[] = new int[n];
        String st[] = read.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++)
            val[i] = Integer.parseInt(st[i]);
        String s[] = read.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++)
            wt[i] = Integer.parseInt(s[i]);
        System.out.println(new Solution().knapSack(w, wt, val, n));
    }
}

class Solution
{

    static int helper(int W, int wt[], int val[], int i, int N, int dp[][]) {
        if(W==0 || i==N) return 0;

        if(dp[W][i]!=-1) return dp[W][i];

        // option 1 -> nhi jaye
        int op1 = helper(W,wt,val,i+1,N,dp);

        // option 2 -> goes into knappsack
        int op2 = 0;
        if(wt[i]<=W) {
           op2 = helper(W-wt[i],wt,val,i+1,N,dp) + val[i];
        }

        return dp[W][i] = Math.max(op1,op2);
    }

    static int knapSack(int W, int wt[], int val[], int N)
    {
        int dp[][] = new int[W+1][N+1];
       for(int i=0;i<=W;i++) {
           for(int j=0;j<=N;j++) dp[i][j] = -1;
       }
        return helper(W,wt,val,0,N,dp);
    }
}


