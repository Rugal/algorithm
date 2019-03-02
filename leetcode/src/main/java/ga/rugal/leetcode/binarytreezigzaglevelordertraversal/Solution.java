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
package ga.rugal.leetcode.binarytreezigzaglevelordertraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 *
 * @author rugalbernstein
 */
public class Solution {

  private final List<List<Integer>> lists = new ArrayList<>();

  private int maxLevel = -1;

  public List<List<Integer>> levelOrder(TreeNode root) {
    this.levelTraverse(root, 0);
    for (int i = 0; i < this.lists.size(); ++i) {
      if (i % 2 == 1) {
        Collections.reverse(this.lists.get(i));
      }
    }
    return this.lists;
  }

  private void levelTraverse(final TreeNode root, final int level) {
    if (root == null) {
      return;
    }

    if (this.maxLevel < level) {
      //only the very first visit to the new level will be added
      this.maxLevel = level;
      this.lists.add(new ArrayList<>());
    }

    this.lists.get(level).add(root.val);
    this.levelTraverse(root.left, level + 1);
    this.levelTraverse(root.right, level + 1);
  }
}
