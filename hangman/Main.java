package hangman;

import java.io.IOException;
import java.io.File;
import java.util.Set;
import java.util.Scanner;
import hangman.IEvilHangmanGame.GuessAlreadyMadeException;
import java.util.Iterator;

public class Main {
   public static Scanner userInput = new Scanner(System.in);
   
   public static class IllegalArgumentsException extends Exception {
   }
   
   public static class EmptyDictionarySetException extends Exception {
   }   
   
   public static void main(String[] args) throws Exception {
      try {
         if (args.length != 3 || !args[1].matches("[0-9]+") || !args[2].matches("[0-9]+") || Integer.parseInt(args[1]) < 2 || Integer.parseInt(args[2]) < 1) {
            throw new IllegalArgumentsException();
         }
         
         EvilHangmanGame hangman = new EvilHangmanGame();
         File dictionaryFile = new File(args[0]);
         int wordLength = Integer.parseInt(args[1]);
         int numGuesses = Integer.parseInt(args[2]);
         String word = hangman.GetWord();
      
         hangman.startGame(dictionaryFile, wordLength);
         
         while (numGuesses > 0) {
            if (hangman.GetDictionarySet().isEmpty()) {
               throw new EmptyDictionarySetException();
            }
            word = hangman.GetWord();
            
            char guess = ' ';
            
            if (numGuesses == 1) {
               System.out.println("You have " + numGuesses + " guess left");
            }
            else {
               System.out.println("You have " + numGuesses + " guesses left");
            }
            
            Set<Character> guessesMade = hangman.GetGuessesMade();
            
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
               
               // System.out.println("Original");
               // for (String Word : dictionarySet) {
               //    System.out.println(Word);
               // }
               
               hangman.makeGuess(guess);
               
               // System.out.println("\nChanged");
               // for (String Word : dictionarySet) {
               //    System.out.println(Word);
               // }
               
            }
            catch (GuessAlreadyMadeException e) {
               System.out.println("You already made that guess...");
            }
            
            System.out.println();
            
            if (word.equals(hangman.GetWord())) {
               numGuesses--;
            }
         }
         
         
         if (word.indexOf("-") == -1) {
            System.out.println("You Win!");
            System.out.println(word);
         }
         else {
            System.out.println("You lose!");
            
            Set<String> dictionarySet = hangman.GetDictionarySet();
            Iterator<String> iter = dictionarySet.iterator();
            String finalWord = iter.next();
            
            System.out.println("The word was: " + finalWord);
         }
      }
      catch (IllegalArgumentsException e) {
         System.out.println("Usage: java hangman.Main <dictionary file> <word length> <guesses>");
      }
      catch (EmptyDictionarySetException e) {
         System.out.println("Dictionary is empty...");
      }
   }
}