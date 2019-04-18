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
package ga.rugal.lintcode.amazon.maximumsubtree;

import ga.rugal.lintcode.TreeNode;

/**
 * https://www.lintcode.com/problem/maximum-subtree/description
 *
 * @author rugal
 */
public class Solution {

  private TreeNode target = null;

  private int max = Integer.MIN_VALUE;

  /**
   * @param root: the root of binary tree
   *
   * @return the maximum weight node
   */
  public TreeNode findSubtree(final TreeNode root) {
    // write your code here
    this.dfs(root);
    return this.target;
  }

  private int dfs(final TreeNode root) {
    if (null == root) {
      return 0;
    }
    int left = this.dfs(root.left);
    int right = this.dfs(root.right);
    int sum = left + right + root.val;
    if (sum > this.max) {
      this.max = sum;
      this.target = root;
    }
    return sum;
  }
}
