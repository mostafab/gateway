package controller.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class responsible for switching between scenes
 */
public class SwitchSceneController {

    private static SwitchSceneController instance = new SwitchSceneController();

    private Scene mainScreen;

    private Stage primaryStage;

    /**
     * Initializes all the necessary screens
     */
    private SwitchSceneController() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
            mainScreen = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the static instance of this controller class
     * @return static SwitchSceneController instance
     */
    public static SwitchSceneController getInstance() {
        return instance;
    }

    /**
     * Sets the primary stage in the Application
     * @param stage new stage for the application
     */
    public void setStage(Stage stage) {
        primaryStage = stage;
    }

    /**
     * Sets the stage's current scene to the mainScreen
     */
    public void showMainScreen() {
        primaryStage.setScene(mainScreen);
    }

}
