package enterprise.java;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import enterprise.java.entity.EmailMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Student on 11/7/2015.
 */
@Path("/sendEmail")
public class EmailDriver {

    // TO TEST: http://localhost:9998/sendEmail/A Test Message/This is the body/slackTeamTest@gmail.com
    // 1. When called takes the pathParams and creates a new EmailMessage
    // 2.
    @GET
    @Path("{sbj}/{msg}/{recipient}")
    @Produces("text/html")
    public String doStuff(@PathParam("sbj") String subject,
                              @PathParam("msg") String body,
                              @PathParam("recipient") String recipient) {

        String feedbackMessage = "Email Sent Successfully";

        EmailMessage message = new EmailMessage(subject,body);
        boolean emailSent = sendEmail(message, recipient);

        if (!emailSent) {
            feedbackMessage = "Failed to send email";
        }

        return feedbackMessage;
    }

    public boolean sendEmail(EmailMessage emailMessage, String recipient) {
        final String username = "slackTeamTest@gmail.com";
        final String password = "weLoveSlack";

        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("slackTeamTest@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("slackTeamTest@gmail.com"));
            message.setSubject(emailMessage.getSubject());
            message.setText(emailMessage.getBody());

            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }
    }

}
