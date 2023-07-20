package incomeTracker;

import java.util.List;

public class Report {
    private int userId;
    private double totalIncome;
    private double totalExpenses;
    private List<Income> incomeItems;
    private List<Expense> expenseItems;

    public Report(int userId, double totalIncome, double totalExpenses, List<Income> incomeItems, List<Expense> expenseItems) {
        this.userId = userId;
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.incomeItems = incomeItems;
        this.expenseItems = expenseItems;
    }

    public int getUserId() {
        return userId;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public List<Income> getIncomeItems() {
        return incomeItems;
    }

    public List<Expense> getExpenseItems() {
        return expenseItems;
    }

    public double getBalance() {
        return totalIncome - totalExpenses;
    }

    // You could add more methods here to calculate other figures for the report,
    // such as the biggest expense, the most common income source, etc.
}

