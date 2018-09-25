package spell;

import java.io.*;
import java.util.*;

public class SpellCorrector implements ISpellCorrector {
   private Trie dictionary = new Trie();
   private HashMap<Character, Integer> letterMap;
   private HashMap<Integer, Character> reverseLetterMap;
   
   private void CreateLetterMaps() {
      letterMap = new HashMap<Character, Integer>();
      reverseLetterMap = new HashMap<Integer, Character>();
      letterMap.put('a', 0);
      letterMap.put('b', 1);
      letterMap.put('c', 2);
      letterMap.put('d', 3);
      letterMap.put('e', 4);
      letterMap.put('f', 5);
      letterMap.put('g', 6);
      letterMap.put('h', 7);
      letterMap.put('i', 8);
      letterMap.put('j', 9);
      letterMap.put('k', 10);
      letterMap.put('l', 11);
      letterMap.put('m', 12);
      letterMap.put('n', 13);
      letterMap.put('o', 14);
      letterMap.put('p', 15);
      letterMap.put('q', 16);
      letterMap.put('r', 17);
      letterMap.put('s', 18);
      letterMap.put('t', 19);
      letterMap.put('u', 20);
      letterMap.put('v', 21);
      letterMap.put('w', 22);
      letterMap.put('x', 23);
      letterMap.put('y', 24);
      letterMap.put('z', 25);
      reverseLetterMap.put(0, 'a');
      reverseLetterMap.put(1, 'b');
      reverseLetterMap.put(2, 'c');
      reverseLetterMap.put(3, 'd');
      reverseLetterMap.put(4, 'e');
      reverseLetterMap.put(5, 'f');
      reverseLetterMap.put(6, 'g');
      reverseLetterMap.put(7, 'h');
      reverseLetterMap.put(8, 'i');
      reverseLetterMap.put(9, 'j');
      reverseLetterMap.put(10, 'k');
      reverseLetterMap.put(11, 'l');
      reverseLetterMap.put(12, 'm');
      reverseLetterMap.put(13, 'n');
      reverseLetterMap.put(14, 'o');
      reverseLetterMap.put(15, 'p');
      reverseLetterMap.put(16, 'q');
      reverseLetterMap.put(17, 'r');
      reverseLetterMap.put(18, 's');
      reverseLetterMap.put(19, 't');
      reverseLetterMap.put(20, 'u');
      reverseLetterMap.put(21, 'v');
      reverseLetterMap.put(22, 'w');
      reverseLetterMap.put(23, 'x');
      reverseLetterMap.put(24, 'y');
      reverseLetterMap.put(25, 'z');
   }
   
   public SpellCorrector() {
      CreateLetterMaps();   
   }
   
   public class WordWithCount {
      public String word;
      public int count;
      
