package ga.rugal.leetcode.binarytreepostordertraversal

class Solution {
  fun postorderTraversal(root: TreeNode?): List<Int> {
    val l: MutableList<Int> = mutableListOf<Int>()
    root?.also {
      this.postOrder(it, l)
    }
    return l
  }

  private fun postOrder(root: TreeNode, result: MutableList<Int>) {
    root.left?.also { this.postOrder(it, result) }
    root.right?.also { this.postOrder(it, result) }
    result.add(root.`val`)
  }
}
