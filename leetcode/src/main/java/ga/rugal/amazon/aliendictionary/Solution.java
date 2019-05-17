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
package ga.rugal.amazon.aliendictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/alien-dictionary
 *
 * @author rugal
 */
public class Solution {

  class Node {

    char ch;

    List<Character> neighbors;

    Node(char ch) {
      this.ch = ch;
      this.neighbors = new ArrayList<>();
    }

  }

  Map<Character, Node> graph = new HashMap<>();

  Map<Character, Integer> inDegree = new HashMap<>();

  public String alienOrder(String[] words) {

    if (words.length == 0) {
      return "";
    }

    // Creating the graph
    for (int i = 1; i < words.length; i++) {

      char[] word1 = words[i - 1].toCharArray();
      char[] word2 = words[i].toCharArray();
      int j = 0;

      while (j < word1.length && j < word2.length && word1[j] == word2[j]) {
        j++;
      }

      if (j >= word1.length || j >= word2.length) {
        continue;
      }
      //add these 2 characters into map
      if (!graph.containsKey(word1[j])) {
        graph.put(word1[j], new Node(word1[j]));
        inDegree.put(word1[j], 0);
      }
      if (!graph.containsKey(word2[j])) {
        graph.put(word2[j], new Node(word2[j]));
        inDegree.put(word2[j], 0);
      }
      //word1->word2
      if (!graph.get(word1[j]).neighbors.contains(word2[j])) {
        //add neighbour
        graph.get(word1[j]).neighbors.add(word2[j]);
        //increase the in degree
        inDegree.put(word2[j], inDegree.get(word2[j]) + 1);
      }
    }

    // Adding the characters in the graph which were not resolved in the first iteration
    // These characters have 0 inDegree so their order doesnt really matter as multiple answers are possible
    for (String word : words) {
      for (char c : word.toCharArray()) {
        if (!graph.containsKey(c)) {
          graph.put(c, new Node(c));
          inDegree.put(c, 0);
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    //Topological Sort
    while (!inDegree.isEmpty()) {
      char current = ' ';
      for (char c : inDegree.keySet()) {
        if (inDegree.get(c) == 0) {
          current = c;
          break;
        }
      }
      if (current == ' ') {
        break;
      }
      inDegree.remove(current);
      for (char n : graph.get(current).neighbors) {
        if (inDegree.containsKey(n)) {
          inDegree.put(n, inDegree.get(n) - 1);
        }
      }
      sb.append(current);
    }

    // If all the nodes are not covered in traversal, no particular order is found
    if (sb.length() < graph.size()) {
      return "";
    }

    return sb.toString();

  }
}