      public WordWithCount(String word, int count) {
         this.word = word;
         this.count = count;
      }
   }
   
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
   public String suggestSimilarWord(String inputWord) {
      if (dictionary.find(inputWord) != null) {
         return inputWord.toLowerCase();
      }
      
      ArrayList<String> distanceOneEdits = new ArrayList<String>();
      ArrayList<String> distanceTwoEdits = new ArrayList<String>();
      String suggestion = new String();
      
      distanceOneEdits.addAll(GetPossibleDeletions(inputWord));
      distanceOneEdits.addAll(GetPossibleTranspositions(inputWord));
      distanceOneEdits.addAll(GetPossibleAlterations(inputWord));
      distanceOneEdits.addAll(GetPossibleInsertions(inputWord));
      
      for (int i = 0; i < distanceOneEdits.size(); ++i) {
         distanceTwoEdits.addAll(GetPossibleDeletions(distanceOneEdits.get(i)));
         distanceTwoEdits.addAll(GetPossibleTranspositions(distanceOneEdits.get(i)));
         distanceTwoEdits.addAll(GetPossibleAlterations(distanceOneEdits.get(i)));
         distanceTwoEdits.addAll(GetPossibleInsertions(distanceOneEdits.get(i)));
      }
      
      ArrayList<WordWithCount> distanceOneSuggestions = GetSuggestions(distanceOneEdits);
      ArrayList<WordWithCount> distanceTwoSuggestions = GetSuggestions(distanceTwoEdits);
      
      if (distanceOneSuggestions.size() == 0 && distanceTwoSuggestions.size() == 0) {
         return null;
      }
      else if (distanceOneSuggestions.size() > 0) {
         suggestion = distanceOneSuggestions.get(0).word;
         for (int i = 1; i < distanceOneSuggestions.size(); ++i) {
            if (suggestion.compareToIgnoreCase(distanceOneSuggestions.get(i).word) > 0) {
               suggestion = distanceOneSuggestions.get(i).word;
            }
         }
      }
      else {
         suggestion = distanceTwoSuggestions.get(0).word;
         for (int i = 1; i < distanceTwoSuggestions.size(); ++i) {
            if (suggestion.compareToIgnoreCase(distanceTwoSuggestions.get(i).word) > 0) {
               suggestion = distanceTwoSuggestions.get(i).word;
            }
         }
      }
      
      return suggestion;
   }
   
   public ArrayList<WordWithCount> GetSuggestions(ArrayList<String> edits) {
      int maxCount = 0;
      ArrayList<WordWithCount> suggestions = new ArrayList<WordWithCount>();
      
      for (int i = 0; i < edits.size(); ++i) {
         Trie.Node node = (Trie.Node) dictionary.find(edits.get(i));
         if (node != null) {
            if (node.getValue() > maxCount) {
               maxCount = node.getValue();
               suggestions.clear();
               suggestions.add(new WordWithCount(edits.get(i), node.getValue()));
            }
            else if (node.getValue() == maxCount) {
               suggestions.add(new WordWithCount(edits.get(i), node.getValue()));
            }
         }
      }
      
      return suggestions;
   }
   
   public ArrayList<String> GetPossibleDeletions(String word) {
      ArrayList<String> result = new ArrayList<String>();
      
      for (int i = 0; i < word.length(); ++i) {
         StringBuilder copy = new StringBuilder(word);
         result.add(copy.deleteCharAt(i).toString());
      }
      
      return result;
   }
   
   public ArrayList<String> GetPossibleTranspositions(String word) {
      ArrayList<String> result = new ArrayList<String>();
      
      for (int i = 0; i < word.length() - 1; ++i) {
         StringBuilder copy = new StringBuilder(word);
         copy.deleteCharAt(i);
         copy.insert(i + 1, word.charAt(i));
         result.add(copy.toString());
      }
      
      return result;
   }
   
   public ArrayList<String> GetPossibleAlterations(String word) {
      word = word.toLowerCase();
      ArrayList<String> result = new ArrayList<String>();
      
      for (int i = 0; i < word.length(); ++i) {
         for (int j = 0; j < 26; ++j) {
            StringBuilder copy = new StringBuilder(word);
            if (j != letterMap.get(word.charAt(i))) {
               copy.setCharAt(i, reverseLetterMap.get(j));
               result.add(copy.toString());
            }
         }
      }
      
      return result;
   }
   
   public ArrayList<String> GetPossibleInsertions(String word) {
      ArrayList<String> result = new ArrayList<String>();
      
      for (int i = 0; i < word.length(); ++i) {
         for (int j = 0; j < 26; ++j) {
            StringBuilder copy = new StringBuilder(word);
            copy.insert(i, reverseLetterMap.get(j));
            result.add(copy.toString());
         }
      }
      
      for (int i = 0; i < 26; ++i) {
         StringBuilder copy = new StringBuilder(word);
         copy.append(reverseLetterMap.get(i));
         result.add(copy.toString());
      }
      
      return result;
   }
}