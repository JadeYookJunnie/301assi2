import org.w3c.dom.Node;
import java.util.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.Position;

public class Trie {
    static int level = 0;
    public static List<Integer> phraseNumber = new ArrayList<Integer>();
    public static List<String> value = new ArrayList<String>();
    // 0-9 a-f 14
    static final int SYMBOL_SIZE = 256;
    // array of hex values
    public static String[] keys;
    public static List<String> output = new ArrayList<>();

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
        System.out.println("hello");
        String out[] = { "Not present in trie", "Present in trie" };
        root = new TrieNode();

        // System.out.println("this is key lengh" + keys.length);
        insert(keys);
        System.out.println("back");
        System.out.println(output.size());
        //not returning

        String _out[] = output.toArray(new String[output.size()]);
        for(int i =0; i <= phraseNumber.size(); i++) {
            String myvariable  =  phraseNumber.get(i) + "," + value.get(index);
            System.out.println(myvariable);
            output.add(myvariable);
        }
        LZdecoding decoder = new LZdecoding(_out);

        // Search for different keys
//        for (String s : keys) {
//            // System.out.println(s);
//            if (search(s) == true)
//                System.out.println(s + " " + out[1]);
//            else
//                System.out.println(s + " " + out[0]);
//        }

    }

    static int index = 0;
    static TrieNode root;
    static int order = 1;

    static void insert(String[] key) {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean InWord;
        TrieNode pCrawl = root;

        // for (String letter : keys) {
        for (int i = 0; i < keys.length; i++) {
            InWord = search(keys[i]);

            if (InWord == true) {

                // ArrayList<String> path = new ArrayList<String>();
                // traverse
                int length = keys.length;
                int index;
                int prev;
                index = hexToNumeric(keys[i]);
                prev = pCrawl.children[index].order;
                for (level = 0; level < length; level++) {
                    prev = hexToNumeric(keys[i]);

                    // System.out.println("this is the indexs"+index);
                    if (pCrawl.children[index] == null) {
                        // insert a new node
                        pCrawl.children[index] = new TrieNode();
                        pCrawl.children[index].phrase = pCrawl.phrase;//level;
                        pCrawl.children[index].val = keys[i];
                        pCrawl.children[index].order = order;
                        pCrawl.isEndOfWord = true;
                        // adding to list
                        int phase = pCrawl.children[index].phrase;
                        phraseNumber.add(phase);
                        //convert to bits
                        value.add(hexToBits(keys[i]));
                        String toWrite = pCrawl.phrase + "," + keys[i];
                        System.out.println("writing"+toWrite);
                        output.add(toWrite);
//                        try {
//                            writer.write(toWrite);
//                            writer.newLine();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
                        System.out.println("output: " + pCrawl.phrase + " " + keys[i]);
                        // pCrawl = root;// maybe
                        order++;
                        break;
                    }
                    i++;
                    // prev = pCrawl.children[index].phrase;
                    index = hexToNumeric(keys[i]);
                    pCrawl = pCrawl.children[index];
                    //pCrawl.isEndOfWord = true;
                    // position++;
                }
                // reset
                pCrawl = root;

            }
            if (InWord == false) {
                index = hexToNumeric(keys[i]);
                pCrawl.children[index] = new TrieNode();
                pCrawl.children[index].phrase = level;// positon
                pCrawl.children[index].val = keys[i];
                pCrawl.children[index].order = order;
                // adding to list
                int phase = pCrawl.children[index].phrase;
                phraseNumber.add(phase);
                //convert to bits
                value.add(hexToBits(keys[i]));
                //System.out.println(value);
                //System.out.println(phraseNumber);

                // need to get parent phrase
                int outPhr = pCrawl.children[index].phrase;
                String toWrite = phase + ","+value;
                output.add(toWrite);
//                try {
//                    writer.write(toWrite);
//                    writer.newLine();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println("output: " + pCrawl.children[index].phrase + " " + keys[i]);
                // pCrawl = pCrawl.children[index];
                pCrawl = root;
                order++;
                pCrawl.isEndOfWord = true;
            }

        }
        // System.out.println("this is level" + level);
        if (level == keys.length) {
            add = true;
        }
        // System.out.println("values" + value);
        // System.out.println("phrases" + phraseNumber);

    }

    public static int hexToNumeric(String hex) {
        // int conv = 0;
        int te = Integer.parseInt(hex, 16);
        return te;
    }


    static boolean search(String key) {
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        index = hexToNumeric(key);

        if (pCrawl.children[index] != null)
            return true;
        return false;

    }

    public static String hexToBits(String hex){
        int decimal = Integer.parseInt(hex, 16); // convert to decimal
        String binary = Integer.toBinaryString(decimal); // convert to binary string
       // System.out.println(binary); // output the binary representation
        return binary;
    }
}