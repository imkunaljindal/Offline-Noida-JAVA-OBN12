import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

class Solution {

    @SuppressWarnings("unchecked")

    public int[] canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int indegree[] = new int[n];
        for(int []egde: prerequisites) {
            int u = egde[0];
            int v = egde[1];
            adj.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int nbr: adj.get(node)) {
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }

        if(ans.size()<n) {
            return new int[]{-1};
        }

        int sol[] = new int[n];
        for(int i=0;i<ans.size();i++) {
            sol[i] = ans.get(i);
        }
        return sol;


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
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}