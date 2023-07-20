package incomeTracker;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    private final String username; // your email username here
    private final String password; // your email password here

    public EmailService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void sendReport(User user, Report report) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail())
            );
            message.setSubject("Your financial report");

            // Note: Here we're setting a very basic text message. In a real application, 
            // you would want to generate a more detailed message or even a HTML email.
            String reportDetails = "Total income: " + report.getTotalIncome() + "\n" +
                    "Total expenses: " + report.getTotalExpenses() + "\n" +
                    "Balance: " + report.getBalance();
            message.setText(reportDetails);

            Transport.send(message);

            System.out.println("Report sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

