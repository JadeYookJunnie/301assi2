import org.w3c.dom.Node;

public class Trie {
    static int level = 0;
    // 0-9 a-f 14
    static final int SYMBOL_SIZE = 127;
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
        int phrase;
        String val;
        int order;

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
        String output[] = { "Not present in trie", "Present in trie" };
        root = new TrieNode();

        // System.out.println("this is key lengh" + keys.length);
        insert(keys);

        // Search for different keys
        for (String s : keys) {
            // System.out.println(s);
            if (search(s) == true)
                System.out.println(s + " " + output[1]);
            else
                System.out.println(s + " " + output[0]);
        }

    }

    static int position = 0;
    static int index = 0;
    static TrieNode root;
    static int order = 1;

    static void insert(String[] key) {
        boolean InWord;
        TrieNode pCrawl = root;

        // for (String letter : keys) {
        for (int i = 0; i < keys.length; i++) {
            InWord = search(keys[i]);

            if (InWord == true) {
                // index = hex to new meic
                // position = phrase
                // order

                // get previndex position of current key
                index = hexToNumeric(keys[i]);
                int prevOrder = pCrawl.children[index].order;
                // pCrawl.isEndOfWord = true;
                i++;
                index = hexToNumeric(keys[i]);
                pCrawl.children[index] = new TrieNode();
                pCrawl.children[index].phrase = prevOrder;
                // System.out.println(pCrawl.children[index].phrase);
                pCrawl.children[index].val = keys[i];
                pCrawl.children[index].order = order;
                System.out.println("output: " + pCrawl.children[index].phrase + " " + keys[i]);
                // reset
                pCrawl = root;

            }
            if (InWord == false) {
                index = hexToNumeric(keys[i]);
                pCrawl.children[index] = new TrieNode();
                pCrawl.children[index].phrase = 0;// positon
                pCrawl.children[index].val = keys[i];
                pCrawl.children[index].order = order;
                // need to get parent phrase
                System.out.println("output: " + pCrawl.children[index].phrase + " " + keys[i]);
                position++;// might need to remove
                pCrawl = root;
                level++;

            }
            order++;
            pCrawl.isEndOfWord = true;
        }
        // System.out.println("this is level" + level);
        if (level == keys.length) {
            add = true;
        }
    }

    public static int hexToNumeric(String hex) {
        // int conv = 0;
        int te = Integer.parseInt(hex, 16);
        return te;
    }

    // returns true if key presents in trie, else false
    // change
    static boolean search(String key) {
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        index = hexToNumeric(key);
        // need away to loop through phrases
        if (pCrawl.children[index] != null)
            return true;
        return false;

    }
}