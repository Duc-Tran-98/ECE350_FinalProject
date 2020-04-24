package app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Launch extends Application {

    private Encoder encoder;
    private Decoder decoder;

    private void createHammingEncoder(){
        encoder = new Encoder();
        decoder = new Decoder();
    }

    private VBox setUpEncoderPane(){
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setSpacing(20.0);
        Text enterMessage = new Text("Enter Message:");
        enterMessage.setFont(new Font("Arial", 20));
        TextField messageInput = new TextField();
        messageInput.setFont(new Font("Arial", 15));
        messageInput.setOnMouseClicked(event ->{
            messageInput.setText("");
        });
        messageInput.setMaxWidth(300);
        Text binaryMessage = new Text("Enter Binary:");
        binaryMessage.setFont(new Font("Arial", 20));
        TextField binaryInput = new TextField();
        binaryInput.setFont(new Font("Arial", 15));
        binaryInput.setOnMouseClicked(event ->{
            binaryInput.setText("");
        });
        binaryInput.setMaxWidth(300);
        binaryInput.setFont(new Font("Arial", 15));
        Button submit = new Button("Submit");
        submit.setMinSize(50, 50);
        TextArea result = new TextArea();
        result.setFont(new Font("Arial", 15));
        result.setEditable(false);
        result.setWrapText(true);
        result.setMaxSize(300, 200);
        result.setMinSize(300, 200);
        submit.setOnAction(event -> {encodeMessage(messageInput, binaryInput, result);});
        vBox.getChildren().addAll(enterMessage, messageInput, binaryMessage, binaryInput, submit, result);
        return vBox;
    }

    private void encodeMessage(TextField message, TextField binary, TextArea result){
        String messageText = message.getText();
        String binaryText = binary.getText();
        if (binaryText.length() > 0 && messageText.length() > 0){
            result.setText("Use only one input field");
        }else if (messageText.length()>0){
            String encodedMessage = encoder.encodeString(messageText);
            result.setText(encodedMessage);
        }else if (binaryText.length() > 0){
            String encodedMessage = encoder.encodeBinary(binaryText);
            result.setText(encodedMessage);
        }
    }

    private VBox setUpDecoderPane(){
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setSpacing(20.0);
        Text enterMessage = new Text("Enter Encoded Binary:");
        enterMessage.setFont(new Font("Arial", 20));
        TextField messageInput = new TextField();
        messageInput.setFont(new Font("Arial", 15));
        messageInput.setOnMouseClicked(event ->{
            messageInput.setText("");
        });
        messageInput.setMaxWidth(300);
        TextArea result = new TextArea();
        result.setFont(new Font("Arial", 15));
        result.setEditable(true);
        result.setWrapText(true);
        result.setMaxSize(300, 200);
        result.setMinSize(300, 200);
        Button submit = new Button("Submit");
        submit.setMinSize(50, 50);
        submit.setOnAction(event -> {decodeMessage(messageInput, result);});
        vBox.getChildren().addAll(enterMessage, messageInput, submit, result);
        return vBox;
    }

    private void decodeMessage(TextField message, TextArea result){
        String messageText = message.getText();
        if (messageText.length() > 0){
            String decodedMessage = decoder.decodeMessage(messageText);
            result.setText(decodedMessage);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        createHammingEncoder();
        SplitPane splPane = new SplitPane();
        VBox encoderPane = setUpEncoderPane();
        VBox decoderPane = setUpDecoderPane();
        splPane.getItems().addAll(encoderPane, decoderPane);
        Scene scene = new Scene(splPane);
        setUpStage(stage, scene);
        stage.show();
    }

    private void setUpStage(Stage stage, Scene scene) {
        stage.setTitle("Hamming Encoder Final Project");
        stage.setWidth(1000.0);
        stage.setHeight(700.0);
        stage.setScene(scene);
        stage.setResizable(false);
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }

}