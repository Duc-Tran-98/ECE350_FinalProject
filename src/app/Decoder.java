package app;

public class Decoder {

    private int singleErrors = 0;
    private int dubErrors = 0;

    private String decodeCharacter(String character){
        boolean[] bb = new boolean[13];
        for (int i = 0; i < character.length(); i++){
            bb[i] = (character.charAt(i) == '1') ? true : false;
        }
        String c0 = (bb[0]^bb[3]^bb[5]^bb[6]
                    ^bb[7]^bb[9]^bb[10]^bb[11]^bb[12]) ? "1" : "0";
        String c4 = "1";
        String c3 = "1";
        String c2 = "1";
        String c1 = "1";
        return null;
    }

    public String decodeMessage(String binary){
        numErrors = 0;
        StringBuilder message = new StringBuilder()
        for (int i = 0; i < binary.length(); i+=13){
            String character = decodeCharacter(binary.substring(i, i+13));
            message.append(character);
        }
        System.out.println("Number of Errors Detected: " + numErrors);
        return message.toString();
    }

}