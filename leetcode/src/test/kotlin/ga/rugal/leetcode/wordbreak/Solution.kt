package ga.rugal.leetcode.wordbreak


class Solution {

  fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val words: Set<String> = wordDict.toSet()
    val result: Array<Boolean> = Array<Boolean>(s.length + 1) { it == 0 }

    for (current in 1..s.length)
      for (i in 0..<current)
        if (result[i] && words.contains(s.substring(i, current))) {
          result[current] = true
          break
        }
    return result[s.length]
  }


//  fun wordBreak(s: String, wordDict: List<String>): Boolean {
//    val set: Set<String> = wordDict.toSet()
//    val result = BooleanArray(s.length + 1) { it != 0}
////    result[0] = true
//    for (current in 1 until result.size) {
//      for (i in 0 until current) {
//        if (result[i] && set.contains(s.substring(i, current))) {
//          result[current] = true
//          break
//        }
//      }
//    }
//    return result[s.length]
//  }
}
