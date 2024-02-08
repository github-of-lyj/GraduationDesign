package lyj.service.impl;

import lyj.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    // 发送简单邮件
    @Override
    public void sendSimpleMall(String to, String subject, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setCc(from);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendAttachFileMail(String to, String subject, String content, File file) {

    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {

    }
}
