
package com.fileutility.util;

import static java.awt.SystemColor.text;
import java.util.Objects;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ResetPass {
    public static void main(String[] args) {
        send("sharadugalmugale@gmail.com", "Test", "Test", null);
    }

    public static void send(String to, String subject, String body, java.io.File attachement) {

        // Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        // get Session

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sudhirnarayangomase21@gmail.com", "SUDHIR@987");
            }
        });

        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress("sudhirnarayangomase21@gmail.com"));
            message.setSubject(subject);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            if (Objects.nonNull(attachement)) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(attachement);
                multipart.addBodyPart(attachmentPart);
            }
            message.setText(body, "UTF-8", "html");
            // send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void send(String email, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }}
