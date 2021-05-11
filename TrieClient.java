package Labs_Tries;

public class TrieClient {

	public static void main(String[] args) {
		

		Trie t = new Trie();
		t.addWord("zebra");
		t.addWord("zen");
		System.out.println(t.searchWord("ze"));
		t.addWord("duck");
		t.addWord("dove");
		System.out.println(t.searchWord("dove"));
		t.removeWord("dove");
		System.out.println(t.searchWord("dove"));
		t.displayTrie();
		t.addWord("dove");
		t.addWord("dull");
		t.displayTrie();

	}

}
