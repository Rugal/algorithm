package ga.rugal.leetcode.rotatearray;

/**
 * https://leetcode.com/problems/rotate-array/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    int count = 0;
    for (int start = 0; count < nums.length; start++) {
      //in case of circlre
      int current = start;
      int prev = nums[start];
      do {
        int next = (current + k) % nums.length;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (start != current);
    }
  }
}
