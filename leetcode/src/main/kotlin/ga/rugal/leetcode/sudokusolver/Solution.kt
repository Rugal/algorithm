package ga.rugal.leetcode.sudokusolver

import kotlin.math.min

const val length = 9

class Solution {

  private var board: Array<CharArray> = arrayOf()

  /**
   * [
   * 0  ["5","3",".",".","7",".",".",".","."],
   * 1  ["6",".",".","1","9","5",".",".","."],
   * 2  [".","9","8",".",".",".",".","6","."],
   * 3  ["8",".",".",".","6",".",".",".","3"],
   * 4  ["4",".",".","8",".","3",".",".","1"],
   * 5  ["7",".",".",".","2",".",".",".","6"],
   * 6  [".","6",".",".",".",".","2","8","."],
   * 7  [".",".",".","4","1","9",".",".","5"],
   * 8  [".",".",".",".","8",".",".","7","9"]
   * ]
   */
  fun solveSudoku(board: Array<CharArray>): Unit {
    this.board = board
    fill(0, 0)
  }

  private fun isValidRow(row: Int, value: Char): Boolean = (0..8).none { this.board[row][it] == value }

  private fun isValidColumn(column: Int, value: Char): Boolean = (0..8).none { this.board[it][column] == value }

  private fun isValidSquare(row: Int, column: Int, value: Char): Boolean {
    val r = row / 3 * 3
    val c = column / 3 * 3

    (r..r + 2).forEach { i ->
      (c..c + 2).forEach { j ->
        if (this.board[i][j] == value) return false
      }
    }
    return true
  }

  private fun isValid(row: Int, column: Int, value: Char): Boolean =
    this.isValidRow(row, value)
      && this.isValidColumn(column, value)
      && this.isValidSquare(row, column, value)

  private fun fill(row: Int, column: Int): Boolean {
    // complete
    if (row >= length) return true
    // move to next row
    if (column >= length) return fill(row + 1, 0)
    // move to next column if current one is filled already
    if (this.board[row][column] != '.') return fill(row, column + 1)

    for (i in 1..9) {
      // cancel existing current value
      this.board[row][column] = '.'
      // if valid
      if (!this.isValid(row, column, i.digitToChar())) continue
      // fill the number
      this.board[row][column] = i.digitToChar()
      // and move to next column
      if (!this.fill(row, column + 1)) {
        // and make sure next move is also valid
        // otherwise cancel the current fill
        this.board[row][column] = '.'
        continue
      }
      // if next move is valid, great
      return true

    }
    // after all trial, still no matching under the given configuration
    return false
  }
}
