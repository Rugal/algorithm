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
package ga.rugal.leetcode.findmedianfromdatastream;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * https://leetcode.com/problems/find-median-from-data-stream/discuss/74119/18ms-beats-100-Java-Solution-with-BST
 *
 * @author rugal
 */
public class MedianFinder {

  class TreeNode {

    int val;

    TreeNode parent, left, right;

    TreeNode(int val, TreeNode p) {
      this.val = val;
      this.parent = p;
      left = null;
      right = null;
    }

    void add(int num) {
      if (num >= val) {
        if (right == null) {
          right = new TreeNode(num, this);
        } else {
          right.add(num);
        }
      } else {
        if (left == null) {
          left = new TreeNode(num, this);
        } else {
          left.add(num);
        }
      }
    }

    TreeNode next() {
      TreeNode ret;
      if (right != null) {
        ret = right;
        while (ret.left != null) {
          ret = ret.left;
        }
      } else {
        ret = this;
        while (ret.parent.right == ret) {
          ret = ret.parent;
        }
        ret = ret.parent;
      }
      return ret;
    }

    TreeNode prev() {
      TreeNode ret;
      if (left != null) {
        ret = left;
        while (ret.right != null) {
          ret = ret.right;
        }
      } else {
        ret = this;
        while (ret.parent.left == ret) {
          ret = ret.parent;
        }
        ret = ret.parent;
      }
      return ret;
    }
  }

  int n;

  TreeNode root, curr;
  // Adds a number into the data structure.

  public void addNum(final int num) {
    if (root == null) {
      curr = root = new TreeNode(num, null);
      n = 1;
      return;
    }
    root.add(num);
    n++;
    if (n % 2 == 1) {
      if (curr.val <= num) {
        curr = curr.next();
      }
    } else if (curr.val > num) {
      curr = curr.prev();
    }
  }

  // Returns the median of current data stream
  public double findMedian() {

    return n % 2 == 0
           ? ((double) curr.next().val + curr.val) / 2
           : curr.val;
  }

  // max heap
  private final PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> b - a);

  // min heap
  private final PriorityQueue<Integer> hi = new PriorityQueue<>((a, b) -> a - b);

  public void addNum2(int num) {
    // Add to max heap
    lo.offer(num);
    // balancing step
    hi.offer(lo.poll());

    // maintain size property
    if (lo.size() < hi.size()) {
      lo.offer(hi.poll());
    }
  }

  // Returns the median of current data stream
  public double findMedian2() {
    return lo.size() > hi.size() ? (double) lo.peek() : (lo.peek() + hi.peek()) * 0.5;
  }
}
