package Labs_Tries;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

	private class Node {
		Character data;
		boolean isTerminal;
		HashMap<Character, Node> children;

		Node(Character data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap<>();
		}
	}

	private Node root;
	private int numWords;

	Trie() {
		this.root = new Node('\0', false);
		this.numWords = 0;
	}

	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node Parent, String word) {

		if (word.length() == 0) {
			if (!Parent.isTerminal) {
				Parent.isTerminal = true;
				this.numWords++;
			}

			return;
		}
		Character ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = Parent.children.get(ch);

		if (child == null) {
			child = new Node(ch, false);
			Parent.children.put(ch, child);
		}

		this.addWord(child, ros);

	}

	public boolean searchWord(String word) {

		return searchWord(this.root, word);
	}

	private boolean searchWord(Node Parent, String word) {

		if (word.length() == 0) {
			return Parent.isTerminal;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = Parent.children.get(ch);
		if (child == null) {
			return false;
		}

		return searchWord(child, ros);
	}

	public void removeWord(String word) {
		this.removeWord(this.root, word);
	}

	private void removeWord(Node parent, String word) {

		if (word.length() == 0) {
			if (parent.isTerminal == true) {
				parent.isTerminal = false;
				numWords--;
			}
			return;

		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		Node child = parent.children.get(ch);
		if (child == null) {
			return;
		} else {
			removeWord(child, row);
		}

		if (child.isTerminal == false && child.children.size() == 0) {
			parent.children.remove(ch);
		}

	}

	public void displayTrie() {
		System.out.println("---------------------------");
		displayTrie(this.root);
		System.out.println("---------------------------");
	}

	private void displayTrie(Node node) {

		ArrayList<Character> keys = new ArrayList<>(node.children.keySet());

		String ans = node.data + "-> ";
		for (Character key : keys) {
			ans += key + ", ";
		}

		ans += ".";
		System.out.println(ans);
		for (Character key : keys) {
			displayTrie(node.children.get(key));
		}

	}
}
