package hangman;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;
import java.util.Iterator;

public class EvilHangmanGame implements IEvilHangmanGame {
   Set<String> dictionarySet = new TreeSet<String>();
   Set<Character> guessesMade = new TreeSet<Character>();
   Scanner userInput = new Scanner(System.in);
   int numGuesses = 0;
   StringBuilder word = new StringBuilder();
   
   public class EmptyDictionaryFileException extends Exception {
   }
   
   public class InvalidCharactersException extends Exception {
   }
   
   public EvilHangmanGame() {
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
         index = 0;
         foundIndex = 0;
         StringBuilder key = new StringBuilder();
         
         while (index != -1) {
            foundIndex = nextWord.indexOf(guess, index);
            if (foundIndex != -1) {
               key.append(foundIndex);
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
      
      int maxWords = 0;
      Iterator<String> iter = wordGroups.keySet().iterator();
      
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
      
      if (wordGroups.containsKey("NONE")) {
         numGuesses--;
         System.out.println("Sorry, there are no " + guess + "\'s");
         return wordGroups.get("NONE");
      }
      
      else if (wordGroups.keySet().size() > 1) {
         int minKeyLength = 100;
         iter = wordGroups.keySet().iterator();
         while (iter.hasNext()) {
            //System.out.println("1");
            String nextKey = iter.next();
            if (nextKey.length() < minKeyLength) {
               minKeyLength = nextKey.length();
            }
         }
         
         iter = wordGroups.keySet().iterator();
         while (iter.hasNext()) {
            //System.out.println("2");
            String nextKey = iter.next();
            if (nextKey.length() > minKeyLength) {
               iter.remove();
            }
         }
         
         int maxRightmostLetter = -1;
         Set<Integer> positionsExcluded= new TreeSet<Integer>();
         while (wordGroups.keySet().size() > 1) {
            
            //System.out.println("3");
            maxRightmostLetter = -1;
            iter = wordGroups.keySet().iterator();
            
            while (iter.hasNext()) { //get rightmostLetter (not in excluded set)
               String nextKey = iter.next();
               for (int i = nextKey.length() - 1; i >= 0; --i) {
                  if (!positionsExcluded.contains(nextKey.charAt(i) - '0')) {
                     if (nextKey.charAt(i) - '0' > maxRightmostLetter) {
                        maxRightmostLetter = nextKey.charAt(i) - '0';
                     }
                     break;
                  }
               }
            }
            
            iter = wordGroups.keySet().iterator();
            while (iter.hasNext()) {
               String nextKey = iter.next();
               for (int i = nextKey.length() - 1; i >= 0; --i) {
                  if (!positionsExcluded.contains(nextKey.charAt(i) - '0')) {
                     if (nextKey.charAt(i) - '0' < maxRightmostLetter) {
                        iter.remove();
                     }
                     break;
                  }
               }
            }
            positionsExcluded.add(maxRightmostLetter);
            //for each key, if key's rightmostletter (not in exluded set) is less than max, delete
            
            //If there is still more than one group, choose the one with the next rightmost letter. Repeat this step (step 4) until a group is chosen.
         }
         //System.out.println(wordGroups.keySet().size());
         
         iter = wordGroups.keySet().iterator();
         String nextKey = iter.next();
         for (int i = 0; i < nextKey.length(); ++i) {
            word.setCharAt(nextKey.charAt(i) - '0', guess);
         }
         
         System.out.printf("Yes, there");
         if (nextKey.length() == 1) {
            System.out.printf(" is ");
         }
         else {
            System.out.printf(" are ");
         }
         
         System.out.println(nextKey.length() + " " + String.valueOf(guess) + "\'s");
         return wordGroups.get(nextKey);
      }
      
      else {
         iter = wordGroups.keySet().iterator();
         String nextKey = iter.next();
         for (int i = 0; i < nextKey.length(); ++i) {
            word.setCharAt(nextKey.charAt(i) - '0', guess);
         }
         System.out.printf("Yes, there");
         if (nextKey.length() == 1) {
            System.out.println(" is " + nextKey.length() + " " + String.valueOf(guess));
         }
         else {
            System.out.println(" are " + nextKey.length() + " " + String.valueOf(guess) + "\'s");
         }
         
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
   
   public void NextTurn() {
      char guess = ' ';
      
      if (numGuesses == 1) {
         System.out.println("You have " + numGuesses + " guess left");
      }
      else {
         System.out.println("You have " + numGuesses + " guesses left");
      }
      System.out.printf("Used letters: ");
      for (Character character : guessesMade) {
         System.out.printf(character + " ");
      }
      System.out.println("\nWord: " + word.toString());
      
      boolean badInput = true;
      String badInputString = new String();
      
      do {
         System.out.printf("Enter guess: ");
         if (userInput.hasNext("[a-zA-Z]")) {
            guess = userInput.next().charAt(0);
            if (guessesMade.contains(guess)) {
               System.out.println("You already used that letter\n");
            }
            else {
               badInput = false;
            }
         }
         else {
            badInputString = userInput.nextLine();
            System.out.println("Invalid input");
            System.out.println();
         }
      } while (badInput);
      
      try {
         /*
         System.out.println("Original");
         for (String Word : dictionarySet) {
         System.out.println(Word);
      }
      */
      dictionarySet = makeGuess(guess);
      // for (String nextWord : dictionarySet) {
      //    System.out.println(nextWord);
      // }
      
      /*
      System.out.println("\nChanged");
      for (String Word : dictionarySet) {
      System.out.println(Word);
   }
   */
}
catch (GuessAlreadyMadeException e) {
   System.out.println("You already made that guess...");
}

System.out.println();
}

public void RunGame(int wordLength, int numberOfGuesses) {
   numGuesses = numberOfGuesses;
   
   for (int i = 0; i < wordLength; ++i) {
      word.append('-');
   }
   
   while (numGuesses > 0) {
      NextTurn();
   }
   if (word.indexOf("-") == -1) {
      System.out.println("You Win!");
      System.out.println(word);
   }
   else {
      System.out.println("You lose!");
      Iterator<String> iter = dictionarySet.iterator();
      String result = iter.next();
      System.out.println("The word was: " + result);
   }
}
}
