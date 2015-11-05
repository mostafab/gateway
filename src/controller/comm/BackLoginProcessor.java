package controller.comm;
import controller.security.Encoder;
import model.database.SQLDatabase;

import java.sql.*;

/**
 * Created by Mostafa on 9/29/2015.
 * Controller class responsible for all back-end validation in the login screen
 */
public class BackLoginProcessor {

    private static BackLoginProcessor instance = new BackLoginProcessor();
    private static SQLDatabase database;
    private String query;

    /**
     * Constructs a BackLoginProcessor by instantiating a
     * SQLDatabase object using the gateway-clients.db.
     * Creates the initial table of LoginInfo if first time
     * using the program.
     */
    private BackLoginProcessor() {

        database = new SQLDatabase("gateway-clients.db");
        Connection connection = database.getConnection();
        Statement statement = database.getStatementFromConnection(connection);
        query = "CREATE TABLE IF NOT EXISTS LoginInfo " +
                "(" +
                "id integer PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "username varchar(255) UNIQUE NOT NULL, " +
                "password varchar(255) NOT NULL " +
                ")";
        database.execute(statement, query);
        database.closeStatement(statement);
        database.commitToDatabase(connection);
        database.closeConnection(connection);
    }

    /**
     * Returns the instance of this class
     * @return a static BackLoginProcessor object
     */
    public static BackLoginProcessor getInstance() {
        return instance;
    }

    /**
     * Checks username and password against the SQL database
     * @param username username entered by user
     * @param password password entered by user
     * @return true if SQL database and given info match, false otherwise
     */
    public LoginErrorType verifyUsernamePassword(String username, String password) {
        username = Encoder.getInstance().encode(username);
        password = Encoder.getInstance().encode(password);
        Connection connection = database.getConnection();
        Statement statement = database.getStatementFromConnection(connection);
        query = String.format("SELECT password FROM LoginInfo WHERE username='%s'", username);
        ResultSet rs = database.searchDatabase(statement, query);
        try {
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    System.out.println("Passwords match!");
                    rs.close();
                    database.closeStatement(statement);
                    database.closeConnection(connection);
                    return LoginErrorType.NORMAL;
                } else {
                    System.out.println("Incorrect password");
                    rs.close();
                    database.closeStatement(statement);
                    database.closeConnection(connection);
                    return LoginErrorType.INCORRECT_PASSWORD;
                }
            } else {
                System.out.println("User doesn't exist");
                rs.close();
                database.closeStatement(statement);
                database.closeConnection(connection);
                return LoginErrorType.NO_SUCH_USER;
            }
        } catch (SQLException e) {
            database.closeStatement(statement);
            database.closeConnection(connection);
            e.printStackTrace();
        }
        return LoginErrorType.NO_SUCH_USER;
    }

    /**
     * Adds a client to the appropriate SQL database
     * @param username username to add
     * @param password password to add
     */
    public void addClientToTable(String username, String password) {

        String userCipher = Encoder.getInstance().encode(username);
        String passCipher = Encoder.getInstance().encode(password);

        Connection connection = database.getConnection();
        Statement statement = database.getStatementFromConnection(connection);
        String insertString = "INSERT INTO LoginInfo (username, password) ";
        String valueString = String.format("VALUES ('%s','%s');", userCipher, passCipher);
        query = insertString + valueString;
        System.out.println(query);
        if (!database.updateDatabase(statement, query)) {
            System.out.println("Duplicate username!");
        }
        database.closeStatement(statement);
        database.commitToDatabase(connection);
        database.closeConnection(connection);
    }


}
