import org.w3c.dom.Node;

public class Trie {
    static int level = 0;
    // 0-9 a-f 14
    static final int SYMBOL_SIZE = 27;
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
        int posistion;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < SYMBOL_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static boolean add = false;
    static int added = 0;

    public static void main(String args[]) {
        System.out.println("main");
        String output[] = { "Not present in trie", "Present in trie" };
        root = new TrieNode();

        System.out.println("this is key lengh" + keys.length);
        insert(keys);

        // Search for different keys
        if (search("68") == true)
            System.out.println("hello --- " + output[1]);
        else
            System.out.println("hello --- " + output[0]);

    }

    static int position = 0;
    static int index = 0;
    static TrieNode root;
    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node

    static void insert(String[] key) {
        boolean InWord;
        TrieNode pCrawl = root;
        String totalIndex = null;
        // for (String letter : keys) {
        for (int i = 0; i < keys.length; i++) {
            InWord = search(keys[i]);
            if (InWord == true) {
                if (keys[i + 1] == null) {
                    break;
                }
                // group letters togther
                index = hexToNumeric(keys[i + 1]);
                index = hexToNumeric(keys[i]);

                String one = String.valueOf(index);
                int indexOne = index;

                String two = String.valueOf(index);
                totalIndex = one + "," + two;
                System.out.println(totalIndex);
                // should be key nots keys i think
                int length = keys.length;
                for (level = 0; level < length; level++) {
                    if (pCrawl.children[indexOne] != null) {
                        pCrawl.children[indexOne] = new TrieNode();
                        pCrawl = pCrawl.children[index];
                        level++;
                        System.out.println("we have inserted a child");
                    }
                }

            } // add individual letters to trie
            if (InWord == false) {
                if (level < keys.length) {
                    // call hexto numeric method
                    index = hexToNumeric(keys[i]);
                    // get index position
                    System.out.println("index" + index);
                    if (pCrawl.children[index] == null)
                        pCrawl.children[index] = new TrieNode();
                    pCrawl = pCrawl.children[index];
                    level++;
                }
            }
            position++;
            System.out.println("pos" + position);
            InWord = false;
            // mark last node as leaf
            pCrawl.isEndOfWord = true;
        }
        System.out.println("this is level" + level);
        if (level == keys.length) {
            add = true;
        }
    }

    // converts hex to ascii and returns string// replace with int character.digit
    // //add phrase number to node
    public static int hexToNumeric(String hex) {
        int conv = 0;
        for (int i = 0; i < hex.length(); i += 1) {
            conv += Character.digit(hex.charAt(i), 16);
        }
        System.out.println(conv + "this is cov");
        return conv;
    }

    // returns true if key presents in trie, else false
    static boolean search(String key) {

        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        // check for start
        if (root == null) {
            return false;
        }
        for (level = 0; level < length; level++) {
            index = hexToNumeric(key);
            if (pCrawl.children[index] == null)
                return false;

            if (pCrawl.children[index] != null)
                return true;
        }
        return (pCrawl.isEndOfWord);
    }
}
