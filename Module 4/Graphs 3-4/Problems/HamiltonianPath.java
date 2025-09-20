import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

    static boolean dfs(int src, boolean[] vis,
                       ArrayList<ArrayList<Integer>> adj,
                       int cnt,
                       int N) {
        if(cnt==N) return true;
        vis[src] = true;
        for(int nbr: adj.get(src)) {
            if(!vis[nbr] && dfs(nbr,vis,adj,cnt+1,N)) return true;
        }
        vis[src] = false;
        return false;
    }

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=N;i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge: Edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean vis[] = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            if(dfs(i,vis,adj,1,N)==true) return true;
        }
        return false;
    }
}