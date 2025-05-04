package Problems;

import java.util.*;

public class MaximaMinima {
    public static int maximaMinima(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int minRow[] = new int[r];
        int maxCol[] = new int[c];

        for(int i=0;i<r;i++) {
            int currMin = Integer.MAX_VALUE;
            for(int j=0;j<c;j++) {
                currMin = Math.min(currMin,mat[i][j]);
            }
            minRow[i] = currMin;
        }

        for(int j=0;j<c;j++) {
            int currMax = Integer.MIN_VALUE;
            for(int i=0;i<r;i++) {
                currMax = Math.max(currMax,mat[i][j]);
            }
            maxCol[j] = currMax;
        }

        for(int i=0;i<r;i++) {
            if(minRow[i]==maxCol[i]) {
                return minRow[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        int result = maximaMinima(matrix);
        System.out.println(result);
        sc.close();
    }
}