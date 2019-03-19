/*
 * Copyright 2019 rugalbernstein.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ga.rugal.leetcode.wordsearchii;

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

  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, res);
      }
    }
    return res;
  }

  private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    final char c = board[i][j];
    //if it is the origin or no word
    if (c == '#' || p.next[c - 'a'] == null) {
      return;
    }
    p = p.next[c - 'a'];
    if (p.word != null) {   // found one
      res.add(p.word);
      p.word = null;     // de-duplicate
    }

    board[i][j] = '#';
    //try to find the next character
    for (int r = 0; r < X.length; ++r) {
      int newI = i + X[r];
      int newJ = j + Y[r];

      if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
        dfs(board, newI, newJ, p, res);
      }
    }

    board[i][j] = c;
  }

  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
      TrieNode p = root;
      for (char c : w.toCharArray()) {
        int i = c - 'a';
        if (p.next[i] == null) {
          p.next[i] = new TrieNode();
        }
        p = p.next[i];
      }
      p.word = w;
    }
    return root;
  }

  class TrieNode {

    TrieNode[] next = new TrieNode[26];

    String word;
  }
}
