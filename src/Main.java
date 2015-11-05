import controller.ui.SwitchSceneController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    /**
     * Driver method to start application
     * @param primaryStage stage used by application
     * @throws Exception exception if FXML fails to load
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Puffin");
        SwitchSceneController controller = SwitchSceneController.getInstance();
        controller.setStage(primaryStage);
        controller.showMainScreen();
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

}
