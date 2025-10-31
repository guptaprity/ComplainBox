import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private List<User> users;

    public LoginManager() {
        users = new ArrayList<>();
        users.add(new User("john", "1234", "USER"));
        users.add(new User("alice", "pass", "USER"));
        users.add(new User("admin", "admin123", "ADMIN"));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.checkPassword(password)) {
                return u;
            }
        }
        return null;
    }

    public boolean usernameExists(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
