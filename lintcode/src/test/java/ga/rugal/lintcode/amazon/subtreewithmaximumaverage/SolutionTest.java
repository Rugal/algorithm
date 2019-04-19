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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rugal
 */
public class SolutionTest {

  private final Solution solution = new Solution();

  public TreeNode root = new TreeNode(1);

  @Before
  public void setUp() {
    this.root.left = new TreeNode(-5);
    this.root.left.left = new TreeNode(1);
    this.root.left.right = new TreeNode(2);

    this.root.right = new TreeNode(11);
    this.root.right.left = new TreeNode(4);
    this.root.right.right = new TreeNode(-2);
  }

  @Test
  public void testFindSubtree2() {
    Assert.assertEquals(11, this.solution.findSubtree2(this.root).val);
  }
}
