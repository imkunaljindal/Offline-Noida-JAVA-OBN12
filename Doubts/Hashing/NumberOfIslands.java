import java.util.*;

class Solution {

    public static void dfs(int[][] grid,int i, int j, int a, int b, ArrayList<String> dfsPath) {

        if(grid[i][j]==0) return;

        int shiftedX = i-a;
        int shiftedY = j-b;
        dfsPath.add(shiftedX + " " + shiftedY);

        grid[i][j] = 0;

        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};

        for(int k=0;k<4;k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            if(newX < 0 || newX >= grid.length || newY < 0 || newY >=grid[0].length) continue;
            dfs(grid,newX,newY,a,b,dfsPath);
        }
    }

    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        HashSet<ArrayList<String>> ans = new HashSet<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    ArrayList<String> dfsPath = new ArrayList<>();
                    dfs(grid, i,j,i,j,dfsPath);
                    ans.add(dfsPath);
                }
            }
        }
        return ans.size();
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}