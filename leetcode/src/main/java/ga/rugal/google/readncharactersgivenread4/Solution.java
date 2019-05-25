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
package ga.rugal.google.readncharactersgivenread4;

import ga.rugal.google.Reader4;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4/
 *
 * @author rugal
 */
public class Solution extends Reader4 {

  private static final int SIZE = 4;

  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   *
   * @return The number of actual characters read
   */
  public int read(char[] buf, int n) {
    final char[] temp = new char[SIZE];
    int i = 0;
    while (i < n) {
      final int size = Integer.min(n - i, this.read4(temp));
      for (int j = 0; j < size; ++j) {
        buf[i + j] = temp[j];
      }
      i += size;
      if (size < SIZE) {
        break;
      }
    }
    return i;
  }
}
