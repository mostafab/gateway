package model.user;

/**
 * Created by Mostafa on 9/28/2015.
 */
public class GuestUser extends Client {

    public GuestUser(String name) {
        super(name, Privilege.GUEST);
    }
}
