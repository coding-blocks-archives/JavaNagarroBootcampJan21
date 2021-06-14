package L63_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
		map.get(v2).put(v1, cost);

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
					
					char oc = visited.get(rp.node) ;
					char nc = rp.color ;
					
					if(oc != nc) 
						return false ;
					
					continue ;
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

		return true ;

	}

}
