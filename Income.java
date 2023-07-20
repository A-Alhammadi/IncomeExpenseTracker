package incomeTracker;

import java.time.LocalDate;

public class Income {
    private int id;
    private int userId;
    private String source;
    private double amount;
    private LocalDate date;

    public Income(int id, int userId, String source, double amount, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.source = source;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getSource() {
        return source;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}

