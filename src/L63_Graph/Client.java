package L63_Graph;

import java.util.HashSet;

public class Client {

	public static void main(String[] args) {

		Graph g = new Graph(7);
		g.addEdge(1, 2, 10);
		g.addEdge(1, 4, 20);
		g.addEdge(2, 3, 30);
		g.addEdge(3, 4, 50);
		g.addEdge(4, 5, 6);
		g.addEdge(5, 6, 8);
		g.addEdge(6, 7, 5);
		g.addEdge(5, 7, 9);

		g.display();
//		System.out.println(g.numEdges());		
//		System.out.println(g.containsEdge(3, 4));
//		g.removeEdge(4, 5);
//		g.removeEdge(2, 3);
		g.removeEdge(6, 7);
		// g.display();
//		System.out.println(g.containsEdge(3, 4));
//		System.out.println(g.numEdges());	
//		
//		// System.out.println(g.hasPath(1, 6, new HashSet<>())) ;
//		
//		g.printAllPaths(1, 6, new HashSet<>(), "1");

//		System.out.println(g.BFS(1, 6));
//		System.out.println(g.DFS(1, 6));
//		
//		g.BFT();
//		g.DFT(); 

		System.out.println(g.isCyclic());
		System.out.println(g.isConnected());
		System.out.println(g.isTree());
		System.out.println(g.getCC());
		System.out.println(g.bipartite());

	}
}
