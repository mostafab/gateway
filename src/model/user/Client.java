package model.user;

import model.password.PasswordList;

/**
 * Created by Mostafa on 9/28/2015.
 * Abstract class of a Client object. Clients
 * have a name, PasswordList, and a Privilege.
 */
public abstract class Client {

    private String name;
    private PasswordList passwordList;
    private Privilege privilege;

    /**
     * Constructs a Client with the given name and privilege
     * @param name name of the Client
     * @param privilege Privilege of the client
     */
    public Client(String name, Privilege privilege) {
        this.name = name;
        this.privilege = privilege;
        passwordList = new PasswordList();
    }

    /**
     * Constructs a Client with the given name and a default
     * privilege of GUEST
     * @param name name of the guest
     */
    public Client(String name) {
        this(name, Privilege.GUEST);
    }

    /**
     * Gets the name of the client
     * @return name of the Client
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the new name of the Client
     * @param name new name of the Client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the PasswordList of the client
     * @return PasswordList of the Client
     */
    public PasswordList getPasswordList() {
        return passwordList;
    }

    /**
     * Gets the Privilege of the Client
     * @return privilege of the Client
     */
    public Privilege getPrivilege() {
        return privilege;
    }

    /**
     * Sets the new privilege of the Client
     * @param p new Privilege of the Client
     */
    public void setPrivilege(Privilege p) {
        this.privilege = p;
    }


}
