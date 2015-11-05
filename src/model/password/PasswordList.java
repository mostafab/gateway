package model.password;

import java.util.HashMap;

/**
 * Created by Mostafa on 9/28/2015.
 * Class representing a PasswordList data structure. Uses a HashMap of keys and passwords
 * to store the values.
 */
public class PasswordList {

    private HashMap<String, Password> passwords;

    /**
     * Constructs a PasswordList using a HashMap
     * as the backing data structure
     */
    public PasswordList() {
        passwords = new HashMap<String, Password>();
    }

    /**
     * Add a Password to the list
     * @param password password to add
     */
    public void add(Password password) {
        passwords.put(password.getKey(), password);
    }

    /**
     * Remove a Password from the list given a key
     * @param key key of the Password to remove
     */
    public void remove(String key) {
        passwords.remove(key);
    }

    /**
     * Fetch a Password from the list given a key
     * @param key key of the Password to fetch
     * @return Password object
     */
    public Password get(String key) {
        return passwords.get(key);
    }

    /**
     * Check if key exists in PasswordList
     * @param key key to check in HashMap
     * @return true if key in HashMap,
     *          false otherwise
     */
    public boolean contains(String key) {
        return passwords.containsKey(key);
    }

    /**
     * Returns the size of the HashMap
     * @return size of HashMap
     */
    public int size() {
        return passwords.size();
    }

}
