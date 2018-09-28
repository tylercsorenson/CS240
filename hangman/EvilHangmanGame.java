package hangman;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;
import java.util.Iterator;
import java.util.ArrayList;

public class EvilHangmanGame implements IEvilHangmanGame {
   private Set<String> dictionarySet = new TreeSet<String>();
   private Set<Character> guessesMade = new TreeSet<Character>();
   private StringBuilder word = new StringBuilder();
   
   public class EmptyDictionaryFileException extends Exception {
   }
   
   public class InvalidCharactersException extends Exception {
   }
   
   public EvilHangmanGame() {
   }
   
   private int GetNumCharInString(String string, char character) {
      int index = 0;
      int foundIndex = 0;
      int count = 0;
      
      while (index != -1) {
         foundIndex = string.indexOf(character, index);
         if (foundIndex != -1) {
            count++;
            index = foundIndex + 1;
         }
         else {
            index = foundIndex;
         }
      }
      
      return count;
   }
   
   private ArrayList<String> StringToList(String string) {
      StringBuilder currentString = new StringBuilder();
      ArrayList<String> result = new ArrayList<String>();
      
      Scanner stringScanner = new Scanner(string);
      stringScanner.useDelimiter(",");
      
      while (stringScanner.hasNext()) {
         result.add(stringScanner.next());
      }
      return result;
   }
   
   /**
   * Starts a new game of evil hangman using words from <code>dictionary</code>
   * with length <code>wordLength</code>.
   *	<p>
   *	This method should set up everything required to play the game,
   *	but should not actually play the game. (ie. There should not be
   *	a loop to prompt for input from the user.)
   * 
   * @param dictionary Dictionary of words to use for the game
   * @param wordLength Number of characters in the word to guess
   */
   public void startGame(File dictionary, int wordLength) {      
      try {
         guessesMade.clear();
         
         for (int i = 0; i < wordLength; ++i) {
            word.append('-');
         }
         
         LoadDictionary(dictionary);
         
         Iterator<String> iter = dictionarySet.iterator();
         while (iter.hasNext()) {
            if (iter.next().length() != wordLength) {
               iter.remove();
            }
         }   
      }
      catch (FileNotFoundException e) {
         System.out.println("Dictionary file not found...");
      }
      catch (InvalidCharactersException e) {
         dictionarySet.clear();
         System.out.println("Invalid characters found in dictionary file...");
      }
      catch (EmptyDictionaryFileException e) {
         System.out.println("Dictionary file is empty...");
      }
   }
   
