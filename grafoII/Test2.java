import java.util.*;

public class Test2 {
	public static void main(String[] args) {
		List<Node> nodes = Arrays.asList(new Node(1, 9), new Node(3, 8), new Node(2, 7), new Node(7, 2));
		Grafo graph = new Grafo(nodes, 10);

		boolean[] discovered = new boolean[10];

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < 5; i++) {
			if (discovered[i] == false) {
				discovered[i] = true;
				q.add(i);
				
				recursiveBFS(graph, q, discovered);
			}
		}
	}

	public static void recursiveBFS(Grafo graph, Queue<Integer> q, boolean[] discovered) {
		if (q.isEmpty()) {
			return;
		}
		int v = q.poll();
		System.out.print(v + " ");

		for (int u : graph.adjList.get(v)) {
			if (!discovered[u]) {
				discovered[u] = true;
				q.add(u);
			}
		}
		recursiveBFS(graph, q, discovered);
	}
}
