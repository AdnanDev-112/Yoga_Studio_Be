package com.enterprise.YogaStudio.service.impl;
import com.enterprise.YogaStudio.dto.ReservationMailDTO;
import com.enterprise.YogaStudio.dto.WaitingListEmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.enterprise.YogaStudio.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;

import org.springframework.mail.SimpleMailMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.from.alias}")
    private String fromAlias;


    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    @Override
    public void waitingListMail(String to, WaitingListEmailDTO mail)   {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            Context context = new Context();
            context.setVariable("sessionName", mail.getSessionName());
            context.setVariable("sessionDate", mail.getSessionDate());
            context.setVariable("sessionTime", mail.getSessionTime());
            context.setVariable("sessionInstructor", mail.getSessionInstructor());
            context.setVariable("studioLocation", mail.getStudioLocation());
            context.setVariable("clientName", mail.getClientName());
            String htmlTemplate = templateEngine.process("addedToWaitingList", context);
            helper.setTo(to);
            helper.setSubject(mail.getSubject());
            helper.setText(htmlTemplate, true);
            helper.setFrom(username, fromAlias);
            mailSender.send(mimeMessage);
        }catch (MessagingException e) {
            throw new MailSendException("Failed to send email", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
    System.out.println("Exception while sending email: " + e.getMessage());
    e.printStackTrace();
}


    }

    @Override
    public void reservationConfirmationMail(String to, ReservationMailDTO mail) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            Context context = new Context();
            context.setVariable("sessionName", mail.getSessionName());
            context.setVariable("sessionDate", mail.getSessionDate());
            context.setVariable("sessionTime", mail.getSessionTime());
            context.setVariable("sessionInstructor", mail.getSessionInstructor());
            context.setVariable("studioLocation", mail.getStudioLocation());
            context.setVariable("clientName", mail.getClientName());
            String htmlTemplate = templateEngine.process("reservationConfirmation", context);
            helper.setTo(to);
            helper.setSubject(mail.getSubject());
            helper.setText(htmlTemplate, true);
            helper.setFrom(username, fromAlias);
            mailSender.send(mimeMessage);
            System.out.println("Email Sent");
        }catch (MessagingException e) {
            throw new MailSendException("Failed to send email", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


    }
}

