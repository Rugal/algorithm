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
package ga.rugal.leetcode.minimumdepthofbinarytree;

import java.util.LinkedList;
import java.util.Queue;

import ga.rugal.leetcode.TreeNode;

/**
 *
 * @author rugalbernstein
 */
public class Solution {

  private static class Pair {

    final TreeNode node;

    final int depth;

    public Pair(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  public int minDepth(final TreeNode root) {
    final Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 1));
    while (!queue.isEmpty()) {
      final Pair head = queue.poll();
      if (null == head.node) {
        continue;
      }
      if (null == head.node.left && null == head.node.right) {
        return head.depth;
      }
      if (null != head.node.left) {
        queue.add(new Pair(head.node.left, head.depth + 1));
      }
      if (null != head.node.right) {
        queue.add(new Pair(head.node.right, head.depth + 1));
      }
    }

    return 0;
  }
}
