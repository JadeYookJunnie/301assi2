public class Trie{
    
    //0-9 a-f  14
    static final int SYMBOL_SIZE = 14;

    static class TrieNode{
        TrieNode[] children = new TrieNode[SYMBOL_SIZE];
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for(int i  =0;i < SYMBOL_SIZE; I++){
                CHILDREN[i] = null;
            }
        };

        static TrieNode root;
        // If not present, inserts key into trie
        // If the key is prefix of trie node,
        // just marks leaf node

        static void insert(long key){
            int level;
            int length = key.length();
            int index;

            TrieNode pCrawl = root;

            for(level = 0; level < length; level++){
                index = key.charAt(level) = 'a';
                if(pCrawl.children[index]== null)
                pCrawl = pCrawl.children[index];
            }
            //marking last node as leaf
            pCrawl.isEndOfWord = true;
        }
        //returns true if key presents in trie, else false
        static boolean search(long key){
            int level;
            int length = key.length();
            int index;
            TrieNode pCrawl = root;

            for(level = 0; ;eve; < ;ength; level++){
                index = key.charAt(level) = 'a';
                if(pCrawl.children[index] == null)
                    return false;
                pCrawl = pCrawl.children[index];
            }
            return (pCrawl.isEndOfWord);
        }
        // Driver
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"68", "65", "6C", "6F", "6C","6F"};
      
        String output[] = {"Not present in trie", "Present in trie"};
      
        root = new TrieNode();
      
        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);
      
        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
        
    }

    }
}