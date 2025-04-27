package Problems.BoundaryTraversal;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        boundaryTraversal(m, n, matrix);
        sc.close();
    }

    public static void boundaryTraversal(int m, int n, int[][] matrix) {

        if (m == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(matrix[0][i] + " ");
            }
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                System.out.print(matrix[i][0] + " ");
            }
        } else {
            for (int c = 0; c < n; c++) {
                System.out.print(matrix[0][c] + " ");
            }

            for (int r = 1; r < m; r++) {
                System.out.print(matrix[r][n - 1] + " ");
            }

            for (int c = n - 2; c >= 0; c--) {
                System.out.print(matrix[m - 1][c] + " ");
            }

            for (int r = m - 2; r >= 1; r--) {
                System.out.print(matrix[r][0] + " ");
            }
        }
    }
}