import java.io.*;
public class LZencode {
    public static void main(String[] args) {



        try{
            int pointer = 1;
            byte[] argument = args[0].getBytes();
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
        for(byte b: bytes) {
            String st = String.format("%02X", b);
            System.out.println(st);
        }

    }

}
