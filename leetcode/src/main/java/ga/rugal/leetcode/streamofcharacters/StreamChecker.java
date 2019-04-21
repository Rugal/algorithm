/*
 * Copyright 2019 rugal.
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
package ga.rugal.leetcode.streamofcharacters;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * https://leetcode.com/contest/weekly-contest-133/problems/stream-of-characters/
 *
 * @author rugal
 */
public class StreamChecker {

  static class TrieNode {

    TrieNode[] children = new TrieNode[26];

    boolean isWord = false;
  }

  private final TrieNode root;

  private int capacity;

  //cache the some character, the capacity is the maximum length of words in dictionary
  private final Deque<Character> chars;

  /**
   * Add word in reverse order because we could end up with multiple choice
   *
   * @param word
   */
  private void addWordReverse(String word) {
    TrieNode node = root;
    for (int i = word.length() - 1; i >= 0; i--) {
      int j = word.charAt(i) - 'a';
      if (node.children[j] == null) {
        node.children[j] = new TrieNode();
      }
      node = node.children[j];
    }
    node.isWord = true;
  }

  private boolean lookupWord() {
    TrieNode node = root;
    //always search from back
    Iterator<Character> it = chars.descendingIterator();
    while (it.hasNext()) {
      char c = it.next();
      int j = c - 'a';
      if (node.children[j] == null) {
        return false;
      }
      node = node.children[j];
      if (node.isWord) {
        return true;
      }
    }
    return false;
  }

  public StreamChecker(String[] words) {
    root = new TrieNode();
    capacity = 0;
    for (String word : words) {
      capacity = Math.max(capacity, word.length());
      addWordReverse(word);
    }
    chars = new ArrayDeque<>(capacity);
  }

  public boolean query(char letter) {
    //keep only some many characters
    if (chars.size() == capacity) {
      chars.pollFirst();
    }
    chars.offerLast(letter);
    return lookupWord();
  }
}
