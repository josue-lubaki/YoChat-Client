package client.models;

import static client.utility.utils.capitalize;

public class User {
    private final String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return capitalize(username);
    }
}
