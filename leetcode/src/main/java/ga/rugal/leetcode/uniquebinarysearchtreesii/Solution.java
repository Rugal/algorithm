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
package ga.rugal.leetcode.uniquebinarysearchtreesii;

import java.util.ArrayList;
import java.util.List;

import ga.rugal.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii
 *
 * @author rugalbernstein
 */
public class Solution {

  public List<TreeNode> generateTrees(final int n) {
    return n > 0
           ? this.get(1, n)
           : new ArrayList<>();
  }

  private List<TreeNode> get(final int a, final int b) {
    List<TreeNode> ans = new ArrayList<>();
    if (a > b) {
      ans.add(null);
      return ans;
    }
    for (int i = a; i <= b; ++i) {
      for (TreeNode l : this.get(a, i - 1)) {
        for (TreeNode r : this.get(i + 1, b)) {
          final TreeNode treeNode = new TreeNode(i);
          ans.add(treeNode);
          treeNode.left = l;
          treeNode.right = r;
        }
      }
    }
    return ans;
  }
}
