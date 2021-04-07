package ga.rugal.amazon.wordsearchii;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 *
 * @author rugalbernstein
 */
public class Solution {

  private static final int[] X = new int[]{0, 1, 0, -1};

  private static final int[] Y = new int[]{1, 0, -1, 0};

  private final List<String> result = new ArrayList<>();

  private char[][] board;

  public List<String> findWords(final char[][] board, final String[] words) {
    this.board = board;
    final TrieNode root = new TrieNode(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        root.search(i, j);
      }
    }
    return result;
  }

  class TrieNode {

    TrieNode[] next = new TrieNode[26];

    String word;

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

    public void search(int i, int j) {
      TrieNode p = this;
      final char c = board[i][j];
      //if it is the origin or no word
      if (c == '#' || p.next[c - 'a'] == null) {
        return;
      }
      p = p.next[c - 'a'];
      if (p.word != null) {
        // reaches the leaf
        result.add(p.word);
        p.word = null;     // de-duplicate
      }

      // mark it as visited
      board[i][j] = '#';
      //try to find the next character
      for (int r = 0; r < X.length; ++r) {
        int newI = i + X[r];
        int newJ = j + Y[r];

        if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
          p.search(newI, newJ);
        }
      }

      board[i][j] = c;
    }
  }
}
