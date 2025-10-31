public class User {
    private String username;
    private String password;
    private String role; // "USER" or "ADMIN"

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role.toUpperCase();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public boolean checkPassword(String pass) {
        return password.equals(pass);
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", role='" + role + '\'' + '}';
    }
}
