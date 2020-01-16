package com.ag.util;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ag.service.LoginService;

/**
 * This class contains forget password email operation
 * 
 * @author AVNISH SINGH
 *
 */
@Component
public class ForgetPwdEmail {

	@Autowired
	LoginService loginService;

	@Autowired
	JavaMailSender mailSender;
	/**
	 * This method is used to send forgeted password in email
	 * 
	 * @param mailId
	 * @param pwd
	 */

	public void sendMsgPwd(String mailId, String pawzzd) throws IOException {
		MimeMessage message = mailSender.createMimeMessage();
		//String text = service.readMailfromText(entity);

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(mailId);
			helper.setSubject("Testing Boot App");
			helper.setText(pawzzd, true);

			mailSender.send(message);
		} catch (MessagingException e) {
			throw new MailParseException(e);
		}

	}

}
