package model.user;

/**
 * Created by Mostafa on 9/28/2015.
 * Class representing a Client with admin-level privileges.
 */
public class Admin extends Client {

    /**
     * Constructs an Admin object
     * @param name name of the Client
     */
    public Admin(String name) {
        super(name, Privilege.ADMIN);
    }

    /**
     * Sets the privileges of another Client
     * @param p priviledge to set to
     * @param c client whose privilege will be changed
     */
    public void setRights(Privilege p, Client c) {
        c.setPrivilege(p);
    }
}
