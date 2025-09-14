import java.io.*;
import java.util.*;
import java.lang.*;

class Pair {
    int src;
    int dist;

    public Pair(int src, int dist) {
        this.src = src;
        this.dist = dist;
    }
}

public class Main {
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dist[] = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b) -> a.dist-b.dist
        );

        // source
        pq.add(new Pair(S,0));
        dist[S] = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int src = p.src;

            for(ArrayList<Integer> nbrs: adj.get(src)) {
                int dest = nbrs.get(0);
                int weight = nbrs.get(1);

                if(dist[dest] > dist[src] + weight) {
                    dist[dest] = dist[src] + weight;
                    pq.add(new Pair(dest,dist[dest]));
                }
            }
        }

        // unreachable nodes
        for(int i=0;i<V;i++) {
            if(dist[i]==Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        String str[] = read.readLine().trim().split(" ");
        int V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        int i=0;
        while (i++<E) {
            String S[] = read.readLine().trim().split(" ");
            int u = Integer.parseInt(S[0]);
            int v = Integer.parseInt(S[1]);
            int w = Integer.parseInt(S[2]);
            ArrayList<Integer> t1 = new ArrayList<Integer>();
            ArrayList<Integer> t2 = new ArrayList<Integer>();
            t1.add(v);
            t1.add(w);
            t2.add(u);
            t2.add(w);
            adj.get(u).add(t1);
            adj.get(v).add(t2);
        }

        int S = Integer.parseInt(read.readLine());

        int[] ptr = dijkstra(V, adj, S);

        for(i=0; i<V; i++)
            System.out.print(ptr[i] + " ");
        System.out.println();
    }


}
