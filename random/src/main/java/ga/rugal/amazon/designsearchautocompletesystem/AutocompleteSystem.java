package ga.rugal.amazon.designsearchautocompletesystem;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.com/problems/design-search-autocomplete-system/
 * https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/642-design-search-autocomplete-system.html
 *
 * @author Rugal Bernstein
 */
public class AutocompleteSystem {

  class TrieNode {

    public boolean isLeaf;

    public List<String> candidate;

    HashMap<Character, TrieNode> children;

    public TrieNode() {
      this.isLeaf = false;
      this.children = new HashMap<>();
      this.candidate = new LinkedList<>();
    }
  }

  class Trie {

    private final TrieNode root;

    public Trie() {
      this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     *
     * @param word
     */
    public void insert(final String word) {
      TrieNode node = this.root;
      for (int i = 0; i < word.length(); i++) {
        final var children = node.children;
        final char c = word.charAt(i);

        TrieNode d = children.getOrDefault(c, new TrieNode());
        d.candidate.add(word);
        children.put(c, d);
        // annotate it as leaf if it's the very last character
        if (i == word.length() - 1) {
          children.get(c).isLeaf = true;
        }
        node = node.children.get(c);
      }
    }

    private TrieNode searchNode(final String pre) {
      var children = this.root.children;
      var node = this.root;
      for (int i = 0; i < pre.length(); i++) {
        if (!children.containsKey(pre.charAt(i))) {
          return null;
        }
        node = children.get(pre.charAt(i));
        children = node.children;
      }
      return node;
    }
  }

  final HashMap<String, Integer> count = new HashMap<>();

  final Trie trie = new Trie();

  String current = "";

  public AutocompleteSystem(final String[] sentences, final int[] times) {
    for (int i = 0; i < sentences.length; i++) {
      this.count.put(sentences[i], times[i]);
      this.trie.insert(sentences[i]);
    }
  }

  public List<String> input(char c) {
    List<String> res = new LinkedList<>();
    if (c == '#') {
      if (!count.containsKey(this.current)) {
        this.trie.insert(this.current);
        this.count.put(this.current, 1);
      } else {
        this.count.put(this.current, this.count.get(this.current) + 1);
      }
      this.current = "";
    } else {
      this.current += c;
      res = this.getSuggestions();
    }

    return res;
  }

  private List<String> getSuggestions() {
    List<String> res = new LinkedList<>();
    TrieNode node = trie.searchNode(this.current);
    if (node == null) {
      return res;
    }
    List<String> cands = node.candidate;

    Collections.sort(cands, (a, b) -> !Objects.equals(this.count.get(a), this.count.get(b))
                                      ? this.count.get(b) - this.count.get(a)
                                      : a.compareTo(b));
    int added = 0;
    for (String s : cands) {
      res.add(s);
      added++;
      if (added > 2) {
        break;
      }
    }
    return res;
  }
}
