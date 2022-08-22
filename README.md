<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">DEPARTAMENTO ACADÉMICO DE INGENIERÍA DE SISTEMAS E INFORMÁTICA</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>:Informe de Práctica de Laboratorio</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>

<div align="center">
<span style="font-weight:bold;">INFORME DE LABORATORIO</span><br />
</div>


<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">Estructura de Datos y Algoritmos</td></tr><tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Grafos</td></tr>
<td>NÚMERO DE PRÁCTICA:</td><td>08</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA DE PRESENTACIÓN:</td><td>21-Agosto-2022</td><td>HORA DE PRESENTACIÓN:</td><td colspan="3">23:55</td>
</tr>
<tr><td colspan="4">Integrantes:
        <ul>
            <li><h5>Machicao Quispe, Gabriel Steven</h5></li>
        </ul>
    </td>
    <td colspan="2">Nota:</td>
</tr>
<tr><td colspan="6">DOCENTES:
<ul>
<li>Richart Smith Escobedo Quispe - rescobedoq@unsa.edu.pe</li>
</ul>
</td>
</tr>
</tdbody>
</table>

<table>
    <theader>
        <tr><th colspan="6">SOLUCIÓN Y RESULTADOS</th></tr>
	<h2>Implementar el cogido de Grafo cuya representacion sea realizada mediante LISTA DE ADYACENCIA.</h2>
	<p> Se hace la siguiente clase llamada Grafo con los métodos correspondientes para almacenar vectores y estos formen aristas, para realizar la lista de adyacencia se debe hacer grafos dirigidos, es por ello que la clase se dedica a crear dichos grafos; el programa se encuentra en grafosI</p><br>

	    
```java
	    
private Nodo grafo[];
        private int nroVertices;

        class Nodo {
                int vertice;
                int pesoArista;
                Nodo sgte;

                public Nodo(int v, int a) {
                        this.vertice = v;
                        this.pesoArista = a;
                        this.sgte = null;
                }
        }
```
Los métodos que determinan la creación de una arista, depende del método booleano existeArista, que averigua si existe la arista, para luego que lo use el método insertaArista para cuando exista devuelva un mensaje y si no, inserte dicha arista con sus vectores

```java
	     public boolean existeArista(int v1, int v2) {
                if (grafo[v1] == null)
                        return false;
                Nodo actual = grafo[v1];
                while (actual != null) {
                        if (actual.vertice == v2)
                                return true;
                        actual = actual.sgte;
                }
                return false;
        }

        public void insertaArista(int v1, int v2, int peso) {

                if (!existeArista(v1, v2)) {
                        Nodo nuevo = new Nodo(v2, peso);

                        if (grafo[v1] == null) {
                                grafo[v1] = nuevo;
                        } else {
                                Nodo actual = grafo[v1];
                                while (actual.sgte != null) {
                                        actual = actual.sgte;
                                }

                                actual.sgte = nuevo;
                        }
                } else {
                        System.out.println("Ya existe una arista entre:" + v1 + " y " + v2);
                }
        }
```
Luego se crea eliminarArista que también usa el mismo método de insertar para luego hacer el reemplazo y eliminación de la arista y del vertice o los vertices determinados, también se crea un mostrar grafo para imprimir el resultado.

```java
	    public void eliminarArista(int v1, int v2) {
                if (existeArista(v1, v2)) {
                        Nodo actual = grafo[v1];

                        if (actual.vertice == v2) {
                                grafo[v1] = actual.sgte;
                        } else {
                                Nodo anterior = actual;
                                actual = actual.sgte;

                                while (actual != null) {
                                        if (actual.vertice == v2) {
                                                anterior.sgte = actual.sgte;
                                                return;
                                        }
                                        anterior = actual;
                                        actual = actual.sgte;
                                }
                        }
                } else {
                        System.out.println("No existe una arista entre: " + v1 + " y " + v2);
                }
        }
	    
		public void mostrarGrafo() {
		    for (int i = 0; i < grafo.length; i++) {
		      Nodo actual = grafo[i];

		      while (actual != null) {
			System.out.printf("Vertice v1 = %d -> ", i);
			System.out.printf("Vertice v2 = %d peso = (%d)\n", actual.vertice, actual.pesoArista);

			actual = actual.sgte;
		      }
		      System.out.println();
		    }
		  }
```
Se hace una prueba a traves del Test que esta en la carpeta mencionada:<br>
<img src= "Imagenes/Imagen_01"><br>
	    <h2>Implementar BSF, DFS y Dijkstra con sus respectivos casos de prueba.</h2><br>
	    Para la implementación del BSF Y DFS, se hace uso de un grafo no dirigido, que se encuentra en la carpeta grafoII, en esta se encuentra las clases Node y grafo que Node tiene los siguientes atributos<br>
	    
```java
	    public class Node {
        int source, dest;

        public Node(int source, int dest) {
                this.source = source;
                this.dest = dest;
        }
}
```
Este Node se usa en la clase Grafo a traves de una doble List de esa clase, que por medio de ciclos y el arralist van introduciendo los elementos y atributos del la clase Node.<br>
```java
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
```
Se hacen dos Test para evaluar cada uno de los métodos en el cuál el Test2 que se hace el BSF, a traves de este método<br>


	    
    </theader>
    <tbody>
        <tr><td colspan="6">I. SOLUCIÓN DE EJERCICIOS/PROBLEMAS
          <ul>
          <li> 
	   </li>
          </td></tr>   
        <tr><td colspan="6">II. SOLUCIÓN DEL CUESTIONARIO
         <ul>
         <li>¿Cuantas variantes del algoritmo de Dijkstra hay y cuál es la diferencia entre
ellas?
              <ul>
		</li>
               </ul>
           </li>
        <li>Invetigue sobre los ALGORITMOS DE CAMINOS MINIMOS e indique, ¿Qué
similitudes encuentra, qué diferencias, en qué casos utilizar y porque?
            <ul>
            </ul>
        </li>
         </ul>
        </td></tr>
        <tr><td colspan="6">III. CONCLUSIONES
          <li></li>
</td></tr>
 </tbody>
</table>

<table>
    <theader>
        <tr><th>RETROALIMENTACIÓN</th></tr>
    </theader>
    <tbody>
         <tr><td colspan="6">                       </td></tr>
    </tbody>
</table>

<table>
    <theader>
        <tr><th>REFERENCIAS Y BIBLIOGRAFIA</th></tr>
    </theader>
    <tbody>
        <tr><td>
            <ul>
              <li>..</li>
            </ul></td>
        </tr>
    </tbody>
</table>
