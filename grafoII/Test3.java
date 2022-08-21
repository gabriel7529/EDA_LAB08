import java.util.*;

public class Test3 {
	public static void main(String[] args) {
		List<Node> nodes = Arrays.asList(new Node(1, 9), new Node(3, 8), new Node(2, 7), new Node(7, 2));
		Grafo grafo = new Grafo(nodes, 10);

		boolean[] discovered = new boolean[10];

		for (int i = 0; i < 5; i++) {
			
			if(!discovered[i])
				DFS(grafo, i, discovered);
		}
	}


	public static void DFS(Grafo grafo, int v, boolean[] discovered) {
		
		discovered[v] = true;
		
		System.out.print(v + " ");
	
		for (int u : grafo.adjList.get(v)) {
			if (!discovered[u]) {
				DFS(grafo, u, discovered);
			}
		}
	}
}
