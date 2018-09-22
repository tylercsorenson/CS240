package spell;

import java.util.*;

public class Trie implements ITrie {
   private Node root = new Node();
   private HashMap<Character, Integer> letterMap;
   
   //Constructor at bottom of class, simply creates the letterMap

	/**
	 * Adds the specified word to the trie (if necessary) and increments the word's frequency count
	 * 
	 * @param word The word being added to the trie
	 */
	public void add(String word) { //FIXME
      char[] characters = word.toCharArray();
      
      for (int i = 0; i < characters.length; ++i) {
         characters[i] = Character.toLowerCase(characters[i]);
         
      }
   }
	
	/**
	 * Searches the trie for the specified word
	 * 
	 * @param word The word being searched for
	 * 
	 * @return A reference to the trie node that represents the word,
	 * 			or null if the word is not in the trie
	 */
	// public ITrie.INode find(String word) { //FIXME
   // 
   // }
	
	/**
	 * Returns the number of unique words in the trie
	 * 
	 * @return The number of unique words in the trie
	 */
	// public int getWordCount() { //FIXME
   // 
   // }
	
	/**
	 * Returns the number of nodes in the trie
	 * 
	 * @return The number of nodes in the trie
	 */
	// public int getNodeCount() { //FIXME
   // 
   // }
	
	/**
	 * The toString specification is as follows:
	 * For each word, in alphabetical order:
	 * <word>\n
	 */
	// @Override
	// public String toString() { //FIXME
   // 
   // }
	
	// @Override
	// public int hashCode() { //FIXME
   // 
   // }
	
	// @Override
	// public boolean equals(Object o) { //FIXME
   // 
   // }
   
	public class Node implements ITrie.INode {
      private Node[] nodes = new Node[26]; 
      private int count = 0;
      
      public Node() {}
         
      public void IncrementCount() {
         count++;
      }
	
		/**
		 * Returns the frequency count for the word represented by the node
		 * 
		 * @return The frequency count for the word represented by the node
		 */
		public int getValue() {
         return count;
      }
	}
   
   private void CreateLetterMap() {
      letterMap = new HashMap<Character, Integer>();
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
   }
   
   public Trie() {
      CreateLetterMap();
   }
}