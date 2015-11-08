package enterprise.java.entity;

/**
 * Created by Student on 11/7/2015.
 */
public class EmailMessage {
    private String subject;
    private String body;

    // Constructor
    public EmailMessage(String subject,String body) {
        setSubject(subject);
        setBody(body);
    }

    // Get/Set for body
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    // Get/Set for subject
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
