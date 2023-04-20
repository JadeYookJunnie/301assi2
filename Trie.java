public class Trie {

    // 0-9 a-f 14
    static final int SYMBOL_SIZE = 26;
    // array of hex values
    public static String[] keys;

    public Trie(String[] _input) {
        keys = _input;
        // System.out.println("done");
        main(null);
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[SYMBOL_SIZE];
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < SYMBOL_SIZE; i++) {
                children[i] = null;
            }
        }

        ;
    }

    public static void main(String args[]) {
        System.out.println("main");
        // Input keys (use only 'a' through 'z' and lower case)
        // conversion error
        // String keys[] = {"hello"};

        String output[] = { "Not present in trie", "Present in trie" };

        root = new TrieNode();

        // Construct trie
        // from here
        // System.out.println(keys.length);
        // only called once

        System.out.println("this is key lengh" + keys.length);
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i]);
            insert(keys[i]);
        }

        // Search for different keys
        if (search("68") == true)
            System.out.println("the --- " + output[1]);
        else
            System.out.println("the --- " + output[0]);
        //
        // if(search("these") == true)
        // System.out.println("these --- " + output[1]);
        // else System.out.println("these --- " + output[0]);
        //
        // if(search("their") == true)
        // System.out.println("their --- " + output[1]);
        // else System.out.println("their --- " + output[0]);
        //
        // if(search("thaw") == true)
        // System.out.println("thaw --- " + output[1]);
        // else System.out.println("thaw --- " + output[0]);

    }

    static TrieNode root;
    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node

    static void insert(String key) {
        System.out.println("insert");

        int index;

        TrieNode pCrawl = root;
        System.out.println("we made it to for loop");
        for (int level = 0; level < key.length(); level++) {
            // get the 2 numbers
            char one = key.charAt(level);
            char two = key.charAt((level + 1));
            // concatnate them into a single value
            String letter = String.valueOf(one) + two;
            System.out.println("letter" + letter);
            // minus the ascii value
            index = Integer.parseInt(letter) - 61;
            System.out.println("index" + index);
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // returns true if key presents in trie, else false
    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {

            char one = key.charAt(level);
            char two = key.charAt((level + 1));
            String letter = String.valueOf(one) + two;
            index = Integer.parseInt(letter) - 61;
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl.isEndOfWord);
    }
    // Driver

}