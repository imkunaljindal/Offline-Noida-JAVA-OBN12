import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Solution obj= new Solution();

        System.out.println(obj.orangesRotting(arr));
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution{
    public static int orangesRotting(int[][] grid) {

        Queue<Pair> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;

        // push initially rotten oranges
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==2) {
                    q.add(new Pair(i,j));
                }
            }
        }

        int time = -1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;

                // up
                if(x-1>=0 && grid[x-1][y]==1) {
                    q.add(new Pair(x-1,y));
                    grid[x-1][y] = 2;
                }

                // down
                if(x+1 < n && grid[x+1][y]==1) {
                    q.add(new Pair(x+1,y));
                    grid[x+1][y] = 2;
                }

                // right
                if(y+1 < m && grid[x][y+1]==1) {
                    q.add(new Pair(x,y+1));
                    grid[x][y+1] = 2;
                }

                // left
                if(y-1>=0 && grid[x][y-1]==1) {
                    q.add(new Pair(x,y-1));
                    grid[x][y-1] = 2;
                }
            }
            time++;
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) return -1;
            }
        }

        return time;
    }
}
