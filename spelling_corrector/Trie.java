package spell;

import java.util.*;

public class Trie implements ITrie {
   private Node root = new Node();
   private HashMap<Character, Integer> letterMap;
   private HashMap<Integer, Character> reverseLetterMap;
   private int numNodes = 1;
   private int numWords = 0;
   
   //Constructor at bottom of class, simply creates the letterMap

	/**
	 * Adds the specified word to the trie (if necessary) and increments the word's frequency count
	 * 
	 * @param word The word being added to the trie
	 */
	public void add(String word) {
      char[] characters = word.toCharArray();
      Node currentNode = root;
      
      for (int i = 0; i < characters.length; ++i) {
         characters[i] = Character.toLowerCase(characters[i]);
         
         if (currentNode.nodes[letterMap.get(characters[i])] == null) {
            currentNode.nodes[letterMap.get(characters[i])] = new Node();
            currentNode = currentNode.nodes[letterMap.get(characters[i])];
            currentNode.SetLetter(Character.toString(characters[i]));
            numNodes++;
         }
         
         else {
            currentNode = currentNode.nodes[letterMap.get(characters[i])];
         }
         
         if (i == characters.length - 1) {
            currentNode.IncrementCount();
            numWords++;
         }
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
	public ITrie.INode find(String word) { //FIXME
      char[] characters = word.toCharArray();
      Node currentNode = root;
      
      for (int i = 0; i < characters.length; ++i) {
         if (currentNode.nodes[letterMap.get(characters[i])] == null) {
            return null;
         }
         currentNode = currentNode.nodes[letterMap.get(characters[i])];
      }
      return currentNode;
   }
	
	/**
	 * Returns the number of unique words in the trie
	 * 
	 * @return The number of unique words in the trie
	 */
	public int getWordCount() {
      return numWords;
   }
	
	/**
	 * Returns the number of nodes in the trie
	 * 
	 * @return The number of nodes in the trie
	 */
	public int getNodeCount() {
      return numNodes;
   }
   
   public Node GetRoot() {
      return root;
   }
	
	/**
	 * The toString specification is as follows:
	 * For each word, in alphabetical order:
	 * <word>\n
	 */
	@Override
	public String toString() {
      StringBuilder string = new StringBuilder();
      StringBuilder currentPath = new StringBuilder();
      root.AddNextWord(string, currentPath);
      
      return string.toString();
   }
	
	@Override
	public int hashCode() {
      StringBuilder hashInput = new StringBuilder();
      hashInput.append(root.GetHashString());
      return hashInput.toString().hashCode();
   }
	
	@Override
	public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      
      if (!(o instanceof Trie)) {
         return false;
      }
      
      Trie trie = (Trie) o;
      
      if (!this.GetRoot().equals(trie.GetRoot())) {
         return false;
      }
      return true;
   }
   
	public class Node implements ITrie.INode {
      public Node[] nodes = new Node[26]; 
      private int count = 0;
      
      public Node() {}
      
      public String GetHashString() {
         StringBuilder hashString = new StringBuilder();
         hashString.append(this.count);
         
         for (int i = 0; i < 26; ++i) {
            if (this.nodes[i] == null) {
               continue;
            }
            hashString.append(reverseLetterMap.get(i));
            hashString.append(this.nodes[i].GetHashString());
         }
         return hashString.toString();
      }
      
      public void AddNextWord(StringBuilder string, StringBuilder currentPath) {
         if (count > 0) {
            string.append(currentPath);
            string.append("\n");
         }
         
         for (int i = 0; i < 26; ++i) {
            if (this.nodes[i] != null) {
               currentPath.append(reverseLetterMap.get(i));
               this.nodes[i].AddNextWord(string, currentPath);
            }
         }
         
         if (currentPath.length() > 0) {
            currentPath.deleteCharAt(currentPath.length() - 1);
         }
      } 
      
      //*****************************************
      private String letter = "N/A";
      public void SetLetter(String letter) {
         this.letter = letter;
      }
      public String GetLetter() {
         return letter;
      }
      public void PrintNode() {
         System.out.println(letter + ": " + count);
         for (int i = 0; i < nodes.length; ++i) {
            if (nodes[i] != null) {
               System.out.println(nodes[i].GetLetter() + ": " + nodes[i].getValue());
            }
         }
         System.out.println("\n");
      }
      //*****************************************
         
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
      
      @Override
      public boolean equals(Object o) {
         if (o == this) {
            return true;
         }
         
         if (!(o instanceof Node)) {
            return false;
         }
         
         Node node = (Node) o;
         
         if (this.count != node.getValue()) {
            return false;
         }
         
         if (this.nodes.length != node.nodes.length) {
            return false;
         }
         
         for (int i = 0; i < this.nodes.length; i++) {
            if (this.nodes[i] == null && node.nodes[i] == null) {
               continue;
            }
            if (!this.nodes[i].equals(node.nodes[i])) {
               return false;
            }
         }
         return true;
      }
	}
   
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
   
   public Trie() {
      CreateLetterMaps();
      
      //*****************************************
      root.SetLetter("root");
      //*****************************************
   }
}