package ga.rugal.leetcode.binarytreepreordertraversal

class Solution {
  fun preorderTraversal(root: TreeNode?): List<Int> {
    val l: MutableList<Int> = mutableListOf<Int>()
    root?.also {
      this.preorder(it, l)
    }
    return l
  }

  private fun preorder(root: TreeNode, result: MutableList<Int>) {
    result.add(root.`val`)
    root.left?.also { this.preorder(it, result) }
    root.right?.also { this.preorder(it, result) }
  }
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
