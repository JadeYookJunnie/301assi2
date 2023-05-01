import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LZencode {
    public static void main(String[] args) {
        //create pair array

        try{
            int pointer = 1;
            //String test = "aabc";
            String test = "ababaaabb";
            //String test = "abracadabra";
            byte[] argument = test.getBytes();
            InputStream isr = new ByteArrayInputStream(argument);
            byte[] byteArray = isr.readAllBytes();
            translator(byteArray);
        }
        catch(Exception e){
            e.getStackTrace();
        }

    }
    //byte to hex translator
    public static void translator(byte[] bytes){
        List<String> translated = new ArrayList<String>();
        for(byte b: bytes) {
            String st = String.format("%02X", b);
            translated.add(st);
            System.out.println(st);
        }
        //translated.toArray();
        Trie trie = new Trie(translated.toArray(new String[translated.size()]));

    }

}
