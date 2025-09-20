import java.util.*;

class Solution {

    @SuppressWarnings("unchecked")

    public int canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[n];

        for(int edge[]: prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) q.add(i);
        }
        if(q.isEmpty()) return 0;

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int nbr: adj.get(node)) {
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }

        if(ans.size()==n) return 1;
        return 0;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }

        Solution Obj = new Solution();
        System.out.println(Obj.canFinish(N,prerequisites));

    }
}