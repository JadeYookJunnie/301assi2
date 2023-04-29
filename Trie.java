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

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < SYMBOL_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static boolean add = false;
    static int added = 0;

    public static void test() {
        TrieNode node = root;
        for(String s: keys) {
//            if(node.children.includes(s)) {
//                //go into child of curchar
//            }
//            else {
//
//            }
        }

    }


    public static void main(String args[]) {
        String output[] = { "Not present in trie", "Present in trie" };
        root = new TrieNode();

        System.out.println("this is key lengh" + keys.length);
        insert(keys);

        // Search for different keys
        for(String s: keys) {
            System.out.println(s);
            if (search(s) == true)
                System.out.println(s + " "+ output[1]);
            else
                System.out.println(s + " "+ output[0]);
        }
//        if (search("68") == true)
//            System.out.println("hello --- " + output[1]);
//        else
//            System.out.println("hello --- " + output[0]);

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
//            if(root.children[i] == null) {
//                InWord = false;
//            } else {
//                level++;
//                index = hexToNumeric(keys[i]);
//                if (pCrawl.children[index] == null)
//                    InWord = false;
//
//                if (pCrawl.children[index] != null)
//                    InWord = true;
//            }

            System.out.println("in word"+InWord);
            if (InWord == true) {
                //cannot break here
                //break;
                System.out.println("hello world");
//                if (keys[i + 1] == null) {
//                    break;
//                }
                // group letters togther
                //index = hexToNumeric(keys[i + 1]);
                //set current to this key's node
                index = hexToNumeric(keys[i]);
                pCrawl = pCrawl.children[index];


//                String one = String.valueOf(index);
//                int indexOne = index;
//
//                String two = String.valueOf(index);
//                totalIndex = one + "," + two;
//                System.out.println(totalIndex);
//                // should be key nots keys i think
//                int length = keys.length;
//                for (level = 0; level < length; level++) {// else move down
//                    if (pCrawl.children[indexOne] != null) {
//                        // add one to level
//
//                        // if(null add character)
////                        while(pCrawl.children[index] != null) {
////                            level++;
////                        }
//
//
//                        // pCrawl.children[indexOne] = new TrieNode();
//                        // pCrawl = pCrawl.children[index];
//                        level++;
//                        //System.out.println("we have inserted a child");
//                    }
//                    pCrawl.children[index] = new TrieNode();
//                }

            } // add individual letters to trie
            if (InWord == false) {
//                int prevIndex = 0;
//                int tryPrev = hexToNumeric(keys[i-1]);
//                if(tryPrev > 0) {
//                    prevIndex = tryPrev;
//                }
                index = hexToNumeric(keys[i]);
                pCrawl.children[index] = new TrieNode();
                pCrawl.children[index].phrase = position;
                pCrawl.children[index].val = keys[i];
                System.out.println("output: "+pCrawl.phrase + " "+keys[i]);
                position++;
                pCrawl = root;
                System.out.println(pCrawl.val);
                level++;
//                if (level < keys.length) {
//                    // call hexto numeric method
//                    index = hexToNumeric(keys[i]);
//                    System.out.println("this is index: " + index);
//                    if (pCrawl.children[index] == null)
//                        pCrawl.children[index] = new TrieNode();
//                    pCrawl = pCrawl.children[index];
//                    level++;
//                }
            }
            //position++;
            System.out.println("pos: " + position);
            //InWord = false;
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

    // a = 61 6+1 = 7
    // p = 70 7+0 = 7
    // public static int hexToNumeric(String hex) {
    // int conv = 0;
    // for (int y = 0; y < hex.length(); y += 1) {
    // conv += Character.digit(hex.charAt(y), 16);
    // }
    // return conv;
    // }
    public static int hexToNumeric(String hex) {
        // int conv = 0;
        int te = Integer.parseInt(hex, 16);
        return te;
    }

    // returns true if key presents in trie, else false
    static boolean search(String key) {

        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        // check for start
//        if (root == null) {
//            return false;
//        }
//        for(TrieNode child: root.children) {
//            for(TrieNode leaf: child.children) {
//                System.out.println(leaf);
//            }
//        }
        for (level = 0; level < length; level++) {
            //System.out.println("keyl"+key+length);
            index = hexToNumeric(key);
            if (pCrawl.children[index] != null)
                return true;

//            else
//                return false;
        }
        return false;
        //return (pCrawl.isEndOfWord);
    }
}
