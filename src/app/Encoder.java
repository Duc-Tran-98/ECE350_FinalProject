
public class Encoder {

    public Encoder(){
        
    }

    public String encode(String message){
        for (int i = 0; i < message.length(); i = i + 4){
            int endIndex = i + 4;
            if (endIndex > message.length()){
                endIndex = message.length();
            }
            String subMessage = message.substring(i, endIndex);
            StringBuilder binaryMessage = new StringBuilder(32);
        }
        return null;
    }

}