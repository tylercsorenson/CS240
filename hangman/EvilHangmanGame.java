package hangman;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;

public class EvilHangmanGame implements IEvilHangmanGame {
   TreeSet<String> dictionarySet = new TreeSet<String>();
   TreeSet<Character> guessesMade = new TreeSet<Character>();
   Scanner userInput = new Scanner(System.in);
   
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
      
      return null;
   }
   
   public void LoadDictionary(File dictionary) throws FileNotFoundException, InvalidCharactersException, EmptyDictionaryFileException {
      dictionarySet.clear();
      
      Scanner dictionaryInput = new Scanner(dictionary);
      
      while (dictionaryInput.hasNext()) {
         if (dictionaryInput.hasNext("[a-zA-Z]*[^a-zA-Z][a-zA-Z]*")) {
            throw new InvalidCharactersException();
         }
         else {
            dictionarySet.add(dictionaryInput.next());
         }
      }
      
      if(dictionarySet.isEmpty()) {
         throw new EmptyDictionaryFileException();
      }
      
      dictionaryInput.close();
   }
   
   public int NextTurn(int numGuesses, StringBuilder word) {
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
         makeGuess(guess);
      }
      catch (GuessAlreadyMadeException e) {
         System.out.println("You already made that guess...");
      }
      
      System.out.println();
      
      numGuesses--;
      return numGuesses;
   }
   
   public void RunGame(int numGuesses, int wordLength) {
      StringBuilder word = new StringBuilder();
      
      for (int i = 0; i < wordLength; ++i) {
         word.append('-');
      }
      
      while (numGuesses > 0) {
         numGuesses = NextTurn(numGuesses, word);
      }
   }
}
