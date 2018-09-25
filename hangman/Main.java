package hangman;

import java.io.IOException;
import java.io.File;

public class Main {
   
   public static class IllegalArgumentsException extends Exception {
   }
   
   public static void main(String[] args) throws Exception {
      try {
         if (args.length != 3 || !args[1].matches("[1-9]+") || !args[2].matches("[1-9]+")) {
            throw new IllegalArgumentsException();
         }
         
         EvilHangmanGame hangman = new EvilHangmanGame();
         File dictionaryFile = new File(args[0]);
         int wordLength = Integer.parseInt(args[1]);
         
         hangman.startGame(dictionaryFile, wordLength);
         hangman.RunGame();
      }
      catch (IllegalArgumentsException e) {
         System.out.println("Usage: java hangman.Main <dictionary file> <word length> <guesses>");
      }
   }
}


/* errors to handle
command line arguments
cant find file
*/