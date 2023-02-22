package com.auto.dealeraudit.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.auto.dealeraudit.exception.CustomException;
import com.auto.dealeraudit.service.EmailSenderService;
@Service
public class EmailSenderServiceImpl implements EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public int sendEmail(String toEmail) throws CustomException {
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@stgit.com");
		message.setTo(toEmail);
		int otp = (int)(Math.random()*1000000);
		message.setSubject("!!!-----OTP from F-DAS-----!!!");
		message.setText("Hi there, \n  You have requested to change your password \n please use this OTP within this session ! \n Your OTP is \n "+otp+"\n Kindly don't share it with anyone!");
		try {
			mailSender.send(message);
			return otp;
		} catch (Exception e) {
			throw new CustomException("Failed to send OTP!!!");
		}
		
	}

}
