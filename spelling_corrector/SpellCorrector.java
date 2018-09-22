package spell;

import java.io.*;
import java.util.*;

public class SpellCorrector implements ISpellCorrector {
   private Trie dictionary = new Trie();
   private Trie secondDictionary = new Trie();
   
   public SpellCorrector() {}

	/**
	 * Tells this <code>SpellCorrector</code> to use the given file as its dictionary
	 * for generating suggestions.
	 * @param dictionaryFileName File containing the words to be used
	 * @throws IOException If the file cannot be read
	 */
	public void useDictionary(String dictionaryFileName) throws IOException {
      try {
         Scanner input = new Scanner(new File(dictionaryFileName));
         input.useDelimiter("[^a-zA-Z]");
         
         while (input.hasNext()) {
            dictionary.add(input.next());
         }
         input.close();
         
         System.out.println(dictionary.hashCode());
      }
      catch (Exception exception) {
         exception.printStackTrace();
      }
   }

	/**
	 * Suggest a word from the dictionary that most closely matches
	 * <code>inputWord</code>
	 * @param inputWord
	 * @return The suggestion or null if there is no similar word in the dictionary
	 */
	public String suggestSimilarWord(String inputWord) { //FIXME
      String suggestedWord = new String();
      return suggestedWord;
   }

}