package example;

/**
 * Created by Lanny Wong on 10/26/15.
 */
public class EmailMessage {

    private String subject;
    private String body;



    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }



    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }



    public EmailMessage(String subject,String body) {
        setSubject(subject);
        setBody(body);


    }







}
