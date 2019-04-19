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
package ga.rugal.lintcode.amazon.subtreewithmaximumaverage;

import ga.rugal.lintcode.TreeNode;

/**
 * https://www.lintcode.com/problem/subtree-with-maximum-average/description
 *
 * @author rugal
 */
public class Solution {

  private TreeNode target = null;

  private Pair max = null;

  /**
   * @param root: the root of binary tree
   *
   * @return the root of the maximum average of subtree
   */
  public TreeNode findSubtree2(final TreeNode root) {
    if (null == root) {
      return root;
    }
    this.dfs(root);
    return this.target;
  }

  private Pair dfs(final TreeNode root) {
    if (null == root) {
      return new Pair(0, 0);
    }
    final Pair left = this.dfs(root.left);
    final Pair right = this.dfs(root.right);

    final Pair current = new Pair(root.val + left.sum + right.sum, left.count + right.count + 1);
    if (this.max == null || this.max.compareTo(current) < 0) {
      this.max = current;
      this.target = root;
    }

    return current;
  }

  private class Pair implements Comparable<Pair> {

    private final int sum;

    private final int count;

    public Pair(int sum, int count) {
      this.sum = sum;
      this.count = count;
    }

    @Override
    public int compareTo(final Pair o) {
      return (this.sum * 1.0 / this.count - o.sum * 1.0 / o.count) <= 0
             ? -1
             : 1;
    }
  }
}
