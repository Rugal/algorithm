package ga.rugal.wish.rearrangestringkdistanceapart;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.lintcode.com/problem/907/description
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   *
   * 一个哈希表来建立字符和其出现次数之间的映射，然后需要一个堆来保存这每一堆映射，按照出现次数来排序。
   * 然后如果堆不为空我们就开始循环，我们找出k和str长度之间的较小值，然后从0遍历到这个较小值，
   * 对于每个遍历到的值，如果此时堆为空了，说明此位置没法填入字符了，返回空字符串，
   * 否则我们从堆顶取出一对映射，然后把字母加入结果res中，此时映射的个数减1，
   * 如果减1后的个数仍大于0，则我们将此映射加入临时集合v中，同时str的个数len减1，
   * 遍历完一次，我们把临时集合中的映射对由加入堆中
   *
   * @param str input string
   * @param k:  an integer
   *
   * @return a string such that the same characters are at least distance k from each other
   */
  public String rearrangeString(final String str, final int k) {
    if (str == null || k <= 1) {
      return str;
    }
    // 一个哈希表来建立字符和其出现次数之间的映射，然后需要一个堆来保存这每一堆映射，按照出现次数来排序。
    final int[] characterMap = new int[26];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      characterMap[c - 'a']++;
    }

    // alphabetic order if count are same
    // otherwise descending order by count
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
    for (int j = 0; j < 26; j++) {
      if (characterMap[j] != 0) {
        heap.offer(new int[]{j, characterMap[j]});
      }
    }
    final StringBuilder result = new StringBuilder();
    int len = str.length();
    // 然后如果堆不为空我们就开始循环，我们找出k和str长度之间的较小值，然后从0遍历到这个较小值，
    while (!heap.isEmpty()) {
      final int count = Math.min(len, k);
      final List<int[]> candidate = new ArrayList<>();
      for (int i = 0; i < count; i++) {
        // 对于每个遍历到的值，如果此时堆为空了，说明此位置没法填入字符了，返回空字符串，
        if (heap.isEmpty()) {
          return "";
        }
        // 否则我们从堆顶取出一对映射，然后把字母加入结果res中，此时映射的个数减1，
        final int[] top = heap.poll();
        result.append((char) ('a' + top[0]));
        // 如果减1后的个数仍大于0，则我们将此映射加入临时集合v中，同时str的个数len减1
        // still need to fill more of this character
        if (--top[1] > 0) {
          candidate.add(top);
        }
        --len;
      }
      // 遍历完一次，我们把临时集合中的映射对由加入堆中
      for (int[] t : candidate) {
        heap.add(t);
      }
    }
    return result.toString();
  }
}
