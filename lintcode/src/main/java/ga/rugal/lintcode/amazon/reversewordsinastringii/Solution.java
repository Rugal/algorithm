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
package ga.rugal.lintcode.amazon.reversewordsinastringii;

/**
 * https://www.lintcode.com/problem/reverse-words-in-a-string-ii/description
 *
 * @author rugal
 */
public class Solution {

  private char[] text;

  /**
   * @param str: a string
   *
   * @return return a string
   */
  public char[] reverseWords(final char[] str) {
    this.text = str;
    int last = 0;
    for (int i = 0; i < this.text.length; ++i) {
      if (this.text[i] == ' ') {
        this.reverse(last, i - 1);
        last = i + 1;
      }
    }
    this.reverse(last, this.text.length - 1);
    this.reverse(0, this.text.length - 1);
    return this.text;
  }

  private void reverse(final int start, final int stop) {
    for (int i = start; i < (start + stop + 1) / 2; ++i) {
      final int index = start + stop - i;
      final char temp = this.text[i];
      this.text[i] = this.text[index];
      this.text[index] = temp;
    }
  }
}
