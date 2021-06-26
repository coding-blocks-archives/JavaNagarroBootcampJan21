package L71_Trie;

public class Client {

	public static void main(String[] args) {

//		String src = "aabcdaae";
//		String pat = "aaf";
//
//		System.out.println(search(src, pat));
		
		Trie trie = new Trie() ;
		
		trie.addWord("ant");
		trie.addWord("arc");
		trie.addWord("and");
		trie.addWord("see");
		trie.addWord("sea");
		trie.addWord("seen");
		trie.addWord("an");
		
		trie.displayWords();
		trie.displayTrie();
		System.out.println(trie.searchWord("an"));
		System.out.println(trie.prefixWord("apt"));
		
		trie.removeWord("see");
		trie.removeWord("seen");
		trie.displayTrie();
		trie.displayWords();

	}

	public static int search(String src, String pat) {

		for (int i = 0; i <= src.length() - pat.length(); i++) {

			int j = 0;
			while (j < pat.length()) {
				if (src.charAt(i + j) != pat.charAt(j))
					break;

				j++;
			}

			if (j == pat.length())
				return i;

		}

		return -1;

	}

}
