package com.ag.util;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ag.entity.StudentEntity;
import com.ag.service.RegistrationService;

/**
 * This class contains email operation method
 * @author AVNISH SINGH
 * @version 2.2
 */
@Component
public class EmailUtil {
	@Autowired
	RegistrationService service;

	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * This method is used to send email message 
	 * @param mailId
	 * @throws IOException
	 */
	public void sendEmail(String mailId,StudentEntity entity) throws IOException {
		MimeMessage message = mailSender.createMimeMessage();
		String text = service.readMailfromText(entity);
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(mailId);
			helper.setSubject("Testing Boot App");
			helper.setText(text,true);

			mailSender.send(message);
		} catch (MessagingException e) {
			throw new MailParseException(e);
		}

	}
}
