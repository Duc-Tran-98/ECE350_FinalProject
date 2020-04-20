package app;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launch extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFX App");
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }

}