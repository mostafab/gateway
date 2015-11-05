package model.password;

/**
 * Created by Mostafa on 9/28/2015.
 * Class representing a Password object. Each Password object has a key, meaning what the Password is for,
 * a char sequence representing the actual password, and a visibility boolean representing whether or not the
 * password is visible in the user interface.
 */
public class Password implements Comparable<Password> {

    private String key;
    private char[] sequence;
    private boolean visibility;

    /**
     * Constructs a Password object given a key, sequence, and visibility)
     * @param key key of what the Password is for
     * @param sequence String representing the password
     * @param visibility boolean representing whether or not password is visible
     */
    public Password(String key, String sequence, boolean visibility) {
        this.key = key;
        this.sequence = sequence.toCharArray();
        this.visibility = visibility;
    }

    /**
     * Constructs a Password object given a key and sequence
     * @param key key of what the Password is for
     * @param sequence String representing the password
     */
    public Password(String key, String sequence) {
        this(key, sequence, false);
    }

    /**
     * Gets the key for the Password
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets they key for a Password
     * @param key new key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets the char sequence for the Password
     * @return char sequence
     */
    public char[] getSequence() {
        return sequence;
    }

    /**
     * Sets the key for a Password
     * @param sequence new sequence
     */
    public void setSequence(String sequence) {
        this.sequence = sequence.toCharArray();
    }

    /**
     * Gets the visibility for a Password
     * @return true if visible, false otherwise
     */
    public boolean getVisibility() {
        return visibility;
    }

    /**
     * Sets visibility of a Password
     * @param visibility new visibility
     */
    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    /**
     * equals() method for a Password object
     * @param o other Object to compare to
     * @return true if Passwords are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Password)) {
            return false;
        } else {
            return this.key.equals(((Password) o).key) && this.sequence.equals(((Password) o).sequence);
        }
    }

    /**
     * compareTo() method comparing two Password objects
     * @param p other Password
     * @return -1 if this Password is "less" than the other, 1 if this Password is "greater" than the other,
     * 0 if they are the same
     */
    @Override
    public int compareTo(Password p) {
        return key.compareTo(p.getKey());
    }
}
