import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LZdecoding {
    public static int index = 1;
    public static List<Integer> phraseNumber = new ArrayList<Integer>();
    public static List<String> value = new ArrayList<String>();

    public static void main(String[] args) {

        // String[] testarray = { "0,a", "1,b", "0,b", "2,b" };
        // String[] testarray = { "0,a", "0,b", "0,r", "1,c", "1,d", "1,b", "3,a" };
        String[] testarray = { "0,a", "0,b", "1,b", "1,a", "3,b" };
        enterdata(testarray);

    }

    public static void enterdata(String[] testarray) {

        for (int i = 0; i < testarray.length; i++) {
            String[] parts = testarray[i].split(",", 2);
            String phraseword = parts[0];
            int phrasewordNum = Integer.parseInt(phraseword);
            String val = parts[1];
            // System.out.println("index" + phraseword);
            // System.out.println("value" + value);
            phraseNumber.add(phrasewordNum);
            value.add(val);
        }
        System.out.println(phraseNumber);
        System.out.println(value);
        decode();
    }

    public static void decode() {
        ArrayList<String> output = new ArrayList<String>();
        // current = current location of decode
        int phraselocation = 1;

        // main loop
        for (int current = 0; current < phraseNumber.size(); current++) {
            if (phraseNumber.get(current) == 0) {
                output.add(value.get(current));
            }

            // add values that are connected together
            if (phraseNumber.get(current) != 0) {
                ArrayList<Integer> path = new ArrayList<Integer>();
                // phraselocation location of phrase
                int x = 0;
                phraselocation = phraseNumber.get(current);
                path.add(phraselocation);
                // be able to add more to path
                while (phraselocation != 0) {
                    int num = path.get(x);
                    // System.out.println("this is num" + num);
                    phraselocation = phraseNumber.get(num - 1);
                    // System.out.println("this is phraselocation: " + phraselocation);
                    if (phraselocation == 0) {
                        // output.add(value.get(phraselocation));
                        output.add(value.get(num - 1));
                        break;
                    }
                    path.add(phraselocation);
                    x++;
                }

                for (int i = path.size() - 2; i >= 0; i--) {
                    int index = path.get(i);
                    String val = value.get(index - 1);
                    output.add(val);
                }
                output.add(value.get(current));
            }
        }
        System.out.println("this is output" + output);
    }

}