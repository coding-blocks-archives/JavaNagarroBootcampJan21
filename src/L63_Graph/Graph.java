package L63_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

	public Graph(int V) {

		for (int i = 1; i <= V; i++) {
			map.put(i, new HashMap<>());
		}

	}

	public void addEdge(int v1, int v2, int cost) {

		map.get(v1).put(v2, cost);
//		map.get(v2).put(v1, cost);

	}

	public boolean containsEdge(int v1, int v2) {

		return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);

	}

	public int numEdges() {

		int ans = 0;

		for (int key : map.keySet()) {
			ans += map.get(key).size();
		}

		return ans / 2;
	}

	public void removeEdge(int v1, int v2) {

		map.get(v1).remove(v2);
		map.get(v2).remove(v1);

	}

	public void display() {

		System.out.println("----------------------");

		for (int i = 1; i <= map.size(); i++) {
			System.out.println(i + " -> " + map.get(i));
		}

		System.out.println("----------------------");
	}

	public boolean hasPath(int src, int dst, Set<Integer> visited) {

		// as soon as you visit a node, marks it as visited
		visited.add(src);

		// check if you have reached the dst
		if (src == dst) {
			return true;
		}

		// check if path exists from nbrs
		for (int nbr : map.get(src).keySet()) {

			// ask for path only from unvisited nbrs
			if (!visited.contains(nbr)) {

				boolean res = hasPath(nbr, dst, visited);

				if (res)
					return true;
			}
		}

		// no path exists even via nbrs
		return false;
	}

	public void printAllPaths(int src, int dst, Set<Integer> visited, String ans) {

		visited.add(src);

		if (src == dst) {
			System.out.println(ans);
			visited.remove(src);
			return;
		}

		for (int nbr : map.get(src).keySet()) {

			if (!visited.contains(nbr)) {

				printAllPaths(nbr, dst, visited, ans + nbr);

			}
		}

		visited.remove(src);
	}

	public boolean BFS(int src, int dst) {

		Set<Integer> visited = new HashSet<>();

		// initial setup
		Queue<Integer> q = new LinkedList<>();
		q.add(src);

		// work till q is not empty
		while (!q.isEmpty()) {

			// q remove
			int rn = q.remove();

			// ignore if the node is already visited
			if (visited.contains(rn))
				continue;

			// visited
			visited.add(rn);

			// work
			if (rn == dst)
				return true;

			// nbrs
			for (int nbr : map.get(rn).keySet()) {

				if (!visited.contains(nbr))
					q.add(nbr);
			}

		}

		return false;

	}

	public boolean DFS(int src, int dst) {

		Set<Integer> visited = new HashSet<>();

		// initial setup
		Stack<Integer> s = new Stack<>();
		s.push(src);

		// work till q is not empty
		while (!s.isEmpty()) {

			// q remove
			int rn = s.pop();

			// ignore if the node is already visited
			if (visited.contains(rn))
				continue;

			// visited
			visited.add(rn);

			// work
			if (rn == dst)
				return true;

			// nbrs
			for (int nbr : map.get(rn).keySet()) {

				if (!visited.contains(nbr))
					s.push(nbr);
			}

		}

		return false;

	}

	public void BFT() {

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		// for every src do the work
		for (int src = 1; src <= map.size(); src++) {

			if (visited.contains(src))
				continue;

			// initial setup
			q.add(src);

			// work till q is not empty
			while (!q.isEmpty()) {

				// q remove
				int rn = q.remove();

				// ignore if the node is already visited
				if (visited.contains(rn))
					continue;

				// visited
				visited.add(rn);

				// work
				System.out.print(rn);

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr))
						q.add(nbr);
				}

			}

		}

		System.out.println();

	}

	public void DFT() {

		Set<Integer> visited = new HashSet<>();
		Stack<Integer> s = new Stack<>();

		// for every src do the work
		for (int src = 1; src <= map.size(); src++) {

			if (visited.contains(src))
				continue;

			// initial setup
			s.push(src);

			// work till q is not empty
			while (!s.isEmpty()) {

				// q remove
				int rn = s.pop();

				// ignore if the node is already visited
				if (visited.contains(rn))
					continue;

				// visited
				visited.add(rn);

				// work
				System.out.print(rn);

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr))
						s.push(nbr);
				}

			}

		}

		System.out.println();

	}

	public boolean isCyclic() {

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		// for every src do the work
		for (int src = 1; src <= map.size(); src++) {

			if (visited.contains(src))
				continue;

			// initial setup
			q.add(src);

			// work till q is not empty
			while (!q.isEmpty()) {

				// q remove
				int rn = q.remove();

				// ignore if the node is already visited
				if (visited.contains(rn))
					return true;

				// visited
				visited.add(rn);

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr))
						q.add(nbr);
				}

			}

		}

		return false;

	}

	public boolean isConnected() {

		int comp = 0;

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		// for every src do the work
		for (int src = 1; src <= map.size(); src++) {

			if (visited.contains(src))
				continue;

			comp++;

			// initial setup
			q.add(src);

			// work till q is not empty
			while (!q.isEmpty()) {

				// q remove
				int rn = q.remove();

				// ignore if the node is already visited
				if (visited.contains(rn))
					continue;

				// visited
				visited.add(rn);

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr))
						q.add(nbr);
				}

			}

		}

		return comp == 1;

	}

	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	public ArrayList<ArrayList<Integer>> getCC() {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		// for every src do the work
		for (int src = 1; src <= map.size(); src++) {

			if (visited.contains(src))
				continue;

			// new component area
			ArrayList<Integer> comp = new ArrayList<>();

			// initial setup
			q.add(src);

			// work till q is not empty
			while (!q.isEmpty()) {

				// q remove
				int rn = q.remove();

				// ignore if the node is already visited
				if (visited.contains(rn))
					continue;

				// visited
				visited.add(rn);

				// work
				comp.add(rn);

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr))
						q.add(nbr);
				}

			}

			ans.add(comp);

		}

		return ans;

	}

	private class Pair {
		int node;
		char color;

		public Pair(int node, char color) {
			this.node = node;
			this.color = color;
		}
	}

	public boolean bipartite() {

		HashMap<Integer, Character> visited = new HashMap<>();
		Queue<Pair> q = new LinkedList<>();

		// for every src do the work
		for (int src = 1; src <= map.size(); src++) {

			if (visited.containsKey(src))
				continue;

			// initial setup
			Pair sp = new Pair(src, 'R');
			q.add(sp);

			// work till q is not empty
			while (!q.isEmpty()) {

				// q remove
				Pair rp = q.remove();

				// ignore if the node is already visited
				// if condn comes out to be true -> cycle -> risk
				if (visited.containsKey(rp.node)) {

					char oc = visited.get(rp.node);
					char nc = rp.color;

					if (oc != nc)
						return false;

					continue;
				}

				// visited
				visited.put(rp.node, rp.color);

				// nbrs
				for (int nbr : map.get(rp.node).keySet()) {

					if (!visited.containsKey(nbr)) {

						char nbrColor = (rp.color == 'R' ? 'G' : 'R');
						Pair np = new Pair(nbr, nbrColor);
						q.add(np);
					}
				}

			}

		}

		return true;

	}

	public class DisjointSet {

		HashMap<Integer, Node> mapping = new HashMap<>();

		private class Node {
			int data;
			Node parent;
			int rank;

		}

		// given a value, you need to create a set
		public void createSet(int value) {

			Node nn = new Node();
			nn.data = value;
			nn.parent = nn;
			nn.rank = 0;

			mapping.put(value, nn);

		}

		// union the sets in which value1 and value2 is present
		public void unionSet(int value1, int value2) {

			Node n1 = mapping.get(value1);
			Node n2 = mapping.get(value2);

			Node re1 = findSet(n1);
			Node re2 = findSet(n2);

			// same set
			if (re1 == re2) {
				return;
			}
			// different se
			else {

				if (re1.rank > re2.rank)
					re2.parent = re1;
				else if (re1.rank < re2.rank)
					re1.parent = re2;
				else {

					re2.parent = re1;
					re1.rank++;
				}
			}

		}

		// given a value, you need to tell the representative element of set
		public int findSet(int value) {
			Node node = mapping.get(value);
			return findSet(node).data;
		}

		private Node findSet(Node node) {

			if (node.parent == node) {
				return node;
			}

			Node rr = findSet(node.parent);
			node.parent = rr;
			return rr;
		}

	}

	private class EdgePair implements Comparable<EdgePair> {

		int v1;
		int v2;
		int cost;

		public EdgePair(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(EdgePair o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return v1 + " - " + v2 + " @ " + cost;
		}
	}

	public ArrayList<EdgePair> getAllEdges() {

		ArrayList<EdgePair> edges = new ArrayList<>();

		for (int i = 1; i <= map.size(); i++) {

			for (int nbr : map.get(i).keySet()) {

				EdgePair ep = new EdgePair(i, nbr, map.get(i).get(nbr));
				edges.add(ep);
			}
		}

		return edges;
	}

	public void kruskal() {

		ArrayList<EdgePair> edges = getAllEdges();
		Collections.sort(edges);

		DisjointSet ds = new DisjointSet();
		for (int i = 1; i <= map.size(); i++) {
			ds.createSet(i);
		}

		for (EdgePair edge : edges) {

			int re1 = ds.findSet(edge.v1);
			int re2 = ds.findSet(edge.v2);

			if (re1 != re2) {
				ds.unionSet(edge.v1, edge.v2);
				System.out.println(edge);
			}

		}

	}

	private class PrimsPair implements Comparable<PrimsPair> {
		int vname;
		int avname;
		int cost;

		public PrimsPair(int vname, int avname, int cost) {

			this.vname = vname;
			this.avname = avname;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return vname + " via " + avname + " @ " + cost;
		}

		@Override
		public int compareTo(PrimsPair o) {
			return this.cost - o.cost;
		}
	}

	public void prims() {

		boolean[] visited = new boolean[map.size() + 1];

		PriorityQueue<PrimsPair> pq = new PriorityQueue<>();

		PrimsPair sp = new PrimsPair(1, 0, 0);
		pq.add(sp);

		while (!pq.isEmpty()) {

			// remove
			PrimsPair rp = pq.remove();

			// already visited , ignore
			if (visited[rp.vname])
				continue;

			// visited
			visited[rp.vname] = true;

			// printing
			if (rp.avname != 0)
				System.out.println(rp);

			// nbrs
			for (int nbr : map.get(rp.vname).keySet()) {

				if (!visited[nbr]) {

					PrimsPair np = new PrimsPair(nbr, rp.vname, map.get(rp.vname).get(nbr));
					pq.add(np);
				}
			}

		}

	}

	private class DijkstraPair implements Comparable<DijkstraPair> {
		int vname;
		String path;
		int cost;

		public DijkstraPair(int vname, String path, int cost) {

			this.vname = vname;
			this.path = path;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return vname + " via " + path + " @ " + cost;
		}

		@Override
		public int compareTo(DijkstraPair o) {
			return this.cost - o.cost;
		}
	}

	public void dijkstra(int src) {

		boolean[] visited = new boolean[map.size() + 1];

		PriorityQueue<DijkstraPair> pq = new PriorityQueue<>();

		DijkstraPair sp = new DijkstraPair(src, src + "", 0);
		pq.add(sp);

		while (!pq.isEmpty()) {

			// remove
			DijkstraPair rp = pq.remove();

			// already visited , ignore
			if (visited[rp.vname])
				continue;

			// visited
			visited[rp.vname] = true;

			// printing
			System.out.println(rp);

			// nbrs
			for (int nbr : map.get(rp.vname).keySet()) {

				if (!visited[nbr]) {

					DijkstraPair np = new DijkstraPair(nbr, rp.path + nbr, rp.cost + map.get(rp.vname).get(nbr));
					pq.add(np);
				}
			}

		}

	}

	public void bellmanFord(int src) {

		int V = map.size();

		int[] dist = new int[V + 1];
		Arrays.fill(dist, 100000);
		dist[src] = 0;

		ArrayList<EdgePair> edges = getAllEdges();

		for (int relax = 1; relax <= V; relax++) {

			for (EdgePair edge : edges) {

				int oc = dist[edge.v2];
				int nc = dist[edge.v1] + edge.cost;

				if (oc > nc) {

					if (relax <= V - 1)
						dist[edge.v2] = nc;
					else {
						System.out.println("-ve wt cycle is present");
						return;
					}
				}

			}
		}

		for (int i = 1; i <= V; i++) {
			System.out.println(i + " -> " + dist[i]);
		}

	}

	public void floydWarshall() {

		int V = map.size();

		int[][] dist = new int[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {

				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = 100000;
			}
		}

		// add cost of edges in dist matrix
		for (int i = 1; i <= V; i++) {
			for (int nbr : map.get(i).keySet()) {
				dist[i][nbr] = map.get(i).get(nbr);
			}
		}

		for (int v = 1; v <= V; v++) {

			for (int r = 1; r <= V; r++) {

				for (int c = 1; c <= V; c++) {

					int oc = dist[r][c];
					int nc = dist[r][v] + dist[v][c];

					if (nc < oc) {
						dist[r][c] = nc;
					}

				}
			}

		}

		// printing
		for (int r = 1; r <= V; r++) {
			
			for (int c = 1; c <= V; c++) {		
				System.out.print(dist[r][c] + "\t");
			}
			
			System.out.println();
		}

	}

}
