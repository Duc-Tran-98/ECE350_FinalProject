package app;

import java.util.*;

public class Main {

    public static List<String> Messages = new ArrayList<>();

    //00001100110000100111000101000001100110000000110011000110111001111101010100000010001110111011100011101001101010100000011100110111101110111010001100011101110101001110001011010101000000001011100100111100111000111010101000000011011001010010100111001010000111000011

    public static void main(String[] args){
        Encoder encoder = new Encoder();
        String coded = encoder.encodeString("Hello");
        //System.out.println(coded);
        // for (int i = 0; i < coded.length(); i+=13){
        //     System.out.println(coded.substring(i, i+13));
        // }
        Decoder decoder = new Decoder();
        String message = "0000110011111";
        String decoded = decoder.decodeMessage(message);
        System.out.println(decoded);
    }

}