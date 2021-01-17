package ga.rugal.amazon.findmedianfromdatastream;

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
}
