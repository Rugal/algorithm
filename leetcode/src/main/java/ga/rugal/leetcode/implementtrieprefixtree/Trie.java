package ga.rugal.leetcode.implementtrieprefixtree;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * @author rugal
 */
public class Trie {

  class TrieNode {

    TrieNode[] next = new TrieNode[26];

    String word;

    private TrieNode() {
    }

    public void insert(final String word) {
      TrieNode p = this;
      for (char c : word.toCharArray()) {
        final int i = c - 'a';
        if (p.next[i] == null) {
          p.next[i] = new TrieNode();
        }
        p = p.next[i];
      }
      p.word = word;
    }
  }

  private final TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public Trie() {
    this.root = new TrieNode();
  }

  /**
   * Inserts a word into the trie.
   *
   * @param word
   */
  public void insert(final String word) {
    this.root.insert(word);
  }

  /**
   * Returns if the word is in the trie.
   *
   * @param word
   *
   * @return
   */
  public boolean search(final String word) {
    TrieNode p = this.root;
    for (char c : word.toCharArray()) {
      final int i = c - 'a';
      if (null == p.next[i]) {
        return false;
      }
      p = p.next[i];
    }
    return p.word != null;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   *
   * @param prefix
   *
   * @return
   */
  public boolean startsWith(String prefix) {
    TrieNode p = this.root;
    for (char c : prefix.toCharArray()) {
      final int i = c - 'a';
      if (null == p.next[i]) {
        return false;
      }
      p = p.next[i];
    }
    return p != null;
  }
}
