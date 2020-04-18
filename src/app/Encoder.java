package app;

public class Encoder {

    //Be able to take in binary input for testing and showing off code.
    //Have the option to see the binary version of their message.

    public Encoder(){
        
    }

    private String convertToBinary(String message) {
        StringBuilder binaryMessage = new StringBuilder();
        for (char c : message.toCharArray()){
            String binaryChar = Integer.toBinaryString(c);
            while (binaryChar.length() < 8){
                binaryChar = "0" + binaryChar;
            }
            binaryMessage.append(binaryChar);
        }
        return binaryMessage.toString();
    }

    private String hammingCode(String binary){
        StringBuilder message = new StringBuilder();
        boolean[] bb = new boolean[8];
        for (int i = 0; i < binary.length(); i++){
            bb[i] = (binary.charAt(i) == '1') ? true : false;
        }
        String p0 = (bb[0]^bb[1]^bb[2]^bb[3]^bb[4]^bb[5]^bb[6]^bb[7]) ? "1" : "0";
        String p1 = (bb[0]^bb[1]^bb[3]^bb[4]^bb[6]) ? "1" : "0";
        String p2 = (bb[0]^bb[2]^bb[3]^bb[5]^bb[6]) ? "1" : "0";
        String p3 = (bb[1]^bb[2]^bb[3]^bb[6]^bb[7]) ? "1" : "0";
        String p4 = (bb[4]^bb[5]^bb[6]^bb[7]) ? "1" : "0";
        message.append(p0 + p1 + p2);
        message.append(binary.substring(0, 1));
        message.append(p3);
        message.append(binary.substring(1, 4));
        message.append(p4);
        message.append(binary.substring(4, 8));
        return message.toString();
    }

    private String encodeMessage(String message) {
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i+=8){
            int endInd = (i+8>message.length()) ? message.length() : i+8;
            String binaryChar = message.substring(i, endInd);
            String encodedChar = hammingCode(binaryChar);
            encodedMessage.append(encodedChar);
        }
        return encodedMessage.toString();
    }

    public String encodeString(String message){
        String binaryMessage = convertToBinary(message);
        return encodeMessage(binaryMessage);
    }

    public String encodeBinary(String binary){
        return encodeMessage(binary);
    }

}