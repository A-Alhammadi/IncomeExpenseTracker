package incomeTracker;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {

    // A map to store users by their email
    private Map<String, User> users = new HashMap<>();

    public User register(String name, String email, String password) {
        if (users.containsKey(email)) {
            throw new RuntimeException("A user with this email already exists.");
        }

        User user = new User(generateId(), name, email);
        user.setPassword(password);
        users.put(email, user);
        return user;
    }

    public User login(String email, String password) {
        User user = users.get(email);

        if (user == null) {
            throw new RuntimeException("No user found with this email.");
        }

        if (!user.checkPassword(password)) {
            throw new RuntimeException("Incorrect password.");
        }

        return user;
    }

    // A method to generate a unique user ID.
    private int generateId() {
        return users.size() + 1;
    }
}
