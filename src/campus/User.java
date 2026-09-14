
import java.io.Serializable;

// Base class demonstrating Abstraction and Inheritance
public abstract class User implements Serializable {
    private String username;
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return role + ": " + username;
    }
}
