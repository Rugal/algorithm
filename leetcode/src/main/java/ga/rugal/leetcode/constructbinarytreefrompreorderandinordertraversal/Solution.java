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
package ga.rugal.leetcode.constructbinarytreefrompreorderandinordertraversal;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 * @author rugal
 */
public class Solution {

  private int[] preorder;

  private int[] inorder;

  // Class Pointer for Preorder
  private int p;

  public TreeNode buildTree(final int[] preorder, final int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;

    if (preorder.length == 0) {
      return null;
    }

    // Find Index
    p = 0;
    int i = 0;

    for (; preorder[p] != inorder[i]; ++i);

    // Create Root & Children
    final TreeNode root = new TreeNode(preorder[p++]);
    if (i > 0) {
      root.left = leftChild(0, i - 1);
    }
    if (i < preorder.length - 1) {
      root.right = rightChild(i + 1, inorder.length - 1);
    }

    // Return Root
    return root;
  }

  private TreeNode leftChild(final int l, final int r) {

    // Find Index
    int i = r;
    //from right to left
    while (i >= l && preorder[p] != inorder[i]) {
      i--;
    }
    if (i < l) {
      return null;
    }

    // Create Node & Children
    final TreeNode current = new TreeNode(preorder[p++]);
    if (i > l) {
      current.left = leftChild(l, i - 1);
    }
    if (i < r) {
      current.right = rightChild(i + 1, r);
    }

    // Return Node
    return current;
  }

  private TreeNode rightChild(final int l, final int r) {

    // Find Index
    int i = l;
    //from left to right
    while (i <= r && preorder[p] != inorder[i]) {
      i++;
    }
    if (i > r) {
      return null;
    }

    // Create Node & Children
    final TreeNode current = new TreeNode(preorder[p++]);
    if (i > l) {
      current.left = leftChild(l, i - 1);
    }
    if (i < r) {
      current.right = rightChild(i + 1, r);
    }

    // Return Node
    return current;
  }
}
