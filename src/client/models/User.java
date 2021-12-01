package client.models;

import static client.utility.utils.capitalize;

/**
 * @author Josue Lubaki & Ismael Coulibaly
 * @version 1.0
 */
public class User {
    private final String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return capitalize(username);
    }
}
