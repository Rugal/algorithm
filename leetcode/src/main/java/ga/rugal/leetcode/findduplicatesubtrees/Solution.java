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
package ga.rugal.leetcode.findduplicatesubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 *
 * @author rugal
 */
public class Solution {

  int t = 1;

  final Map<String, Integer> trees = new HashMap<>();

  final Map<Integer, Integer> count = new HashMap<>();

  final List<TreeNode> ans = new ArrayList<>();

  public List<TreeNode> findDuplicateSubtrees(final TreeNode root) {
    this.lookup(root);
    return this.ans;
  }

  public int lookup(final TreeNode node) {
    if (node == null) {
      return 0;
    }
    //because this is recursion, it goes down to the very bottom then back to top
    //so any serial that is created first is definitely unique
    final String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
    //then we generate a unique id for that
    //we better to use id because in recursion, we need to return uid back, instead of returning a big string
    final int uid = trees.computeIfAbsent(serial, x -> t++);
    //in this sense, integer id is not necessary actually, but it is just better
    count.put(uid, count.getOrDefault(uid, 0) + 1);
    if (count.get(uid) == 2) {
      ans.add(node);
    }
    return uid;
  }
}
