package com.immigration.employee.batch;

import com.immigration.employee.entities.MailInfoDTO;
import com.immigration.employee.entities.User;
import com.immigration.employee.entities.VisaInformation;
import com.immigration.employee.shared.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.List;

public class ImmigrationStatusProcessor implements ItemProcessor<User, MimeMessage> {

    private static final Logger log = LoggerFactory.getLogger(ImmigrationStatusProcessor.class);

    @Autowired
    private JavaMailSender mailSender;

    private String sender;

    public ImmigrationStatusProcessor(String sender) {
        this.sender = sender;
    }

    @Override
    public MimeMessage process(User user) throws Exception {

        MailInfoDTO gnibMail = new MailInfoDTO();
        gnibMail.setEmailId(user.getEmailId());
        gnibMail.setEmpNbr(user.getN_number());
        gnibMail.setExpiryDate(user.getGnibInformation().getValidTo());


        List<VisaInformation> visas = user.getVisas();
        for (VisaInformation vs : visas) {
            MailInfoDTO visaMail = new MailInfoDTO();
            visaMail.setExpiryDate(vs.getValidTo());
            visaMail.setEmailId(user.getEmailId());
            visaMail.setEmpNbr(user.getN_number());
            visaMail.setVisaForCountry(vs.getCountry());
            this.validateAndPrepareEmail(visaMail, true);
        }

        return this.validateAndPrepareEmail(gnibMail, false);


    }

    private MimeMessage validateAndPrepareEmail(MailInfoDTO mailInfoDTO, boolean indicator) throws MessagingException {
        String system = chooseTheEmailCode(mailInfoDTO, indicator);
        if (DateUtils.isWithinDaysFuture(mailInfoDTO.getExpiryDate(), 60)) {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(mailInfoDTO.getEmailId());
            helper.setSubject(system + " expiry");
            String body = "Hi, " + mailInfoDTO.getEmpNbr() + "\n" +
                    "\n" +
                    "Your " + system + " is expiring on " +
                    new SimpleDateFormat("dd-MM-yyyy").format(mailInfoDTO.getExpiryDate())
                    + ". Please arrange an appointment with immigration/visa office asap."
                    + "\n"
                    + "Talent Team.";
            helper.setText(body);

            log.info("Preparing message for: " + mailInfoDTO.getEmailId());
//            System.out.println(body);
//            System.out.println(mailInfoDTO);
            return message;
        }
        return null;
    }

    private String chooseTheEmailCode(MailInfoDTO mailInfoDTO, boolean indicator) {
        final String GNIB = "gnib";
        final String VISA = "visa";
        String system = GNIB;
        if (indicator) {
            system = mailInfoDTO.getVisaForCountry() + " " + VISA;
        }
        return system;
    }
}