package model.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Mostafa on 9/30/2015.
 * Class representing a SQL Database with methods for connecting to the database and executing SQL commands.
 */
public class SQLDatabase {

    private String databaseName;
    private String databaseFilepath;
    private File filepath;
    private final String directory = System.getProperty("user.dir");

    /**
     * Constructor for a SQLite Database that takes in a String representing the name of the database to be created.
     * You MUST include the extension in databaseName. For example, if I wanted to create a SQLite database named
     * "gateway", I would type "gateway.db" into the constructor. If no database matching the string, one is created.
     * If the '/db' directory does not exist, one is created.
     * @param databaseName name of the database to be created
     */
    public SQLDatabase(String databaseName) {
        this.databaseName = databaseName;
        databaseFilepath = "jdbc:sqlite:" + directory + "/db/" + this.databaseName;
        filepath = new File(directory + "/db");
        if (!filepath.exists()) {
            filepath.mkdirs();
        }
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("databaseFilepath: " + databaseFilepath);
            Connection connection = DriverManager.getConnection(databaseFilepath);
            connection.setAutoCommit(false);
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the name of the database;
     * @return name of the database
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * Returns the filepath of the database;
     * @return relative filepath of the database
     */
    public String getDatabaseFilepath() {
        return databaseFilepath;
    }

    /**
     * Returns a connection to this database, auto-commit is set to false
     * @return the Connection object to the database, null if connection fails
     */
    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(databaseFilepath);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a Statement object linked to the given Connection
     * @param connection The connection to link Statement to
     * @return Statement object linked to connection
     */
    public Statement getStatementFromConnection(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Converts the given query into a SQL command for the
     * given statement
     * @param statement Statement to execute upon
     * @param query SQL query to perform
     */
    public void execute(Statement statement, String query) {
        System.out.println("Executing");
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Attempts to execute a SQL update with the given Statement and query
     * @param statement statement to execute query on
     * @param query SQL query
     * @return true if successful execution, false otherwise
     */
    public boolean updateDatabase(Statement statement, String query) {
        try {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Converts the given query into a SQL command for the
     * given statement and returns a ResultSet containing
     * database entries that pass the query
     * @param statement Statement to execute upon
     * @param query SQL query to perform
     * @return ResultSet containing database entries that pass the SQL query
     */
    public ResultSet searchDatabase(Statement statement, String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Closes a connection to a SQL database.
     * @param connection Connection to close
     */
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes a statament from a SQL database connection
     * @param statement statement to close
     */
    public void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Commits any updates, inserts, or deletes from a SQL database with
     * the give connection
     * @param connection Connection to commit
     */
    public void commitToDatabase(Connection connection) {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a String representation of the database
     * @return name of database
     */
    @Override
    public String toString() {
        return databaseName;
    }


}
