package ga.rugal.trie;

/**
 *
 * @author rugal
 */
public class Trie {

}

class TrieNode {

  private final TrieNode[] next = new TrieNode[26];

  private String word;

  private TrieNode() {
  }

  public TrieNode(final String[] words) {
    for (String w : words) {
      TrieNode p = this;
      for (char c : w.toCharArray()) {
        int i = c - 'a';
        if (p.next[i] == null) {
          p.next[i] = new TrieNode();
        }
        p = p.next[i];
      }
      p.word = w;
    }
  }
}
