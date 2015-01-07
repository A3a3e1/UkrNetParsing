import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by paulvoropaiev on 1/5/15.
 */
public class MailService {

    final String username = "la3a3el@gmail.com";
    //WRITE HERE CORRECT REAL PASSWORD FROM GMAIL ACCOUNT!!!
    final String password = "tcyt9ucg";

    protected void sendEmail(String text) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("a3a3el@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("voropaiev@gmail.com"));
            message.setSubject("Here are some new blogs for you!");
            message.setText(text);

            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
