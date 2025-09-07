import java.util.*;
import java.io.*;

class Graph {
    public int vertices;
    public ArrayList<Integer>[] adjList;

    Graph(int v) {
        this.vertices = v + 1;
        adjList = new ArrayList[v + 1];

        for (int i = 0; i <= v; i++) adjList[i] = new ArrayList<Integer>();
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    void BFS(int x) {
        boolean vis[] = new boolean[vertices + 1];
        for(int i=0;i<=vertices;i++) {
            if(!vis[i]) {
                BFSHelper(i,vis);
            }
        }
    }

    void BFSHelper(int x, boolean vis[]) {
        // your code here
        Queue<Integer> q = new ArrayDeque<>();


        q.add(x);
        vis[x] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            // get all the neighbors of node
            ArrayList<Integer> nbrs = adjList[node];
            for (int nbr : nbrs) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }

    }
}

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(110);
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x, y);
        }
        g.BFS(0);
    }
}
