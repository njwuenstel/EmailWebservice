package example;
import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





/**
 * Created by Lanny Wong on 10/26/15.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
    // The Java method will process HTTP GET requests
    @GET
    @Path("/{param}")
    @Produces("text/html")
    public String getClichedMessage(@PathParam("param") String msg) {
        // Return some cliched textual content
        return "Hello " + msg;
    }








    public void sendEmail(EmailMessage emailMessage) {

            final String username = "slackTeamTest@gmail.com";
            final String password = "weLoveSlack";

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
                message.setFrom(new InternetAddress("slackTeamTest@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("slackTeamTest@gmail.com"));
                message.setSubject(emailMessage.getSubject());
                message.setText(emailMessage.getBody());

                Transport.send(message);

                System.out.println("Your email has been sent");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }









    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9999/");

        HelloWorld tester = new HelloWorld();

        String subject = "This is the subject line.";
        String body = "This is the body messages.";



        EmailMessage message = new EmailMessage(subject, body);



        server.start();

        tester.sendEmail(message);


        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9999/helloworld");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
