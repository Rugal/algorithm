package ga.rugal.leetcode.sudokusolver

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

  private val s = Solution()

  val input = arrayOf(
    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
  )

  val expected = arrayOf(
    charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
    charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
    charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
    charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
    charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
    charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
    charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
    charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
    charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
  )
  /*
  9  8  3  4   5  7  6  2  1
   7 6 1 8 2 9 5 3 4
   2 4 5 3 6 1 8 9 7
   5 7 4 2 8 3 9 1 6
    1 3 6  9 4 5 2 7 8 
    8 2 9 7 1 6 4 5 3 
    3 1 2  6  9 8  7 4 5
    6  9 7  5 3 4  1  8 2
    4 5  8 1 7 2 3  6 9
   */

  @Test
  fun solve() {
    this.s.solveSudoku(input)
    for (i in 0..8) {
      Assertions.assertArrayEquals(expected[i], input[i])
    }
  }
}
