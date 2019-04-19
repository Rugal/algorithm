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
package ga.rugal.lintcode.amazon.logsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.lintcode.com/problem/log-sorting/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param logs: the logs
   *
   * @return: the log after sorting
   */
  class MyCompartor implements Comparator {

    @Override
    public int compare(Object a1, Object a2) {
      String o1 = (String) a1;
      String o2 = (String) a2;
      int idx1 = o1.indexOf(' ');
      int idx2 = o2.indexOf(' ');
      String head1 = o1.substring(0, idx1);
      String head2 = o2.substring(0, idx2);
      String body1 = o1.substring(idx1);
      String body2 = o2.substring(idx2);
      if (body1.equals(body2)) {
        return head1.compareTo(head2);
      } else {
        return body1.compareTo(body2);
      }
    }
  }

  public String[] logSort(String[] logs) {
    // Write your code here
    List<String> list = new ArrayList<>();
    String[] ans = new String[logs.length];
    int cnt = logs.length - 1;
    for (int i = logs.length - 1; i >= 0; i--) {
      int index = logs[i].indexOf(' ');
      String body = logs[i].substring(index + 1);
      if (body.charAt(0) >= '0' && body.charAt(0) <= '9') {
        ans[cnt--] = logs[i];
      } else {
        list.add(logs[i]);
      }
    }
    Collections.sort(list, new MyCompartor());

    cnt = 0;
    for (String i : list) {
      ans[cnt++] = i;
    }
    return ans;
  }
}
