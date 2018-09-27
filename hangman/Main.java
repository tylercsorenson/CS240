package hangman;

import java.io.IOException;
import java.io.File;

public class Main {
   
   public static class IllegalArgumentsException extends Exception {
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
      
         hangman.startGame(dictionaryFile, wordLength);
         hangman.RunGame(wordLength, numGuesses);
      }
      catch (IllegalArgumentsException e) {
         System.out.println("Usage: java hangman.Main <dictionary file> <word length> <guesses>");
      }
   }
}