   /**
   * Make a guess in the current game.
   * 
   * @param guess The character being guessed
   *
   * @return The set of strings that satisfy all the guesses made so far
   * in the game, including the guess made in this call. The game could claim
   * that any of these words had been the secret word for the whole game. 
   * 
   * @throws GuessAlreadyMadeException If the character <code>guess</code> 
   * has already been guessed in this game.
   */
   public Set<String> makeGuess(char guess) throws GuessAlreadyMadeException {
      guessesMade.add(guess);
      HashMap<String, TreeSet<String>> wordGroups = new HashMap<String, TreeSet<String>>();
      int index = 0;
      int foundIndex = 0;
      
      for (String nextWord : dictionarySet) {
         System.out.println("nextWord: " + nextWord);
         index = 0;
         foundIndex = 0;
         StringBuilder key = new StringBuilder();
         
         while (index != -1) {
            foundIndex = nextWord.indexOf(guess, index);
            System.out.println("foundIndex: " + foundIndex);
            if (foundIndex != -1) {
               key.append(foundIndex);
               key.append(",");
               index = foundIndex + 1;
            }
            else {
               index = foundIndex;
            }
         }
         if (key.length() == 0) {
            key.append("NONE");
         }
         
         if (!wordGroups.containsKey(key.toString())) {
            wordGroups.put(key.toString(), new TreeSet<String>());
         }
         wordGroups.get(key.toString()).add(nextWord);
      }
      
      for (String key : wordGroups.keySet()) {
         System.out.println("key: " + key);
         for (String value : wordGroups.get(key)) {
            System.out.println(value);
         }
      }
      
      int maxWords = 0;
      Iterator<String> iter = wordGroups.keySet().iterator();
      
      // System.out.println("After setting up subsets, before finding one with most words");
      // while (iter.hasNext()) {
      //    String nextKey = iter.next();
      //    System.out.println("key: " + nextKey);
      //    for (String string : wordGroups.get(nextKey)) {
      //       System.out.println(string);
      //    }
      // }
      // 
      // iter = wordGroups.keySet().iterator();
      
      while (iter.hasNext()) {
         String nextKey = iter.next();
         if (wordGroups.get(nextKey).size() > maxWords) {
            maxWords = wordGroups.get(nextKey).size();
         }
      }
      
      iter = wordGroups.keySet().iterator();
      while (iter.hasNext()) {
         String nextKey = iter.next();
         if (wordGroups.get(nextKey).size() < maxWords) {
            iter.remove();
         }
      }
      
      // System.out.println("After finding one with most words");
      // iter = wordGroups.keySet().iterator();
      // while (iter.hasNext()) {
      //    String nextKey = iter.next();
      //    System.out.println("key: " + nextKey);
      //    for (String string : wordGroups.get(nextKey)) {
      //       System.out.println(string);
      //    }
      // }
      
      System.out.println("Number of keys: " + wordGroups.keySet().size());
      
      if (wordGroups.containsKey("NONE")) {
         System.out.println("Sorry, there are no " + guess + "\'s");
         
         iter = wordGroups.keySet().iterator();
         String nextKey = iter.next();
         System.out.println("1!");
         
         System.out.println("\"NONE\" subset");
         for (String string : wordGroups.get("NONE")) {
            System.out.println(string);
         }
         dictionarySet.clear();
         dictionarySet = wordGroups.get("NONE");
         return wordGroups.get("NONE");
      }
      
      
      
      else if (wordGroups.keySet().size() > 1) {
         int minKeyLength = 100;
         iter = wordGroups.keySet().iterator();
         while (iter.hasNext()) {
            //System.out.println("1");
            String nextKey = iter.next();
            if (GetNumCharInString(nextKey, ',') < minKeyLength) {
               minKeyLength = GetNumCharInString(nextKey, ',');
            }
         }
         
         iter = wordGroups.keySet().iterator();
         while (iter.hasNext()) {
            //System.out.println("2");
            String nextKey = iter.next();
            if (GetNumCharInString(nextKey, ',') > minKeyLength) {
               iter.remove();
            }
         }
         
         int maxRightmostLetter = -1;
         Set<Integer> positionsExcluded = new TreeSet<Integer>();
         while (wordGroups.keySet().size() > 1) {
            maxRightmostLetter = -1;
            
            //determine maxrightmost letter position, not including excluded positions
            iter = wordGroups.keySet().iterator();
            while (iter.hasNext()) {
               String nextKey = iter.next();
               ArrayList<String> stringList = StringToList(nextKey);
               System.out.println(stringList.size());
               for (int i = stringList.size() - 1; i >= 0; --i) {
                  int nextPosition = Integer.parseInt(stringList.get(i));
                  System.out.println("nextPosition: " + nextPosition);
                  if (!positionsExcluded.contains(nextPosition)) {
                     if (nextPosition > maxRightmostLetter) {
                        //System.out.println("nextPosition: " + nextPosition);
                        maxRightmostLetter = nextPosition;
                     }
                     break;
                  }
               }
            }
            
            //for each subset, delete it if it's rightmost letter position is less than the max
            iter = wordGroups.keySet().iterator();
            while (iter.hasNext()) {
               String nextKey = iter.next();
               ArrayList<String> stringList = StringToList(nextKey);
               for (int i = stringList.size() - 1; i >= 0; --i) {
                  int nextPosition = Integer.parseInt(stringList.get(i));
                  if (!positionsExcluded.contains(nextPosition)) {
                     if (nextPosition < maxRightmostLetter) {
                        iter.remove();
                     }
                     break;
                  }
               }
            }
            
            //put the max in the excluded list
            positionsExcluded.add(maxRightmostLetter);
         }
      
         iter = wordGroups.keySet().iterator();
         String nextKey = iter.next();
         ArrayList<String> nextKeyList = StringToList(nextKey);
         for (int i = 0; i < nextKeyList.size(); ++i) {
            word.setCharAt(Integer.parseInt(nextKeyList.get(i)), guess);
         }
         
         System.out.printf("Yes, there");
         if (GetNumCharInString(nextKey, ',') == 1) {
            System.out.println(" is " + GetNumCharInString(nextKey, ',') + " " + String.valueOf(guess));
         }
         else {
            System.out.println(" are " + GetNumCharInString(nextKey, ',') + " " + String.valueOf(guess) + "\'s");
         }
         
         
         
         System.out.println("2!");
         for (String string : wordGroups.get(nextKey)) {
            System.out.println(string);
         }
         
         
         
         dictionarySet.clear();
         dictionarySet = wordGroups.get(nextKey);
         return wordGroups.get(nextKey);
      }
      
      else {
         iter = wordGroups.keySet().iterator();
         String nextKey = iter.next();
         ArrayList<String> nextKeyList = StringToList(nextKey);
         for (int i = 0; i < nextKeyList.size(); ++i) {
            word.setCharAt(Integer.parseInt(nextKeyList.get(i)), guess);
         }
         
         System.out.printf("Yes, there");
         if (GetNumCharInString(nextKey, ',') == 1) {
            System.out.println(" is " + GetNumCharInString(nextKey, ',') + " " + String.valueOf(guess));
         }
         else {
            System.out.println(" are " + GetNumCharInString(nextKey, ',') + " " + String.valueOf(guess) + "\'s");
         }
         
         
         System.out.println("3!");
         for (String string : wordGroups.get(nextKey)) {
            System.out.println(string);
         }
         
         
         dictionarySet.clear();
         dictionarySet = wordGroups.get(nextKey);
         return wordGroups.get(nextKey);
      }
   }
   
   public void LoadDictionary(File dictionary) throws FileNotFoundException, InvalidCharactersException, EmptyDictionaryFileException {
      dictionarySet.clear();
      
      Scanner dictionaryInput = new Scanner(dictionary);
      
      while (dictionaryInput.hasNext()) {
         if (dictionaryInput.hasNext("[a-zA-Z]*[^a-zA-Z][a-zA-Z]*")) {
            throw new InvalidCharactersException();
         }
         else {
            String nextString = dictionaryInput.next().toLowerCase();
            dictionarySet.add(nextString);
         }
      }
      
      if(dictionarySet.isEmpty()) {
         throw new EmptyDictionaryFileException();
      }
      
      dictionaryInput.close();
   }
   
   public String GetWord() {
      return word.toString();
   }
   
   public Set<Character> GetGuessesMade() {
      return guessesMade;
   }
   
   public Set<String> GetDictionarySet() {
      return dictionarySet;
   }
}