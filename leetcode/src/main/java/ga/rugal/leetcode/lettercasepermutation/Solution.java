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
package ga.rugal.leetcode.lettercasepermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 *
 * @author rugal
 */
public class Solution {

  private String text;

  private final List<String> result = new ArrayList<>();

  public List<String> letterCasePermutation(final String S) {
    this.text = S;
    this.backtrack(new StringBuilder(), 0);
    return this.result;
  }

  private void backtrack(final StringBuilder temp, final int start) {
    if (temp.length() >= this.text.length()) {
      this.result.add(temp.toString());
      return;
    }

    //always add character irregardless of character or digit
    temp.append(Character.toLowerCase(this.text.charAt(start)));
    this.backtrack(new StringBuilder(temp.toString()), start + 1);

    //flip it if is character
    if (!Character.isDigit(this.text.charAt(start))) {
      temp.deleteCharAt(temp.length() - 1);
      temp.append(Character.toUpperCase(this.text.charAt(start)));
      this.backtrack(new StringBuilder(temp.toString()), start + 1);
    }
  }
}
