import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int row;
    int col;
    int dist;

    public Node(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class Main
{

    public static int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];

        Queue<Node> q = new ArrayDeque<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    q.add(new Node(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Node curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currDist = curr.dist;
            grid[currRow][currCol] = currDist;

            int dx[] = {0,1,0,-1};
            int dy[] = {1,0,-1,0};

            for(int i=0;i<4;i++) {
                int nRow = currRow + dx[i];
                int nCol = currCol + dy[i];

                if(nRow >=0 && nCol >=0 && nRow<n && nCol<m && !vis[nRow][nCol]) {
                    q.add(new Node(nRow,nCol,currDist+1));
                    vis[nRow][nCol] = true;
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] S = br.readLine().trim().split(" ");
            for(int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(S[j]);
            }
        }
        int[][] ans = nearest(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }
}