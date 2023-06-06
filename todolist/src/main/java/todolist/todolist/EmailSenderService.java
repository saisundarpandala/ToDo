package todolist.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailsender;

    public String sendEmail(String toEmail, String subject, ToDo body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("saisundar1997@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(String.valueOf(body));

        mailsender.send(message);

        return ("Email Sent Successfully...");

    }
}
