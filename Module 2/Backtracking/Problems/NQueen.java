package Problems;

import java.util.*;

public class NQueen {
    static boolean isSafe(int [][]board, int r, int c, int n) {
        // same column mein queen check
        for(int i=0;i<r;i++) {
            if(board[i][c]==1) {
                return false;
            }
        }

        // diagonal mein check
        int x = r-1;
        int y = c-1;
        while(x>=0 && y>=0) {
            if(board[x][y]==1) {
                return false;
            }
            x--;
            y--;
        }
        // reverse diagonal mein check
        x= r-1;
        y = c+1;
        while(x>=0 && y<n) {
            if(board[x][y]==1) {
                return false;
            }
            x--;
            y++;
        }

        return true;  // safe cell

    }

    static void placeQueen(int board[][], int r, int n) {

        if(r==n) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, r, i, n)) {
                board[r][i] = 1;  //placing the queen
                placeQueen(board,r+1,n);
                board[r][i] = 0; // removing the queen - backtracking
            }
        }

    }

    public static void totalNQueens(int n) {

        int[][] board = new int[n][n];
        placeQueen(board,0,n);
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        totalNQueens(n);
    }
}