package controller.comm;

/**
 * Enum class representing the all possible errors returned from a login attempt.
 */
public enum LoginErrorType {

    NORMAL("Login Successful"), INCORRECT_USERNAME_FORMATION("Incorrect Username Format"),
    INCORRECT_PASSWORD_FORMATION("Incorrect Password Format"),
    NO_SUCH_USER("No Such Client"), INCORRECT_PASSWORD("Incorrect password");

    private String message;

    LoginErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
