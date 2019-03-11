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
package ga.rugal.leetcode;

import java.util.List;

/**
 *
 * @author rugal
 */
public class Node {

  public int val;

  public List<Node> neighbors;

  public Node() {
  }

  public Node(final int _val, final List<Node> _neighbors) {
    this.val = _val;
    this.neighbors = _neighbors;
  }
}
