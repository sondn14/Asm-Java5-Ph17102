package com.asm.service;

import javax.mail.MessagingException;
import com.asm.model.MailInfo;

public interface MailService {
	void send(MailInfo mail) throws MessagingException;

	void send(String to, String subject, String body) throws MessagingException;

}
