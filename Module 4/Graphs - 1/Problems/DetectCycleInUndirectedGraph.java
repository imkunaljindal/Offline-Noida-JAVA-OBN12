import java.io.*;
import java.util.*;

class Solution {

    static boolean dfs(ArrayList<ArrayList<Integer>> adj,
                       int src,
                       int parent,
                       boolean vis[]) {
        vis[src] = true;
        ArrayList<Integer> nbrs = adj.get(src);
        for(int nbr: nbrs) {
            if(!vis[nbr]) {
                vis[nbr] = true;
                if(dfs(adj,nbr,src,vis)) return true;
            }
            else if(nbr!=parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V+1];

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
              if(dfs(adj,i,-1,vis)) return true;
            }
        }
        return false;
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}