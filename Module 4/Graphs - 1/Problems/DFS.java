import java.util.*;

class Solution {

    static void dfs(ArrayList<ArrayList<Integer>> adjList, int src, boolean[] vis) {
        vis[src] = true;
        System.out.print(src + " ");

        ArrayList<Integer> nbrs = adjList.get(src);
        Collections.sort(nbrs); // question mein bola hai
        for(int nbr: nbrs) {
            if(!vis[nbr]) {
                dfs(adjList,nbr,vis);
            }
        }
    }

    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adjList.add(new ArrayList<>());
        }

        for(List<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean vis[] = new boolean[n+1];
        dfs(adjList,0,vis);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}