package com.immigration.employee.batch;

import com.immigration.employee.entities.User;
import com.immigration.employee.shared.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserItemProcessor implements ItemProcessor<User, MimeMessage> {

    private static final Logger log = LoggerFactory.getLogger(UserItemProcessor.class);
    @Autowired
    private JavaMailSender mailSender;


    private String sender;

    public UserItemProcessor(String sender) {
        this.sender = sender;
    }

    @Override
    public MimeMessage process(User user) throws Exception {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(user.getGnibInformation().getValidTo());
        //Todo: trim the time from date
        Date gnibExpiry = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        System.out.println(gnibExpiry);
        if (DateUtils.isWithinDaysFuture(gnibExpiry, 60)) {


            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            Map<String, Object> model = new HashMap<>();
            model.put("name", user.getN_number());
            model.put("date", gnibExpiry);
            helper.setFrom(sender);
            helper.setTo(user.getEmailId());
            helper.setSubject("Test mail");
            helper.setText("Hi, "+user.getN_number()+"\n" +
                    "\n" +
                    "Test mail  -  expiring date  "+gnibExpiry+".");

            log.info("Preparing message for: " + user.getEmailId());

            return message;
        } else
            return null;


    }

}