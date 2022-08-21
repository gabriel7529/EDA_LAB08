public class Test {
	public static void main(String[] args) {
		Grafos_2 g = new Grafos_2(10);
		Grafos_2 f = new Grafos_2(15);

		g.insertaArista(1, 2, 1);
		g.insertaArista(2, 3, 2);
		g.insertaArista(3, 4, 5);
		g.insertaArista(5, 6, 3);

		f.insertaArista(1, 2, 1);
		f.insertaArista(2, 3, 2);
		f.insertaArista(3, 4, 5);
		f.insertaArista(4, 5, 3);
		f.insertaArista(5, 6, 1);
		f.insertaArista(6, 7, 2);
		f.insertaArista(7, 8, 5);
		g.mostrarGrafo();
		f.mostrarGrafo();
		if(Grafos_2.grafoInclude(g, f))
			System.out.println("Grafo incluido");
		else
			System.out.println("Grafo no incluido");
		
	}
}
