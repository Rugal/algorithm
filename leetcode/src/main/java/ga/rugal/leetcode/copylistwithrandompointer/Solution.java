package ga.rugal.leetcode.copylistwithrandompointer;

import java.util.HashMap;

import ga.rugal.leetcode.RandomListNode;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/solution/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  // Visited dictionary to hold old node reference as "key" and new node reference as the "value"
  final HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();

  public RandomListNode getClonedNode(RandomListNode node) {
    RandomListNode temp = null;
    // If the node exists then
    if (node != null) {
      // Check if the node is in the visited dictionary
      if (!this.visited.containsKey(node)) {
        // Otherwise create a new node, add to the dictionary and return it
        this.visited.put(node, new RandomListNode(node.label));
      }
      // If its in the visited dictionary then return the new node reference from the dictionary
      temp = this.visited.get(node);
    }
    return temp;
  }

  public RandomListNode copyRandomList(RandomListNode head) {

    if (head == null) {
      return null;
    }
    this.visited.clear();

    RandomListNode oldNode = head;

    // Creating the new head node.
    RandomListNode newNode = new RandomListNode(oldNode.label);
    this.visited.put(oldNode, newNode);

    // Iterate on the linked list until all nodes are cloned.
    while (oldNode != null) {
      // Get the clones of the nodes referenced by random and next pointers.
      newNode.random = this.getClonedNode(oldNode.random);
      newNode.next = this.getClonedNode(oldNode.next);

      // Move one step ahead in the linked list.
      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return this.visited.get(head);
  }
}
