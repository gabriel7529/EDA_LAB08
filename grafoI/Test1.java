public class Test1 {
	public static void main(String[] args) {
		Grafo g = new Grafo(10);
		
		//Prueba de añadir al grafo (v1, v2, peso) 
		g.insertaArista(1, 2, 1);
		g.insertaArista(2, 3, 2);
		g.insertaArista(4, 5, 5);
		g.insertaArista(5, 6, 3);
		
		g.mostrarGrafo();
		
		//Prueba de eliminación 
		
		g.eliminarArista(5, 6);
		g.mostrarGrafo();
		
		//Prueba del ver si existe arista
		
		System.out.println(g.existeArista(5, 6));
		System.out.println(g.existeArista(1, 2));
	}
}
