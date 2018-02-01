package com.practice.springproject.spring5tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springproject.spring5tutorial.mail.*;

/**
 * @author mavenka
 *
 */
@RestController
public class MailController {

	//can be placed here also @Autowired
	private MailSender mailSender;
	
	//at instance method @Autowired setter injection
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	//If constructor than spring automatically assigns the object to the reference Constructor injection
	//If two beans are implementing the same interface then the below constructor can have the componet bean needed while creating object specified.
	MailController(@Qualifier("SmtpMailSender") MailSender smtp) {
		this.mailSender = smtp;
	}
	
	@RequestMapping("/mail")
	public String mail() {
		mailSender.send("mail@example.com","A New mail","Testing the mail sample");
		
		return "Mail Sent";
	}
}
