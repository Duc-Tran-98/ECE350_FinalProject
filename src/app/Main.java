package app;

import java.util.*;

public class Main {

    public static List<String> Messages = new ArrayList<>();

    public static void main(String[] args){
        var q = Integer.toBinaryString('q');
        var w = Integer.toBinaryString('w');
        var e = Integer.toBinaryString('e');
        var space = Integer.toBinaryString(' ');
        //System.out.println(q + " : " + w + " : " + e + " : " + space);
        Encoder encoder = new Encoder();
        String coded = encoder.encodeString("qwe");
        for (int i = 0; i < coded.length(); i+=13){
            System.out.println(coded.substring(i, i+13));
        }
    }

}