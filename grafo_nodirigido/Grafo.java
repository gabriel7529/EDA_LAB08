import java.util.*;
class Grafo {
	List<List<Integer>> adjList = null;
	// Constructor
	Grafo(List<Node> Nodes, int n){
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Node node: Nodes){
            int src = node.source;
            int dest = node.dest;
            
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
