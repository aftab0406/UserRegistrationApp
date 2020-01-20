package com.registration.utility;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * This util class is used for send the mail using JavaMailSender.
 *
 * @author Aftab alam
 * @version 1.0
 * @since Dec30-2019
 */
@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * This method is used for send simple mail.
	 * @param to
	 * @param subject
	 * @param body
	 */
	public void sendMail(String to, String subject, String body) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(body);

		javaMailSender.send(msg);
	}

	/**
	 * This method is used for send MimeMessage (formated Email).
	 * @param to
	 * @param subject
	 * @param body
	 * @throws MessagingException
	 */
	public void sendMimeEmail(String to, String subject, String body) throws MessagingException {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);

			javaMailSender.send(message);
			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
