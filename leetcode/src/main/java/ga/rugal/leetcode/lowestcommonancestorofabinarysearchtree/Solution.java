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
package ga.rugal.leetcode.lowestcommonancestorofabinarysearchtree;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author rugal
 */
public class Solution {

  public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
    if ((p.val < root.val) && (q.val < root.val)) {
      return lowestCommonAncestor(root.left, p, q);
    } else if ((p.val > root.val) && (q.val > root.val)) {
      return lowestCommonAncestor(root.right, p, q);
    } else {
      return root;
    }
  }
}
