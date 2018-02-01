package com.practice.springproject.spring5tutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Smtp")
@Qualifier("SmtpMailSender")
public class SmtpMailSender implements MailSender {
	
	private static Log log = LogFactory.getLog(SmtpMailSender.class);

	@Override
	public void send(String to, String subject, String body) {
		
		log.info("Sending mail fromSMTPMailSender " + to);
		log.info("with subject " + subject);
		log.info("and body " + body);
		
	}

}
