package incomeTracker;

public class ValidationService {

    public void validateUser(String name, String email, String password) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email is not valid.");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
    }

    public void validateIncome(String source, double amount) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("Income source cannot be empty.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Income amount must be positive.");
        }
    }

    public void validateExpense(String category, double amount) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Expense category cannot be empty.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Expense amount must be positive.");
        }
    }
}

