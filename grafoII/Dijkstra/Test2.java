import java.util.*;

public class Test2 {
	
	
	private static void getRoute(int[] prev, int i, List<Integer> route) {
		if (i >= 0) {
			getRoute(prev, prev[i], route);
			route.add(i);
		}
	}

	public static void findShortestPaths(Grafo graph, int source, int n) {
		PriorityQueue<Heap> minHeap;
		minHeap = new PriorityQueue<>(Comparator.comparingInt(heap -> heap.weight));
		minHeap.add(new Heap(source, 0));

		List<Integer> dist;
		dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

		dist.set(source, 0);

		boolean[] done = new boolean[n];
		done[source] = true;

		int[] prev = new int[n];
		prev[source] = -1;

		while (!minHeap.isEmpty()) {
			
			Heap node = minHeap.poll();

			int u = node.vertex;

			for (Node aux : graph.adjList.get(u)) {
				int v = aux.dest;
				int weight = aux.weigth;

				if (!done[v] && (dist.get(u) + weight) < dist.get(v)) {
					dist.set(v, dist.get(u) + weight);
					prev[v] = u;
					minHeap.add(new Heap(v, dist.get(v)));
				}
			}

			done[u] = true;
		}

		List<Integer> route = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (i != source && dist.get(i) != Integer.MAX_VALUE) {
				getRoute(prev, i, route);
				System.out.printf("Ruta (%d —> %d): de Costo Minimo = %d, Ruta = %s\n", source, i, dist.get(i), route);
				route.clear();
			}
		}
	}
}
