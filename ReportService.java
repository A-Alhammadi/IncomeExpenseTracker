package incomeTracker;

import java.util.ArrayList;
import java.util.List;

public class ReportService {

    // In-memory data storage for simplicity. In a real application, fetch from a database.
    private List<Income> incomes = new ArrayList<>();
    private List<Expense> expenses = new ArrayList<>();

    public Report generateReport(int userId) {
        List<Income> userIncomes = getUserIncomes(userId);
        List<Expense> userExpenses = getUserExpenses(userId);

        double totalIncome = userIncomes.stream().mapToDouble(Income::getAmount).sum();
        double totalExpenses = userExpenses.stream().mapToDouble(Expense::getAmount).sum();

        return new Report(userId, totalIncome, totalExpenses, userIncomes, userExpenses);
    }

    private List<Income> getUserIncomes(int userId) {
        List<Income> userIncomes = new ArrayList<>();

        for (Income income : incomes) {
            if (income.getUserId() == userId) {
                userIncomes.add(income);
            }
        }

        return userIncomes;
    }

    private List<Expense> getUserExpenses(int userId) {
        List<Expense> userExpenses = new ArrayList<>();

        for (Expense expense : expenses) {
            if (expense.getUserId() == userId) {
                userExpenses.add(expense);
            }
        }

        return userExpenses;
    }
}

