package ga.rugal.leetcode.wordladder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder
 *
 * @author Rugal Bernstein
 */
public class Solution {

  static class Pair {

    public String word;

    public int count;

    public Pair(String word, int count) {
      this.word = word;
      this.count = count;
    }
  }

  /**
   * To get word like X_Y
   *
   * @param word
   * @param i
   *
   * @return
   */
  private String getWord(final String word, final int i) {
    return String.format("%s_%s", word.substring(0, i), word.substring(i + 1));
  }

  /**
   * Create word map of words that have the same pattern, for instance all word matches AB_ will be
   * grouped together and so forth.
   *
   * @param wordList
   *
   * @return
   */
  private Map<String, List<String>> build(final List<String> wordList) {
    final Map<String, List<String>> map = new HashMap<>();
    for (String word : wordList) {
      for (int i = 0; i < word.length(); ++i) {
        final String key = this.getWord(word, i);
        final List<String> get = map.getOrDefault(key, new ArrayList<>());
        get.add(word);
        map.put(key, get);
      }
    }
    return map;
  }

  /**
   * start BFS with the given word map.
   *
   * @param beginWord
   * @param endWord
   * @param map
   *
   * @return
   */
  private int bfs(final String beginWord,
                  final String endWord,
                  final Map<String, List<String>> map) {
    final Deque<Pair> pairs = new ArrayDeque<>();
    final Set<String> visited = new HashSet<>();
    pairs.add(new Pair(beginWord, 1));
    while (!pairs.isEmpty()) {
      final Pair pair = pairs.poll();
      if (visited.contains(pair.word)) {
        //we have seen this word
        continue;
      }
      visited.add(pair.word);
      if (pair.word.equals(endWord)) {
        //Since we are using BFS, the earlier the match is, the smaller the count is
        return pair.count;
      }
      for (int i = 0; i < pair.word.length(); ++i) {
        final String key = this.getWord(pair.word, i);
        map.getOrDefault(key, new ArrayList<>()).stream()
          //from any unvisited neighbour words
          .filter(neigh -> !visited.contains(neigh))
          //since they are neighbour of us, +1 for one more step
          .forEach(neigh -> pairs.add(new Pair(neigh, pair.count + 1)));
      }
    }
    return 0;
  }

  public int ladderLength(final String beginWord,
                          final String endWord,
                          final List<String> wordList) {
    return this.bfs(beginWord, endWord, this.build(wordList));
  }
}
