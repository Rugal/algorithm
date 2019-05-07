/*
 * Copyright 2019 rugal.
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
package ga.rugal.leetcode.mostcommonword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/most-common-word/
 *
 * @author rugal
 */
public class Solution {

  public String mostCommonWord(String paragraph, String[] banned) {
    paragraph += ".";

    Set<String> banset = new HashSet();
    banset.addAll(Arrays.asList(banned));
    Map<String, Integer> count = new HashMap();

    String ans = "";
    int ansfreq = 0;

    StringBuilder word = new StringBuilder();
    for (char c : paragraph.toCharArray()) {
      if (Character.isLetter(c)) {
        word.append(Character.toLowerCase(c));
      } else if (word.length() > 0) {
        String finalword = word.toString();
        if (!banset.contains(finalword)) {
          count.put(finalword, count.getOrDefault(finalword, 0) + 1);
          if (count.get(finalword) > ansfreq) {
            ans = finalword;
            ansfreq = count.get(finalword);
          }
        }
        word = new StringBuilder();
      }
    }

    return ans;
  }
}
