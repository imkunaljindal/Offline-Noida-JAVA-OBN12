package Problems.FindTheWay;

import java.util.*;

public class Main {
    public static int[] findTheWay(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dir = 0;
        int i = 0;
        int j = 0;

        int ans[] = new int[2];

        // O(n*m)
        while(i>=0 && j>=0 && i<n && j<m) {
            if(matrix[i][j]==1) {
                if(dir==0) {
                    dir = 1;
                }
                else if(dir==1) {
                    dir = 2;
                }
                else if(dir==2) {
                    dir = 3;
                }
                else {
                    dir = 0;
                }
                matrix[i][j] = 0;
            }

            ans[0] = i;
            ans[1] = j;
            if(dir==0) {
                j++;
            }
            else if(dir==1) {
                i++;
            }
            else if(dir==2) {
                j--;
            }
            else {
                i--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int result[] = findTheWay(matrix);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}