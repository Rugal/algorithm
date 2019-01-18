package ga.rugal.amazon.phone1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * Q: You have a collection of 'baby blocks' (cubes with single upper-case letters of the alphabet
   * on each side). Each block could have up to six different letters on it (or even more if we're
   * in a universe with more than 3 dimensions), but for the sake of simplicity, we'll assume for
   * now that each block only has two distinct letters.
   *
   * The problem is to write a function that takes a collection of blocks and a target word and
   * returns true or false depending on whether or not you can spell the target word with the
   * collection of blocks.
   *
   * Example: (B,A),(A,B),(B,Y),(T,H), (A,B): "BABY" => yes<BR>
   * (B,A),(A,B),(L,E),(A,B): "ABLE" => no (since L and E are on the same block). "BAD"
   */
  /**
   *
   * @param input, each coin just use once B, A A, B X, Y A, B
   *
   * @param target BABY
   */
  public boolean test(final List<Character[]> input, String target) {
    return this.backtrack(input, target);
  }

  private boolean backtrack(final List<Character[]> input, String target) {
    if (target.isEmpty()) {
      return true;
    }
    Stack<Character[]> stack = new Stack<>();
    for (int i = 0; i < input.size(); ++i) {
      final Character[] array = input.get(i);
      if (target.charAt(0) == array[0] || target.charAt(0) == array[1]) {
        stack.push(array);
        List<Character[]> temp = new ArrayList<>(input);
        temp.remove(i);
        if (!this.backtrack(temp, target.substring(1))) {
          temp.add(stack.pop());
          return this.backtrack(temp, target);
        }
      }
    }
    return target.isEmpty();
  }

// [T, H] -> A
}
