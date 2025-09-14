import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{

    static void dfs(int[][] grid, int i, int j, int n, int m) {
        if(i<0 || j<0 || i>=n || j>=m) return;
        if(grid[i][j]==0) return;
        grid[i][j] = 0;

        // neighbors pe dfs call
        dfs(grid,i+1,j,n,m);
        dfs(grid,i-1,j,n,m);
        dfs(grid,i,j-1,n,m);
        dfs(grid,i,j+1,n,m);
        dfs(grid,i-1,j-1,n,m);
        dfs(grid,i+1,j-1,n,m);
        dfs(grid,i-1,j+1,n,m);
        dfs(grid,i+1,j+1,n,m);

    }

    static int numberOfIslands(int[][] grid, int n, int m){
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    dfs(grid,i,j,n,m);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int M[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = sc.nextInt();
            }
        }
        System.out.println(Solution.numberOfIslands(M, m, n));
    }
}