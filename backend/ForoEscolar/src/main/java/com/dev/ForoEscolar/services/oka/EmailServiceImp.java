package com.dev.ForoEscolar.services.oka;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceImp implements IEmailService{

    @Value("${EMAIL.SENDER}")
    private String emailUser;



    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String [] toUser, String subjet, String menssage) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(emailUser);
        mailMessage.setTo(toUser);
        mailMessage.setSubject(subjet);
        mailMessage.setText(menssage);

        mailSender.send(mailMessage);
    }

    @Override
    public void sendEmailFile(String [] toUser, String subjet, String menssage, File file) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());


            mimeMessageHelper.setFrom(emailUser);
            mimeMessageHelper.setTo(toUser);
            mimeMessageHelper.setSubject(subjet);
            mimeMessageHelper.setText(menssage) ;
            mimeMessageHelper.addAttachment(file.getName(),file); ;

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
