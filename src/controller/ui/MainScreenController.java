package controller.ui;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Controller class for the start screen. Handles UI controls
 */

public class MainScreenController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label gatewayLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label messageLabel;

    @FXML
    private Label forgotLabel;

    @FXML
    private TilePane logoTilepane;


    /**
     * Initializes the controls and interfaces on the start screen
     */
    @FXML
    public void initialize()  {


        messageLabel.setText("Please login or register a client.");

        registerButton.setOnMouseClicked(event -> {
            //TODO// Switch to registration screen here
        });

        loginButton.setOnMouseClicked(event -> {
//            LoginErrorType status = FrontLoginProcessor.getInstance().passToBackValidation(usernameField.getText(),
//                    passwordField.getText());
//            messageLabel.setText(status.getMessage());
//            if (status == LoginErrorType.NORMAL) {
//                //TODO// Switch to customized user screen
//            }
        });

        playAnimation(750);
    }

    /**
     * Plays a hard-coded animation sequence called in the initialize method
     */
    private void playAnimation(double controlFadeTime) {

        /**
         * This is the animation sequence
         */
        FadeTransition messageLabelfT = createFadeTransition(Duration.millis(0), messageLabel, 0, 0);
        FadeTransition forgotLabelfT = createFadeTransition(Duration.millis(0), forgotLabel, 0, 0);
        FadeTransition usernamefT = createFadeTransition(Duration.millis(0), usernameField, 0, 0);
        FadeTransition passwordfT = createFadeTransition(Duration.millis(0), passwordField, 0, 0);
        FadeTransition registerfT = createFadeTransition(Duration.millis(0), registerButton, 0, 0);
        FadeTransition loginfT = createFadeTransition(Duration.millis(0), loginButton, 0, 0);
        FadeTransition logofT = createFadeTransition(Duration.millis(0), logoTilepane, 0, 0);
        FadeTransition gatewayLabelfT = createFadeTransition(Duration.millis(750), gatewayLabel, 0, 1);


        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(750), gatewayLabel);
        translateTransition.setFromY(gatewayLabel.getLayoutY() - 250);
        translateTransition.setToY(-250);
        translateTransition.setCycleCount(1);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(messageLabelfT, forgotLabelfT, usernamefT, passwordfT,
                registerfT, loginfT, logofT, gatewayLabelfT, translateTransition);
        sequentialTransition.setCycleCount(1);

        sequentialTransition.play();

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1150), wait -> {
            FadeTransition messageLabelfT2 = createFadeTransition(Duration.millis(controlFadeTime), messageLabel, 0, 1);
            FadeTransition forgotLabelfT2 = createFadeTransition(Duration.millis(controlFadeTime), forgotLabel, 0, 1);
            FadeTransition usernamefT2 = createFadeTransition(Duration.millis(controlFadeTime), usernameField, 0, 1);
            FadeTransition passwordfT2 = createFadeTransition(Duration.millis(controlFadeTime), passwordField, 0, 1);
            FadeTransition registerfT2 = createFadeTransition(Duration.millis(controlFadeTime), registerButton, 0, 1);
            FadeTransition loginfT2 = createFadeTransition(Duration.millis(controlFadeTime), loginButton, 0, 1);
            FadeTransition logofT2 = createFadeTransition(Duration.millis(controlFadeTime), logoTilepane, 0, 1);
            messageLabelfT2.play();
            forgotLabelfT2.play();
            usernamefT2.play();
            passwordfT2.play();
            registerfT2.play();
            loginfT2.play();
            logofT2.play();
        }
        ));
        timeline.play();
    }

    /**
     * Create a FadeTransition with desired configuration
     * @param duration How long the transition should last
     * @param node Node to add FadeTransition to
     * @param from FadeTransition from this value
     * @param to FadeTransition to this value
     * @return the appropriate FadeTransition object
     */
    private FadeTransition createFadeTransition(Duration duration, Node node, double from, double to) {
        FadeTransition fadeTransition = new FadeTransition(duration, node);
        fadeTransition.setFromValue(from);
        fadeTransition.setToValue(to);
        fadeTransition.setCycleCount(1);
        return fadeTransition;
    }
}
