package com.ag.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ag.repository.RegistrationRepository;
import com.ag.util.ForgetPwdEmail;

/**
 * This class contain login business operation method
 * 
 * @author AVNISH SINGH
 * @version 2.2
 */
@Service
public class LoginService {

	@Autowired
	RegistrationRepository registrationRepo;

	@Autowired
	ForgetPwdEmail forgetPwd;

	/**
	 * This method is used to perform login operation
	 * 
	 * @param emailId
	 * @param pwd
	 * @return Integer
	 */
	public Integer loginAccount(String emailId, String pwd) {

		return registrationRepo.loginByEmail(emailId, pwd);

	}

	/**
	 * This method is used to perform forget password operation
	 * 
	 * @param emailId
	 * @return String
	 * @throws IOException 
	 */
	public boolean forgetPwd(String emailId) throws IOException {

		String pawzzs = registrationRepo.findPassByEmail(emailId);
		if (pawzzs != null) {

			forgetPwd.sendMsgPwd(emailId, pawzzs);
		}
			
		return pawzzs!=null;
	}

}
