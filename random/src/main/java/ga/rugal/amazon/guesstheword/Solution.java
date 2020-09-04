/*
 * Copyright 2019 rugalbernstein.
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
package ga.rugal.amazon.guesstheword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/guess-the-word/
 *
 * @author rugalbernstein
 */
public class Solution {

  public void findSecretWord(final String[] wordlist, final Master master) {
    int guess = -1;
    List<String> temp = new ArrayList();
    //sort word list for better guess + put it in a List
    Arrays.sort(wordlist);
    temp.addAll(Arrays.asList(wordlist));
    //If the worklist is empty we dont need to do anything, else we can directly get the one at 0 (being the first)
    if (!temp.isEmpty()) {
      //We try 10 times, however we stop once we have guess = 6 (Because it's bingo)
      for (int i = 0; i < 10 && guess != 6; i++) {
        //get the score of the first element
        guess = master.guess(temp.get(0));
        //update the worklist by filtering it to only possible candidates
        temp = getLeftCandidates(temp, temp.get(0), guess);
      }
    }
  }

  //to filter we make sure that the score we currently got matches with the elements remaining, 
  //since the master is comparing it with the secret word, we only want to keep the elements that are possible candidates to be the secret word.
  //Helper method characterScore is used to identify the score (as per the description of the problem)
  private List getLeftCandidates(List<String> wordList, String str, int guess) {
    List<String> toReturn = new ArrayList();
    for (String word : wordList) {
      if (characterScore(word, str) == guess) {
        toReturn.add(word);
      }
    }
    return toReturn;
  }

  //Simple method, with for loop to 6 (since length is known) count the number of character matching on value and position,
  //that between two words. Will be used with the word we got the guess score from master of and the words we are trying to filter
  private int characterScore(String word1, String word2) {
    int count = 0;
    for (int i = 0; i < 6; i++) {
      if (word1.charAt(i) == word2.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}
