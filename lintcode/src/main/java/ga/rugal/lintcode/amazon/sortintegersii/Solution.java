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
package ga.rugal.lintcode.amazon.sortintegersii;

/**
 * https://www.lintcode.com/problem/sort-integers-ii/description
 *
 * @author rugal
 */
public class Solution {

  /**
   * @param A: an integer array
   *
   */
  public void sortIntegers2(int[] A) {
    // write your code here
    this.quicksort(A);
  }

  private int[] quicksort(final int[] A) {
    this.quickSort(A, 0, A.length - 1);
    return A;
  }

  private void quickSort(final int arr[], final int begin, final int end) {
    if (begin < end) {
      final int partitionIndex = partition(arr, begin, end);

      quickSort(arr, begin, partitionIndex - 1);
      quickSort(arr, partitionIndex + 1, end);
    }
  }

  private int partition(final int arr[], final int begin, final int end) {
    final int pivot = arr[end];
    int i = (begin - 1);//first number at left that is greater than pivot

    //after traversal, the side to the left of i will be smaller than pivot
    //the right side will be greater than pivot
    for (int j = begin; j < end; j++) {
      if (arr[j] <= pivot) {
        i++;

        final int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
      }
    }

    //eventually the pivot value must be swapped with mid actual mid value
    final int swapTemp = arr[i + 1];
    arr[i + 1] = arr[end];
    arr[end] = swapTemp;

    return i + 1;
  }
}
