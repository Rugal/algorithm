package ga.rugal.leetcode.wordladderii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private final Map<String, List<String>> map = new HashMap<>();

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
    this.map.clear();
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

  public List<List<String>> findLadders(final String beginWord,
                                        final String endWord,
                                        final List<String> wordList) {
    final List<List<String>> result = new ArrayList<>();

    if (beginWord == null || endWord == null || wordList == null) {
      return result;
    }
    this.map.clear();
    this.build(wordList);

    final Set<String> unvisited = new HashSet<>(wordList);
    final Set<String> currentVisited = new HashSet<>();
    final Queue<WordNode> bfsQueue = new LinkedList<>();

    bfsQueue.offer(new WordNode(beginWord, new ArrayList<>(), 1));
    currentVisited.add(beginWord);

    boolean foundEnd = false;

    while (!bfsQueue.isEmpty() && !foundEnd) {
      //Get rid of visited word
      unvisited.removeAll(currentVisited);
      currentVisited.clear();
      //Scan only for one level
      //To control scope of BFS
      //because only one level at a time, the result from same level must all be the best path
      final int size = bfsQueue.size();

      for (int w = 0; w < size; w++) {
        final WordNode top = bfsQueue.poll();

        for (int i = 0; i < top.getLastWord().length(); ++i) {
          for (final String s : this.map.getOrDefault(this.getWord(top.getLastWord(), i),
                                                      new ArrayList<>())) {
            if (!unvisited.contains(s)) {
              continue;
            }
            final WordNode newNode = new WordNode(s, top.path, top.steps + 1);
            if (s.equals(endWord)) {
              //once it ends here, we need to save all possible path
              result.add(newNode.path);
              foundEnd = true;
            }
            bfsQueue.offer(newNode);
            currentVisited.add(s);
          }
        }
      }
    }

    return result;
  }

  class WordNode {

    List<String> path;

    int steps;

    WordNode(String word, List<String> path, int steps) {
      this.path = new ArrayList<>(path);
      this.path.add(word);
      this.steps = steps;
    }

    String getLastWord() {
      return this.path.get(this.path.size() - 1);
    }
  }
}
