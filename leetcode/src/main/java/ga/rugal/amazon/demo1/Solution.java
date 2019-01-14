package ga.rugal.amazon.demo1;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

public class Solution {

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public List<Integer> cellCompete(final int[] states, final int days) {
    if (0 == days) {
      return Arrays.stream(states).boxed().collect(Collectors.toList());

    }
    // WRITE YOUR CODE HERE
    //Do not touch input parameter
    final int[] previous = new int[states.length];
    final int[] result = new int[states.length];
    for (int i = 0; i < states.length; ++i) {
      result[i] = states[i];
      previous[i] = states[i];
    }
    for (int i = 0; i < days; ++i) {
      for (int index = 0; index < result.length; ++index) {
        result[index] = this.nextValue(index == 0 ? 0 : previous[index - 1],
                                       index == (result.length - 1) ? 0 : previous[index + 1]);
      }
      for (int j = 0; j < result.length; ++j) {
        previous[j] = result[j];
      }
    }
    return Arrays.stream(result).boxed().collect(Collectors.toList());
  }
  // METHOD SIGNATURE ENDS

  /**
   * Logic to get value for next day by using adjacent cells.
   */
  private int nextValue(final int previous, final int next) {
    return previous == next ? 0 : 1;
  }
}
