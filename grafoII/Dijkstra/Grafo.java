import java.util.*;
class Grafo {
	List<List<Node>> adjList = null;
	// Constructor
	Grafo(List<Node> Nodes, int n){
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Node node: Nodes){
            adjList.get(node.source).add(node);
        }
    }
}
