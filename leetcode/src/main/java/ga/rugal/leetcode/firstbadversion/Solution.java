package ga.rugal.leetcode.firstbadversion;

/**
 * https://leetcode.com/problems/first-bad-version/
 *
 *
 * @author Rugal Bernstein
 */
public class Solution extends VersionControl {

  public int firstBadVersion(int n) {
    int start = 0, end = n;
    while (end - start > 1) {
      int mid = start + (end - start) / 2;
      /**
       * mid = (start+end)) / 2; *
       */
      if (isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid;
      }
    }
    return end;
  }
}

class VersionControl {

  boolean isBadVersion(int mid) {
    return true;
  }
}
