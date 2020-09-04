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
package ga.rugal.amazon.twosumivinputisabst;

import java.util.HashSet;
import java.util.Set;

import ga.rugal.amazon.TreeNode;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * @author rugalbernstein
 */
public class Solution {

  private final Set<Integer> set = new HashSet<>();

  private int k;

  public boolean findTarget(final TreeNode root, final int k) {
    this.k = k;
    return this.inorder(root);
  }

  private boolean inorder(final TreeNode root) {
    if (null == root) {
      return false;
    }
    if (this.inorder(root.left)
        || this.set.contains(this.k - root.val)) {
      return true;
    }
    this.set.add(root.val);
    return this.inorder(root.right);
  }
}
