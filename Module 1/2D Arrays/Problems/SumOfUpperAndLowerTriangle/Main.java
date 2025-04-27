package Problems.SumOfUpperAndLowerTriangle;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        triangleSums(n, matrix);
        sc.close();
    }

    public static void triangleSums(int n, int[][] matrix) {
        int lower = 0;
        int upper = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i>=j) {
                    lower += matrix[i][j];
                }
                if(i<=j) {
                    upper += matrix[i][j];
                }
            }
        }
        System.out.println(upper + " " + lower);
    }
}