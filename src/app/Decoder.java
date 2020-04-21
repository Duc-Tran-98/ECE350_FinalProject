package app;

import java.util.*;

public class Decoder {

    private List<Integer> singleErrorsLoc = new ArrayList<>();
    private List<Integer> doubErrorLoc = new ArrayList<>();

    private String[] parityCheck(char[] charBin) {
        boolean[] bb = new boolean[13];
        for (int i = 0; i < charBin.length; i++){
            bb[i] = (charBin[i] == '1') ? true : false;
        }
        String c0 = (bb[0]^bb[3]^bb[5]^bb[6]
                    ^bb[7]^bb[9]^bb[10]^bb[11]^bb[12]) ? "1" : "0";
        String c4 = (bb[8]^bb[9]^bb[10]^bb[11]^bb[12]) ? "1" : "0";
        String c3 = (bb[4]^bb[5]^bb[6]^bb[7]^bb[12]) ? "1" : "0";
        String c2 = (bb[2]^bb[3]^bb[6]^bb[7]^bb[10]^bb[11]) ? "1" : "0";
        String c1 = (bb[1]^bb[3]^bb[5]^bb[7]^bb[9]^bb[11]) ? "1" : "0";
        String[] parityBits = new String[5];
        parityBits[0] = c0;
        parityBits[4] = c4;
        parityBits[3] = c3;
        parityBits[2] = c2;
        parityBits[1] = c1;
        return parityBits;
    }

    private String getBinaryCharacter(char[] encodedBinary){
        int[] ind = {3,5,6,7,9,10,11,12};
        StringBuilder temp = new StringBuilder();
        for (int i : ind){
            temp.append(String.valueOf(encodedBinary[i]));
        }
        return temp.toString();
    }
    
    private String decodeCharacter(char[] charBin, int charInd){
        var parityBits = parityCheck(charBin);
        String posBits = parityBits[4]+parityBits[3]+parityBits[2]+parityBits[1];
        int posValue = Integer.parseInt(posBits, 2);
        int evenCheck = Integer.parseInt(parityBits[0]);
        if (evenCheck == 1 && posValue < 13){
            char bit = (charBin[posValue] == '1') ? '0' : '1';
            charBin[posValue] = bit;
            singleErrorsLoc.add(charInd);
        }else if (posValue > 0){
            doubErrorLoc.add(charInd);
        }
        String decodedBinary = getBinaryCharacter(charBin);
        char character = (char)Integer.parseInt(decodedBinary, 2);
        return String.valueOf(character);
    }

    public String decodeMessage(String binary){
        singleErrorsLoc.clear();
        doubErrorLoc.clear();
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < binary.length(); i+=13){
            String charBin = decodeCharacter(binary.substring(i, i+13).toCharArray(), i/13);
            message.append(charBin);
        }
        String singleErr = "Number of Single Errors Detected: " + singleErrorsLoc.size();
        String doubErr = "Number of Multiple Errors Detected: " + doubErrorLoc.size();
        String finalMessage = message.toString() + "\n" + singleErr + "\n" + doubErr;
        return finalMessage;
    }

}