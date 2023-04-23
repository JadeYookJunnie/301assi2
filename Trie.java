public class Trie {
    static int level = 0;
    // 0-9 a-f 14
    static final int SYMBOL_SIZE = 14;
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

        for (int i = 0; i < keys.length; i++) {
            System.out.println("key" + keys[i]);
        }

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

    }

    static TrieNode root;
    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node

    static void insert(String key) {
        // System.out.println("insert");

        int index;

        TrieNode pCrawl = root;
        for (String letter : keys) {
            if (level < keys.length) {
                // call ascii method
                String let = hexToAscii(letter);
                // minus the ascii value
                index = let.charAt(0) - 'a';
                // index = Integer.parseInt(letter) - 61;
                System.out.println("index" + index);
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();

                pCrawl = pCrawl.children[index];
                level++;
            }
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
        System.out.println("we are at the end of insert");
    }

    // converts hex to ascii and returns string
    public static String hexToAscii(String hex) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }

    // returns true if key presents in trie, else false
    static boolean search(String key) {

        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (String letter : keys) {
            if (level < length) {
                // call ascii method
                String let = hexToAscii(letter);
                index = let.charAt(0) - 'a';
                // index = Integer.parseInt(letter) - 61;
                if (pCrawl.children[index] == null)
                    return false;
                pCrawl = pCrawl.children[index];
                level++;
            }
        }

        return (pCrawl.isEndOfWord);
    }
    // Driver

}
