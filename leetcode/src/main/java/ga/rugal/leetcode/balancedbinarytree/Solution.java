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
package ga.rugal.leetcode.balancedbinarytree;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * @author rugalbernstein
 */
public class Solution {

  /**
   * For each subtree.
   *
   * @param root
   *
   * @return
   */
  public boolean isBalanced(final TreeNode root) {
    if (root == null) {
      return true;
    }
    //not just the the root, but for each subtree
    return Math.abs(height(root.left) - height(root.right)) < 2
           ? isBalanced(root.left) && isBalanced(root.right)
           : false;
  }

  private int height(TreeNode node) {
    return node == null
           ? 0
           : Math.max(height(node.left), height(node.right)) + 1;
  }
}
