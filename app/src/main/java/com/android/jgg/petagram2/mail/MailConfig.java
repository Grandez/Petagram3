package com.android.jgg.petagram2.mail;

import java.util.Properties;

public class MailConfig {

    private final String[][] mailData = {
              {"mail.transport.protocol", "smtp"}
            , {"mail.host", "smtp.gmail.com"}
            , {"mail.smtp.port", "465"}
            , {"mail.smtp.auth", "true"}
            , {"mail.smtp.socketFactory.port", "465"}
            , {"mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"}
            , {"mail.smtp.socketFactory.fallback", "false"}
            , {"mail.smtp.quitwait", "false"}
    };

    private final String[][] userData = {
            {"EMAIL", "un.correo@gmail.com"}
            , {"PASS", "12345678"}
    };

    private static MailConfig c = null;
    private Properties mailProps = null;
    private Properties userProps = null;

    private MailConfig() {
        mailProps = new Properties();
        for (int idx = 0; idx < mailData.length; idx++) {
            mailProps.put(mailData[idx][0], mailData[idx][1]);
        }
        userProps = new Properties();
        for (int idx = 0; idx < userData.length; idx++) {
            userProps.put(userData[idx][0], userData[idx][1]);
        }

    }

    public static MailConfig getInstance() {
        if (c == null) c = new MailConfig();
        return c;
    }

    public Properties getMailProperties() {
        return mailProps;
    }
    public Properties getUserProperties() {
        return userProps;
    }



}
