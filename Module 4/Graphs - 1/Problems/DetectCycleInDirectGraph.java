import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static boolean dfs(ArrayList<Integer>[] adj,
                       int src,
                       boolean vis[]) {

        vis[src] = true;
        ArrayList<Integer> nbrs = adj[src];
        for(int nbr: nbrs) {
            if(!vis[nbr]) {
                if(dfs(adj,nbr,vis)) return true;
            }
            else{
                return true;
            }
        }
        vis[src] = false;  // backtack because we chose wrong/non cyclic path
        return false;
    }

    public boolean isCyclic(int V, ArrayList<Integer>[] adj) {
        boolean vis[] = new boolean[V+1];

        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                if(dfs(adj,i,vis)) return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}