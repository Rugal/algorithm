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
package ga.rugal.leetcode.pathsumii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * @author rugal
 */
public class Solution {

  /**
   * root-to-leaf paths
   *
   * @param root
   * @param sum
   *
   * @return
   */
  public List<List<Integer>> pathSum(final TreeNode root, final int sum) {
    final List<List<Integer>> result = new ArrayList<>();
    if (null == root) {
      return result;
    }

    final Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(root));
    while (!queue.isEmpty()) {
      final Pair poll = queue.poll();
      if (poll.isChild() && sum == poll.sum) {
        result.add(poll.path);
        continue;
      }
      if (null != poll.node.left) {
        queue.offer(new Pair(poll, poll.node.left));
      }
      if (null != poll.node.right) {
        queue.offer(new Pair(poll, poll.node.right));
      }
    }

    return result;
  }

  class Pair {

    TreeNode node;

    List<Integer> path;

    int sum;

    Pair(final TreeNode node) {
      this.node = node;
      this.path = new ArrayList<>();
      this.path.add(node.val);
      this.sum = node.val;
    }

    Pair(final Pair o, final TreeNode node) {
      this.node = node;
      this.path = new ArrayList<>(o.path);
      this.path.add(node.val);
      this.sum = o.sum + node.val;
    }

    boolean isChild() {
      return this.node.left == null && this.node.right == null;
    }
  }
}
