package controller.comm;

/**
 * Created by Mostafa on 9/28/2015.
 * Controller class responsible for processing all the front-end validation in the login screen
 */
public class FrontLoginProcessor {

    private static FrontLoginProcessor instance = new FrontLoginProcessor();

    /**
     * Returns the static FrontLoginProcessor instance
     * @return FrontLoginProcessor instance
     */
    public static FrontLoginProcessor getInstance() {
        return instance;
    }

    /**
     * Validates the username textfield on specified front-end rules
     * @param username username entered
     * @return true if passed,
     *          false otherwise
     */
    private LoginErrorType verifyUsername(String username) {
        if (username == null || username.length() == 0){
            return  LoginErrorType.INCORRECT_USERNAME_FORMATION;
        } else {
            return LoginErrorType.NORMAL;
        }
    }

    /**
     * Validates the password textfield on specified front-end rules
     * @param password password entered
     * @return true if passed,
     *          false otherwise
     */
    private LoginErrorType verifyPassword(String password) {
        if (password == null || password.length() == 0) {
            return LoginErrorType.INCORRECT_PASSWORD_FORMATION;
        } else {
            return LoginErrorType.NORMAL;
        }
    }

    /**
     * Uses the verifyUsername and verifyPassword methods to
     * determine complete front-end validation
     * @param username username entered
     * @param password password entered
     * @return true if passed,
     *          false otherwise
     */
    public LoginErrorType passToBackValidation(String username, String password) {
        LoginErrorType userError = verifyUsername(username);
        LoginErrorType passwordError = verifyPassword(password);
        if (userError == LoginErrorType.INCORRECT_USERNAME_FORMATION) {
            return LoginErrorType.INCORRECT_USERNAME_FORMATION;
        } else if (passwordError == LoginErrorType.INCORRECT_PASSWORD_FORMATION) {
            return LoginErrorType.INCORRECT_PASSWORD_FORMATION;
        } else {
            return BackLoginProcessor.getInstance().verifyUsernamePassword(username, password);
        }
    }


}
