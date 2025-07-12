package Problems;

import java.util.*;

public class Search2DMatrix {
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int s = 0;
        int e = m*n-1;

        while(s<=e) {
            int mid = s + (e-s)/2;
            int curr = mat[mid/m][mid%m];
            if(curr==x) return true;
            if(curr>x) e = mid-1;
            else s = mid+1;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}