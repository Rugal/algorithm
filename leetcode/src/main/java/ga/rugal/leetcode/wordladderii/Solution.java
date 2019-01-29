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
    final List<List<String>> res = new ArrayList<>();

    if (beginWord == null || endWord == null || wordList == null) {
      return res;
    }
    this.map.clear();
    this.build(wordList);

    final HashSet<String> wordSet = new HashSet<>(wordList);

    final Queue<WordNode> wordQueue = new LinkedList<>();
    final Set<String> curLevel = new HashSet<>();

    wordQueue.offer(new WordNode(beginWord, new ArrayList<>(), 1));
    curLevel.add(beginWord);

    boolean foundEnd = false;

    while (!wordQueue.isEmpty() && !foundEnd) {
      //Get rid of visited word
      wordSet.removeAll(curLevel);
      curLevel.clear();

      //Scan only for one level
      final int size = wordQueue.size();

      for (int w = 0; w < size; w++) {
        final WordNode top = wordQueue.poll();

        for (int i = 0; i < top.getLastWord().length(); ++i) {
          for (String s : this.map.getOrDefault(this.getWord(top.getLastWord(), i),
                                                new ArrayList<>())) {
            if (wordSet.contains(s)) {
              final WordNode newNode = new WordNode(s, top.path, top.steps + 1);
              if (s.equals(endWord)) {
                //Since we are using BFS, the first time this block gets excuted, we found the shortest steps.
                res.add(newNode.path);
                foundEnd = true;
              }
              wordQueue.offer(newNode);
              curLevel.add(s);
            }
          }
        }
      }
    }

    return res;
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
