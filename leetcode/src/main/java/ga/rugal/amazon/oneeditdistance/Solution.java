/*
 * Copyright 2019 rugalbernstein.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ga.rugal.amazon.oneeditdistance;

/**
 * https://leetcode.com/problems/one-edit-distance/
 *
 * @author rugalbernstein
 */
public class Solution {

  public boolean isOneEditDistance(String s, String t) {
    return this.minDistance(s, t) == 1;
  }

  private int minDistance(final String word1, final String word2) {

    final int[][] dp = new int[word1.length() + 1][word2.length() + 1];

    for (int i = 0; i <= word1.length(); i++) {
      dp[i][0] = i;
    }

    for (int j = 0; j <= word2.length(); j++) {
      dp[0][j] = j;
    }

    //iterate though, and check last char
    for (int i = 0; i < word1.length(); i++) {
      final char c1 = word1.charAt(i);
      for (int j = 0; j < word2.length(); j++) {
        final char c2 = word2.charAt(j);

        //if two chars equal
        if (c1 == c2) {
          //then the edit distance is the same as the one before
          dp[i + 1][j + 1] = dp[i][j];
          continue;
        }
        final int replace = dp[i][j] + 1;
        final int insert = dp[i][j + 1] + 1;
        final int delete = dp[i + 1][j] + 1;
        dp[i + 1][j + 1] = Integer.min(delete, Integer.min(insert, replace));
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
