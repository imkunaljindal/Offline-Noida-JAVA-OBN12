import java.util.*;

class Solution {

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int[] color, int col) {

        color[src] = col;

        for(int nbr: adj.get(src)) {
            if(color[nbr]==-1) {
                if(!dfs(adj,nbr,color,1-col)) return false;
            }
            else if(color[nbr]==col) return false;
        }

        return true;
    }

    public int possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] dislike: dislikes) {
            int u = dislike[0];
            int v = dislike[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int color[] = new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++) {
            if(color[i]==-1) {
                if(dfs(adj,i,color,0)==false) return 0;
            }
        }

        return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }

        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}