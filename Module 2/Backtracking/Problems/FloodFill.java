package Problems;

import java.util.*;

public class FloodFill {
    public static void FloodFill(int[][] w, int x, int y, int c) {
        if(w[x][y]==c) return;
        helper(w,x,y,w[x][y],c);
    }

    static void helper(int[][]w, int x, int y, int origColor, int newColor) {
        if(x<0 || y<0 || x>=w.length || y>=w[0].length) return;
        if(w[x][y]!=origColor) return;

        w[x][y] = newColor;
        helper(w,x-1,y,origColor,newColor);
        helper(w,x,y-1,origColor,newColor);
        helper(w,x,y+1,origColor,newColor);
        helper(w,x+1,y,origColor,newColor);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] w = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; ++j)
                w[i][j] = sc.nextInt();
        }
        int x = sc.nextInt(), y = sc.nextInt(), c = sc.nextInt();
        FloodFill(w, x, y, c);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(w[i][j] + " ");
            System.out.println();
        }
    }
}