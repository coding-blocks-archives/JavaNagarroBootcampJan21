package L71_Trie;

import java.rmi.Remote;
import java.util.HashMap;

public class Trie {

	private class Node {
		char ch;
		boolean eow;
		HashMap<Character, Node> map;

		public Node(char ch) {
			this.ch = ch;
			this.eow = false;
			this.map = new HashMap<Character, Node>();
		}
	}

	private Node root;

	public Trie() {
		root = new Node('*');
	}

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {

		if (word.length() == 0) {
			node.eow = true;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		boolean charPresent = node.map.containsKey(ch);

		if (charPresent) {
			addWord(node.map.get(ch), row);
		} else {
			Node nn = new Node(ch);
			node.map.put(ch, nn);
			addWord(nn, row);
		}

	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {

		if (word.length() == 0) {
			return node.eow;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		boolean charPresent = node.map.containsKey(ch);

		if (charPresent) {
			return searchWord(node.map.get(ch), row);
		} else {
			return false;
		}

	}

	public boolean prefixWord(String word) {
		return prefixWord(root, word);
	}

	private boolean prefixWord(Node node, String word) {

		if (word.length() == 0) {
			return true;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		boolean charPresent = node.map.containsKey(ch);

		if (charPresent) {
			return prefixWord(node.map.get(ch), row);
		} else {
			return false;
		}

	}

	public void removeWord(String word) {
		removeWord(root, word);
	}

	private void removeWord(Node node, String word) {

		if(word.length() == 0) {
			node.eow = false ;
			return ;
		}
		
		char ch = word.charAt(0);
		String row = word.substring(1);

		boolean charPresent = node.map.containsKey(ch);

		if (charPresent) {

			Node child = node.map.get(ch) ;
			removeWord(child, row);
			
			if(child.eow == false && child.map.size() == 0) {
				node.map.remove(ch) ;
			}
			
		} else {
			return ;			
		}

	}

	public void displayWords() {
		displayWords(root, "");
	}

	private void displayWords(Node node, String ans) {

		if (node.eow) {
			System.out.println(ans);
		}

		for (char key : node.map.keySet()) {
			displayWords(node.map.get(key), ans + key);
		}

	}

	public void displayTrie() {
		displayTrie(root);
	}

	private void displayTrie(Node node) {

		String ans = node.ch + " -> ";

		for (char key : node.map.keySet()) {
			ans += key + " ";
		}

		System.out.println(ans);

		for (char key : node.map.keySet()) {
			displayTrie(node.map.get(key));
		}

	}

}
