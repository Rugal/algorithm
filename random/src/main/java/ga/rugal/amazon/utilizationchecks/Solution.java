package ga.rugal.amazon.utilizationchecks;

/**
 * https://aonecode.com/amazon-online-assessment-utilization-checks
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int finalInstances(int instances, final int[] averageUtil) {
    for (int i = 0; i < averageUtil.length; ++i) {
      final int value = averageUtil[i];
      if (25 <= value && value <= 60) {
        continue;
      }
      if (25 > value) {
        if (1 == instances) {
          continue;
        }
        instances = Math.max((int) Math.ceil(1.0 * instances / 2), 1);
      } else {
        if (200000000 < instances * 2) {
          continue;
        }
        instances = Math.min(instances * 2, 200000000);
      }
      i += 10;
    }
    return instances;
  }
}
