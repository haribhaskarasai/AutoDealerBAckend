package com.auto.dealeraudit.service;

import com.auto.dealeraudit.exception.CustomException;

public interface EmailSenderService {
	public abstract int sendEmail(String toEmail)throws CustomException ;
}
