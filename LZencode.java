import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LZencode {
    public static void main(String[] args) {
        // create pair array

        try {
            String filename = args[0];
            byte[] argument = null;
            try {
                File file = new File(filename);
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    argument = line.getBytes();
                   // System.out.println(line);
                }
                InputStream isr = new ByteArrayInputStream(argument);
                byte[] byteArray = isr.readAllBytes();
                translator(byteArray);

                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }

            // String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            //String input = "ababaaabb";
            // String input = "abracadabra";

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    // byte to hex translator
    public static void translator(byte[] bytes) {
        System.out.println("start");
        List<String> translated = new ArrayList<String>();
        for (byte b : bytes) {
            String st = String.format("%02X", b);
            translated.add(st);
            // System.out.println(st);
        }
        // translated.toArray();
        Trie trie = new Trie(translated.toArray(new String[translated.size()]));
    }

}
