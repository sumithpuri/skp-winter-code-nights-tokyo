/*
Refer to the Java Code (Developed By Sumith Puri) for the solution of Autocomplete (Word Search) using Trie. It might be 
asked in one of your interviews for bigger companies like Yahoo, Symantec, Huawei, Oracle, Microsoft, Amazon, or Google! 
Also, you might want to sometimes natively implement it for any of your requirements like tools  or utilities... in your 
organization.
*/

// Autcomplete Implementation - Trie Implementation
// Embed in your Desktop, Mobile or Enterprise Apps
// Sumith Puri [I Bleed Java!]; GitHub: @sumithpuri
// Tested On 01-01-2023 - All OK

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author sumith.puri
 * 
 *         AutoComplete using Trie. Single Class Solution in Problem Solving
 *         Mode Consider to Use Separate Classes for OOP/SOLID for Inclusion
 *         in Your Enterprise Solution. Also - Consider Separating Logic and
 *         Indexing & Trie Data Structure Itself.. Consider Implementing and
 *         Testing [Regex/Wildcard] by Yourself.
 */
public class AutoCompleteWithTrie {

	private TrieC root = null;
	private static final String SEARCH_TERM_IN_TRIE = "tea";

	public static void main(String[] args) {

		// tea party, tea park, tea parking, ten park, tee park, tel number
		AutoCompleteWithTrie autoComplete = new AutoCompleteWithTrie();
		autoComplete.loadTrie("tea party");
		autoComplete.loadTrie("taa park");
		autoComplete.loadTrie("tal park");
		autoComplete.loadTrie("tea pair object f");
		autoComplete.loadTrie("tea party was long");
		autoComplete.loadTrie("tea party america");
		autoComplete.loadTrie("tea par japan");
		autoComplete.loadTrie("tea nol");

		List<String> ac = autoComplete.search(SEARCH_TERM_IN_TRIE);
		
		System.out.println("Autocomple Results Using Trie for Search Term - " + SEARCH_TERM_IN_TRIE);
		System.out.println();
		for (String s : ac)
			System.out.println(s);
	}

	public void loadTrie(String word) {

		// boolean isRoot = false;
		if (root == null) {
			TrieC trie = new TrieC(new Character(' '));
			root = trie;
		}

		TrieC start = root;
		char[] characters = word.toCharArray();

		for (char c : characters) {

			if (start.getNext().size() == 0) {
				start = start.setNext(c);
			} else {
				ListIterator<TrieC> it = start.getNext().listIterator();
				TrieC ch = null;
				while (it.hasNext()) {
					ch = it.next();
					if (ch.getNode() == c) {
						break;
					}
				}
				if (ch.getNode() == c) {
					start = ch;
				} else {
					start = start.setNext(c);
				}
			}
		}
	}

	public List<String> search(String prefix) {

		List<String> list = new ArrayList<String>();
		if (prefix == null || prefix.length() == 0)
			return list;
		TrieC start = root;
		char[] chars = prefix.toCharArray();
		boolean flag = true;

		for (char c : chars) {

			if (start.getNext().size() > 0) {

				for (TrieC ch : start.getNext()) {
					if (ch.getNode() == c) {
						start = ch;
						flag = true;
						break;
					}
				}
			} else {
				flag = false;
				break;
			}
		}

		if (flag) {
			//System.out.println(start.getNode() + ":" + prefix);
			List<String> matches = this.getAllWords(start, prefix);
			return matches;
		}

		return list;
	}

	private List<String> getAllWords(TrieC start, String prefix) {

		if (start == null || start.getNext().size() == 0) {

			List<String> list = new java.util.LinkedList<String>();
			list.add(prefix);
			return list;
		} else {

			List<String> list = new java.util.LinkedList<String>();
			for (TrieC ch : start.getNext()) {
				if (start != null) {
					start = ch;
				}
				list.addAll(getAllWords(start, prefix + ch.getNode() + ""));
			}
			return list;
		}
	}
}

class TrieC {

	Character node;
	List<TrieC> next;

	TrieC(Character c) {
		this.node = c;
		next = new java.util.LinkedList<TrieC>();
	}

	public TrieC setNext(Character c) {
		TrieC trie = null;
		trie = new TrieC(c);
		next.add(trie);
		return trie;
	}

	public TrieC getNextByCharacter(Character c) {
		return next.get(c);
	}

	public List<TrieC> getNext() {
		return next;
	}

	public Character getNode() {
		return node;
	}
}