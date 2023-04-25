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
        insert(keys);
//        for (int i = 0; i < keys.length; i++) {
//            System.out.println("inserting:"+keys[i]);
//            insert(keys[i]);
//            if (search("68") == true) {
//                System.out.println("the --- " + output[1]);
//            }
//
//        }

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

    static void insert(String[] keys) {
        // System.out.println("insert");
        for(String key: keys) {
            int index;

            TrieNode pCrawl = root;
            for (level = 0; level < key.length(); level++)
            {
                index = Character.digit(key.charAt(level),16);
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();
                if(pCrawl.children[index] != null) {
                    pCrawl = pCrawl.children[index];
                }
                System.out.println("index is "+index);

                System.out.println("child check"+key);
            }
            //stops here
            System.out.println("approaching end");
            // mark last node as leaf
            pCrawl.isEndOfWord = true;
            System.out.println(pCrawl.isEndOfWord);
            System.out.println("we are at the end of insert");
        }

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

        System.out.println("search called");
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (int i = 0; i < key.length();i++) {
            if (level < length) {
                // call ascii method
                //String let = hexToAscii(letter);
                // convert to lower case
                //let.toLowerCase();
                index = Character.digit(key.charAt(i), 16);
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
