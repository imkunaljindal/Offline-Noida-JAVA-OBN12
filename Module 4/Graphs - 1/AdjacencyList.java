import java.util.ArrayList;

public class AdjacencyList {

    static void addEdge(ArrayList<ArrayList<Integer>> adjList, int i, int j, boolean idBidir) {
        adjList.get(i).add(j);
        if(idBidir) {
            adjList.get(j).add(i);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList,0,1,true);
        addEdge(adjList,1,2,true);
        addEdge(adjList,2,3,true);

        for(int i=0;i<V;i++) {
            System.out.print(i + " -> ");
            for(int j=0;j<adjList.get(i).size();j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }




    }
}
