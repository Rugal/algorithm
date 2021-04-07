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
        // add to right
        if (right == null) {
          right = new TreeNode(num, this);
        } else {
          right.add(num);
        }
      } else {
        // add to left
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
        // find the smallest to the right
        ret = right;
        while (ret.left != null) {
          ret = ret.left;
        }
      } else {
        // try to find the parent of current node
        ret = this;
        while (ret.parent.right == ret) {
          // if current node is the right tree of its parent
          // because its parent will be smaller than the current one
          ret = ret.parent;
        }
        // now the current node is the left node of its parent
        // so that the parent is larger than current one
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

  TreeNode root, current;

  /**
   * Adds a number into the data structure.
   *
   * @param num
   */
  public void addNum(final int num) {
    if (this.root == null) {
      this.current = this.root = new TreeNode(num, null);
      this.n = 1;
      return;
    }
    this.root.add(num);
    this.n++;
    if (n % 2 == 1) {
      // if odd, always set current at the very middle element
      if (this.current.val <= num) {
        this.current = this.current.next();
      }
    } else if (this.current.val > num) {
      // if even, always set current at the 1 left to the middle element
      // do not change if there it is already in this status
      this.current = this.current.prev();
    }
  }

  /**
   * Returns the median of current data stream.
   *
   * @return
   */
  public double findMedian() {

    return this.n % 2 == 0
           // average of the very middle 2 elements
           ? ((double) this.current.next().val + this.current.val) / 2
           // if odd, just pick the middle 
           : this.current.val;
  }
}
