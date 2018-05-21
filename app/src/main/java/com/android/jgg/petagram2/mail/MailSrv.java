package com.android.jgg.petagram2.mail;

import java.security.Security;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//Class is extending AsyncTask because this class is going to perform a networking operation
public class MailSrv extends javax.mail.Authenticator {

    private String user;
    private String pwd;

    private Session session;

    private MailConfig cfg = MailConfig.getInstance();

    static {
        Security.addProvider(new JSSEProvider());
    }

    public MailSrv(String user, String pwd){
        this.user = user;
        this.pwd = pwd;
        session = Session.getDefaultInstance(cfg.getMailProperties(), this);
    }


    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pwd);
    }

    public synchronized void sendMail(String subject, String body, String sender, String recipients) throws Exception {
//        try{
            MimeMessage message = new MimeMessage(session);
            DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/plain"));
            message.setSender(new InternetAddress(sender));
            message.setSubject(subject);
            message.setDataHandler(handler);
            if (recipients.indexOf(',') > 0)
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            else
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
            Transport.send(message);
//        }catch(Exception e){

//        }
    }


}
